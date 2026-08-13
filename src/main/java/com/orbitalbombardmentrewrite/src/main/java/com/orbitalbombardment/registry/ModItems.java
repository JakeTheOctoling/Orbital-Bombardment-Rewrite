package com.example.orbitalbombardment.registry;

import com.example.orbitalbombardment.OrbitalBombardment;
import com.example.orbitalbombardment.item.OrbitalStrikeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, OrbitalBombardment.MODID);

    // Targeting device - right click a location to queue a strike, consumes FE from the capacitor block
    public static final RegistryObject<Item> ORBITAL_STRIKE_DEVICE = ITEMS.register("orbital_strike_device",
            () -> new OrbitalStrikeItem(new Item.Properties().stacksTo(1).durability(64)));

    // BlockItem for the capacitor, registered here once ModBlocks exists (see ModBlocks static init order)
    public static final RegistryObject<Item> CAPACITOR_ITEM = ITEMS.register("energy_capacitor",
            () -> new BlockItem(ModBlocks.ENERGY_CAPACITOR.get(), new Item.Properties()));
}
