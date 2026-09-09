package com.orbitalbombardmentrewrite.block;

import com.orbitalbombardmentrewrite.item.Items;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class Blocks {
    // Modern 1.20.1 Block Registry
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, "orbitalbombardmentrewrite");

    // 1. Laser Low Focus
    public static final RegistryObject<Block> LASER_LOW = registerBlock("laser_low_focus",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(4.0f)
                    .sound(SoundType.METAL)));

    // 2. Orbital Bombardment Overrider (Satelite)
    public static final RegistryObject<Block> SATELITE = registerBlock("satellite_overrider",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(5.0f)
                    .sound(SoundType.METAL)));

    // 3. Photonic Inverter
    public static final RegistryObject<Block> PHOTON_INVERTER = registerBlock("photon_inverter",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(3.5f)
                    .sound(SoundType.METAL)));

    // 4. Advanced Photonic Inverter
    public static final RegistryObject<Block> PHOTON_INVERTER_ADV = registerBlock("photon_inverter_adv",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(4.0f)
                    .sound(SoundType.METAL)));

    // 5. Extender
    public static final RegistryObject<Block> EXTENDER = registerBlock("extender",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(3.0f)
                    .sound(SoundType.METAL)));

    // 6. Launch Satellite
    public static final RegistryObject<Block> LAUNCH_SATELITE = registerBlock("launch_satellite",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(5.0f)
                    .sound(SoundType.METAL)));

    // 7. Photon Decelerator
    public static final RegistryObject<Block> PHOTON_DECELERATOR = registerBlock("photon_decelerator",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(4.0f)
                    .sound(SoundType.METAL)));

    // 8. Photon Accelerator
    public static final RegistryObject<Block> PHOTON_ACCELERATOR = registerBlock("photon_accelerator",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(4.0f)
                    .sound(SoundType.METAL)));

    // 9. Photonic Defender
    public static final RegistryObject<Block> DEFENDER = registerBlock("defender",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(5.0f)
                    .sound(SoundType.METAL)));

    // 10. Defender Laser
    public static final RegistryObject<Block> LASER_DEF = registerBlock("defender_laser",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(4.0f)
                    .sound(SoundType.METAL)));

    // Helper: Automatically registers the block AND creates its matching inventory BlockItem at the same time
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return Items.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    // Called in main mod constructor to register with Forge
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}