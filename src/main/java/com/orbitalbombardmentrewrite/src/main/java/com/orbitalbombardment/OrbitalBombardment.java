package com.example.orbitalbombardment;

import com.example.orbitalbombardment.config.Config;
import com.example.orbitalbombardment.network.NetworkHandler;
import com.example.orbitalbombardment.registry.ModBlockEntities;
import com.example.orbitalbombardment.registry.ModBlocks;
import com.example.orbitalbombardment.registry.ModItems;
import com.example.orbitalbombardment.strike.StrikeManager;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.common.MinecraftForge;

@Mod(OrbitalBombardment.MODID)
public class OrbitalBombardment {

    public static final String MODID = "orbitalbombardment";

    public OrbitalBombardment() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.ITEMS.register(modBus);
        ModBlocks.BLOCKS.register(modBus);
        ModBlockEntities.BLOCK_ENTITIES.register(modBus);

        modBus.addListener(this::addToCreativeTab);
        modBus.addListener(NetworkHandler::register);

        MinecraftForge.EVENT_BUS.register(StrikeManager.class);

        Config.register();
    }

    private void addToCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.ORBITAL_STRIKE_DEVICE);
        }
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModItems.CAPACITOR_ITEM);
        }
    }
}
