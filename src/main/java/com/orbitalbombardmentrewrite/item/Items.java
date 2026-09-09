package com.orbitalbombardmentrewrite.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items {
    // Modern 1.20.1 Forge item registry
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, "orbitalbombardmentrewrite");

    // Modern Item Registrations
    public static final RegistryObject<Item> DESIGNATOR_LOW = ITEMS.register("designator_low",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DESIGNATOR_MED = ITEMS.register("designator_med",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DESIGNATOR_HIGH = ITEMS.register("designator_high",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LENSE_ITEM = ITEMS.register("lense_item",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LASER_GUN_LOW = ITEMS.register("laser_gun_low",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LASER_GUN_MED = ITEMS.register("laser_gun_med",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LASER_GUN_HIGH = ITEMS.register("laser_gun_high",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> THRUSTER_FUEL = ITEMS.register("thruster_fuel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PHOTON_CONDENSER = ITEMS.register("photon_condenser",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PHOTON_CAPACITOR = ITEMS.register("photon_capacitor",
            () -> new Item(new Item.Properties()));

    // Called in main mod constructor to subscribe to Forge
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}