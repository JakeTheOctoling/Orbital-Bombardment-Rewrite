package com.orbitalbombardmentrewrite.proxies;

import com.orbitalbombardmentrewrite.item.LaserGunHighItem;
import com.orbitalbombardmentrewrite.item.LaserGunLowItem;
import com.orbitalbombardmentrewrite.item.LaserGunMedItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "orbitalbombardmentrewrite", value = Dist.CLIENT)
public class HUDTickHandler {

    @SubscribeEvent
    public static void onRenderGuiOverlay(RenderGuiOverlayEvent.Post event) {
        // Only render over the main HUD element (HOTBAR) when no GUI screen is open
        if (!event.getOverlay().id().equals(VanillaGuiOverlay.HOTBAR.id())) {
            return;
        }

        Minecraft mc = Minecraft.getInstance();
        if (mc.screen != null || mc.player == null) {
            return;
        }

        Player player = mc.player;
        ItemStack heldItem = player.getMainHandItem();

        if (heldItem.isEmpty()) {
            return;
        }

        int textColor = 0;
        boolean isLaserGun = false;

        // Check held item type and determine HUD text color
        if (heldItem.getItem() instanceof LaserGunLowItem) {
            textColor = 0x00FFFF; // Aqua / Blue
            isLaserGun = true;
        } else if (heldItem.getItem() instanceof LaserGunMedItem) {
            textColor = 0xFF9900; // Orange
            isLaserGun = true;
        } else if (heldItem.getItem() instanceof LaserGunHighItem) {
            textColor = 0xFF0000; // Red
            isLaserGun = true;
        }

        if (isLaserGun) {
            GuiGraphics guiGraphics = event.getGuiGraphics();
            Font font = mc.font;

            int screenWidth = mc.getWindow().getGuiScaledWidth();
            int screenHeight = mc.getWindow().getGuiScaledHeight();

            int x = (screenWidth / 2) - 80;
            int y = screenHeight - 75;

            // TODO: Read the actual charge value from item NBT/DataComponent
            int currentCharge = 100;

            String text = "Linked Overrider Charge: " + currentCharge;
            guiGraphics.drawString(font, text, x, y, textColor, true);
        }
    }
}