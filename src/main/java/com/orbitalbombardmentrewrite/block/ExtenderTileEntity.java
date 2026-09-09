package com.orbitalbombardmentrewrite.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class ExtenderTileEntity extends BlockEntity {

    public ExtenderTileEntity(BlockPos pos, BlockState state) {
        super(BlockEntityType.CHEST, pos, state); // Swap CHEST with your registered BlockEntityType when ready
    }
}