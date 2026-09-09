package com.orbitalbombardmentrewrite.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.energy.IEnergyStorage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class InverterTileEntity extends BlockEntity {

    // Configurable generation rate (adjust max extract/charge rate as needed)
    private final CustomEnergyStorage energyStorage = new CustomEnergyStorage(10000, 0, 500) {
        @Override
        public void onEnergyChanged() {
            setChanged();
        }
    };

    private final LazyOptional<IEnergyStorage> energyCap = LazyOptional.of(() -> energyStorage);

    public InverterTileEntity(BlockPos pos, BlockState state) {
        super(BlockEntityType.CHEST, pos, state); // Replace with registered BlockEntityType later
    }

    // Modern ticking logic for 1.20.1
    public static void tick(Level level, BlockPos pos, BlockState state, InverterTileEntity entity) {
        if (!level.isClientSide()) {
            // Generate energy (replaces setChargeRate logic)
            entity.energyStorage.generateEnergy(100);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("Energy", this.energyStorage.getEnergyStored());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.energyStorage.setEnergy(tag.getInt("Energy"));
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ENERGY) {
            return energyCap.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        energyCap.invalidate();
    }

    // Custom helper class for handling generation internally
    private static class CustomEnergyStorage extends EnergyStorage {
        public CustomEnergyStorage(int capacity, int maxReceive, int maxExtract) {
            super(capacity, maxReceive, maxExtract);
        }

        public void setEnergy(int energy) {
            this.energy = Math.min(energy, capacity);
        }

        public void generateEnergy(int amount) {
            this.energy = Math.min(this.capacity, this.energy + amount);
            onEnergyChanged();
        }

        public void onEnergyChanged() {}
    }
}