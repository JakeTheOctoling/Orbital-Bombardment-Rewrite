package com.orbitalbombardmentrewrite.block;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class DefenderTileEntity extends BlockEntity {

    // 1.20.1 Constructor with (BlockPos, BlockState)
    public DefenderTileEntity(BlockPos pos, BlockState state) {
        super(BlockEntityType.CHEST, pos, state); // Swap CHEST for your registered BlockEntityType when ready
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
    }
}