package com.orbitalbombardmentrewrite.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class SateliteTileEntity extends BlockEntity {

    public SateliteTileEntity(BlockPos pos, BlockState state) {
        super(BlockEntityType.CHEST, pos, state); // Swap CHEST with your registered BlockEntityType when ready
    }

    public static void tick(Level level, BlockPos pos, BlockState state, SateliteTileEntity entity) {
        if (!level.isClientSide()) {
            // Ticking logic for satellite operation
        }
    }
}
