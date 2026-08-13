package com.example.orbitalbombardment.strike;

import com.example.orbitalbombardment.block.entity.CapacitorBlockEntity;
import com.example.orbitalbombardment.config.Config;
import com.example.orbitalbombardment.network.NetworkHandler;
import com.example.orbitalbombardment.network.StrikeEffectPacket;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.network.PacketDistributor;

import java.util.ArrayList;
import java.util.List;

/**
 * Owns the list of pending strikes and ticks them down. Registered on the Forge event bus
 * as a static class (see OrbitalBombardment constructor).
 */
public class StrikeManager {

    private static final List<PendingStrike> PENDING = new ArrayList<>();

    public static void queueStrike(Level level, BlockPos targetPos, Player caster) {
        PendingStrike strike = new PendingStrike(level.dimension(), targetPos, Config.STRIKE_WARMUP_TICKS.get());
        PENDING.add(strike);

        // Tell clients in range to start playing the telegraph beam immediately;
        // the actual explosion is applied server-side only once ticksRemaining hits 0.
        if (level instanceof ServerLevel serverLevel) {
            NetworkHandler.CHANNEL.send(
                    PacketDistributor.TRACKING_CHUNK.with(() -> serverLevel.getChunkAt(targetPos)),
                    new StrikeEffectPacket(targetPos, Config.STRIKE_WARMUP_TICKS.get()));
        }
    }

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase != TickEvent.Phase.END || PENDING.isEmpty()) {
            return;
        }

        PENDING.removeIf(strike -> {
            strike.ticksRemaining--;
            if (strike.ticksRemaining > 0) {
                return false;
            }
            impact(strike);
            return true;
        });
    }

    private static void impact(PendingStrike strike) {
        var server = net.minecraftforge.server.ServerLifecycleHooks.getCurrentServer();
        if (server == null) {
            return;
        }
        ServerLevel level = server.getLevel(strike.dimension);
        if (level == null) {
            return;
        }

        BlockPos pos = strike.targetPos;

        level.explode(null, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                (float) Config.STRIKE_EXPLOSION_RADIUS.get(),
                Config.STRIKE_CAUSES_FIRE.get(),
                Level.ExplosionInteraction.MOB);

        if (Config.STRIKE_LIGHTNING_COUNT.get() > 0) {
            for (int i = 0; i < Config.STRIKE_LIGHTNING_COUNT.get(); i++) {
                var bolt = net.minecraft.world.entity.EntityType.LIGHTNING_BOLT.create(level);
                if (bolt != null) {
                    bolt.moveTo(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
                    bolt.setVisualOnly(i > 0); // only the first bolt does damage, rest are visual
                    level.addFreshEntity(bolt);
                }
            }
        }
    }

    /**
     * Placeholder linking logic: scans a cube around the player for a capacitor block entity.
     * Swap this out for whatever linking scheme you want (e.g. right-click-link a capacitor to
     * bind it to a specific strike device, GPS-style beacon linking, etc).
     */
    public static CapacitorBlockEntity findNearbyCapacitor(Level level, BlockPos origin, int range) {
        for (BlockPos pos : BlockPos.betweenClosed(
                origin.offset(-range, -range, -range), origin.offset(range, range, range))) {
            if (level.getBlockEntity(pos) instanceof CapacitorBlockEntity capacitor && capacitor.hasEnoughForStrike()) {
                return capacitor;
            }
        }
        return null;
    }
}
