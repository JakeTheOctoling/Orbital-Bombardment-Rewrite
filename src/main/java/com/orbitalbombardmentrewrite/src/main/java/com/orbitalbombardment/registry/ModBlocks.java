package com.example.orbitalbombardment.registry;

import com.example.orbitalbombardment.OrbitalBombardment;
import com.example.orbitalbombardment.block.CapacitorBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, OrbitalBombardment.MODID);

    public static final RegistryObject<Block> ENERGY_CAPACITOR = BLOCKS.register("energy_capacitor",
            () -> new CapacitorBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(5.0f, 12.0f)
                    .requiresCorrectToolForDrops()));
}
