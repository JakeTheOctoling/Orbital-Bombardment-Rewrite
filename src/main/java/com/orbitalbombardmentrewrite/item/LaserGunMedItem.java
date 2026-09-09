package com.orbitalbombardmentrewrite.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;

public class LaserGunMedItem extends Item {

    public LaserGunMedItem(Properties properties) {
        super(properties.stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide()) {
            // Placeholder right-click feedback until energy/targeting overhaul
            player.sendSystemMessage(Component.literal("Laser Gun (Medium) ready. Target system offline."));
        }

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}