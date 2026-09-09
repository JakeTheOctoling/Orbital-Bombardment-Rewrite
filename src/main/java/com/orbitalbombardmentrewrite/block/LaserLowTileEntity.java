package com.orbitalbombardmentrewrite.block;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class LaserLowTileEntity extends BlockEntity {

    private String color = "blue";

    public LaserLowTileEntity(BlockPos pos, BlockState state) {
        super(BlockEntityType.CHEST, pos, state); // Replace CHEST with your registered BlockEntityType when ready
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putString("BeamColor", this.color);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        if (tag.contains("BeamColor")) {
            this.color = tag.getString("BeamColor");
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        setChanged();
    }
}