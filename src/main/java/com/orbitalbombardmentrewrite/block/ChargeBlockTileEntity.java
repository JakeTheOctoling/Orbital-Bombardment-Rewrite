package com.orbitalbombardmentrewrite.block;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class ChargeBlockTileEntity extends BlockEntity {

    private int currentCharge = 0;
    private int maxCharge = 10000;
    private int shotsLeft = 0;
    private boolean hasSatelite = false;
    private boolean hasSateliteLaunched = false;
    private float rotate = 0.0f;

    public ChargeBlockTileEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    // Ticking logic for 1.20.1
    public static void tick(Level level, BlockPos pos, BlockState state, ChargeBlockTileEntity entity) {
        entity.rotate += 0.025f;
        if (entity.rotate >= 3.141f) {
            entity.rotate = -3.141f;
        }

        if (!level.isClientSide()) {
            // Server-side logic, energy tracking, and satellite checks go here
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("currentCharge", this.currentCharge);
        tag.putInt("shotsLeft", this.shotsLeft);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.currentCharge = tag.getInt("currentCharge");
        this.shotsLeft = tag.getInt("shotsLeft");
    }

    // Getters and Setters
    public int getCurrentCharge() {
        return currentCharge;
    }

    public void setCurrentCharge(int currentCharge) {
        this.currentCharge = currentCharge;
        setChanged(); // Marks block for saving
    }

    public int getShotsLeft() {
        return shotsLeft;
    }

    public void setShotsLeft(int shotsLeft) {
        this.shotsLeft = shotsLeft;
        setChanged();
    }
}