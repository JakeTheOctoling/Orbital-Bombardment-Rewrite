package com.example.orbitalbombardment.item;

import com.example.orbitalbombardment.block.entity.CapacitorBlockEntity;
import com.example.orbitalbombardment.config.Config;
import com.example.orbitalbombardment.strike.StrikeManager;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

/**
 * Right-click to raycast for a target block. If the player is standing within range of a
 * capacitor with enough FE, queues a delayed orbital strike at that position.
 *
 * This does not itself look for a capacitor block in the world yet — see StrikeManager /
 * findNearbyCapacitor() for the placeholder to wire up before this is usable.
 */
public class OrbitalStrikeItem extends Item {

    public OrbitalStrikeItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        HitResult hit = player.pick(Config.TARGETING_RANGE.get(), 0f, false);
        if (hit.getType() != HitResult.Type.BLOCK) {
            player.displayClientMessage(Component.literal("No target in range."), true);
            return InteractionResultHolder.fail(stack);
        }

        BlockPos targetPos = ((net.minecraft.world.phys.BlockHitResult) hit).getBlockPos().above();

        if (level.isClientSide) {
            return InteractionResultHolder.success(stack);
        }

        CapacitorBlockEntity capacitor = StrikeManager.findNearbyCapacitor(level, player.blockPosition(),
                Config.CAPACITOR_LINK_RANGE.get());

        if (capacitor == null) {
            player.displayClientMessage(Component.literal("No linked capacitor with charge in range."), true);
            return InteractionResultHolder.fail(stack);
        }

        int cost = Config.STRIKE_FE_COST.get();
        int drained = capacitor.drainForStrike(cost, true);
        if (drained < cost) {
            player.displayClientMessage(Component.literal(
                    "Not enough FE: " + capacitor.getEnergyStored() + " / " + cost), true);
            return InteractionResultHolder.fail(stack);
        }
        capacitor.drainForStrike(cost, false);

        StrikeManager.queueStrike(level, targetPos, player);
        stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
        level.playSound(null, player.blockPosition(), SoundEvents.BEACON_ACTIVATE,
                SoundSource.PLAYERS, 1.0f, 0.6f);

        return InteractionResultHolder.consume(stack);
    }
}
