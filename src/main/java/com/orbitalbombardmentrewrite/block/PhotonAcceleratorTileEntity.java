package com.orbitalbombardmentrewrite.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
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

public class PhotonAcceleratorTileEntity extends BlockEntity {

    // Internal Forge Energy buffer
    private final CustomEnergyStorage energyStorage = new CustomEnergyStorage(20000, 1000, 1000) {
        @Override
        public void onEnergyChanged() {
            setChanged();
        }
    };

    private final LazyOptional<IEnergyStorage> energyCap = LazyOptional.of(() -> energyStorage);

    // Default 2-argument constructor for 1.20.1 Block instantiation
    public PhotonAcceleratorTileEntity(BlockPos pos, BlockState state) {
        this(BlockEntityType.CHEST, pos, state); // Swap CHEST for your registered BlockEntityType when ready
    }

    // 3-argument constructor for explicit registration
    public PhotonAcceleratorTileEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("Energy", this.energyStorage.getEnergyStored());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        if (tag.contains("Energy")) {
            this.energyStorage.setEnergy(tag.getInt("Energy"));
        }
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

    public int getEnergyStored() {
        return this.energyStorage.getEnergyStored();
    }

    public int getMaxEnergyStored() {
        return this.energyStorage.getMaxEnergyStored();
    }

    // Helper class allowing internal energy level setting during load()
    private static class CustomEnergyStorage extends EnergyStorage {
        public CustomEnergyStorage(int capacity, int maxReceive, int maxExtract) {
            super(capacity, maxReceive, maxExtract);
        }

        public void setEnergy(int energy) {
            this.energy = Math.min(energy, capacity);
        }

        public void onEnergyChanged() {}

        @Override
        public int receiveEnergy(int maxReceive, boolean simulate) {
            int received = super.receiveEnergy(maxReceive, simulate);
            if (received > 0 && !simulate) {
                onEnergyChanged();
            }
            return received;
        }

        @Override
        public int extractEnergy(int maxExtract, boolean simulate) {
            int extracted = super.extractEnergy(maxExtract, simulate);
            if (extracted > 0 && !simulate) {
                onEnergyChanged();
            }
            return extracted;
        }
    }
}