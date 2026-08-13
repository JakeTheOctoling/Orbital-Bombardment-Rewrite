package com.example.orbitalbombardment.network;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

/** Server -> client: "a strike is inbound at this position, warmupTicks until impact." */
public class StrikeEffectPacket {

    private final BlockPos pos;
    private final int warmupTicks;

    public StrikeEffectPacket(BlockPos pos, int warmupTicks) {
        this.pos = pos;
        this.warmupTicks = warmupTicks;
    }

    public static void encode(StrikeEffectPacket msg, FriendlyByteBuf buf) {
        buf.writeBlockPos(msg.pos);
        buf.writeVarInt(msg.warmupTicks);
    }

    public static StrikeEffectPacket decode(FriendlyByteBuf buf) {
        return new StrikeEffectPacket(buf.readBlockPos(), buf.readVarInt());
    }

    public static void handle(StrikeEffectPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() ->
                net.minecraftforge.fml.DistExecutor.safeRunWhenOn(Dist.CLIENT,
                        () -> () -> handleClient(msg)));
        ctx.get().setPacketHandled(true);
    }

    // Kept in a separate method (not directly referencing client classes at the top level of
    // handle()) so this file class-loads safely on a dedicated server too.
    private static void handleClient(StrikeEffectPacket msg) {
        var level = Minecraft.getInstance().level;
        if (level == null) {
            return;
        }
        // Simple placeholder telegraph: spawn a column of particles up from the target block
        // for the warmup duration. Replace with a proper beam renderer for the real thing.
        for (int y = 0; y < 40; y++) {
            level.addParticle(ParticleTypes.END_ROD,
                    msg.pos.getX() + 0.5, msg.pos.getY() + y, msg.pos.getZ() + 0.5,
                    0, 0, 0);
        }
    }
}
