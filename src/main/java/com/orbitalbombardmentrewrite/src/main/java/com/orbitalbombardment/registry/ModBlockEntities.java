package com.example.orbitalbombardment.registry;

import com.example.orbitalbombardment.OrbitalBombardment;
import com.example.orbitalbombardment.block.entity.CapacitorBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, OrbitalBombardment.MODID);

    public static final RegistryObject<BlockEntityType<CapacitorBlockEntity>> ENERGY_CAPACITOR =
            BLOCK_ENTITIES.register("energy_capacitor", () -> BlockEntityType.Builder.of(
                    CapacitorBlockEntity::new, ModBlocks.ENERGY_CAPACITOR.get()).build(null));
}
