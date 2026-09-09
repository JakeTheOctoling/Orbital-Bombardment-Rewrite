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

public class InverterAdvTileEntity extends BlockEntity {

    // Advanced inverter with higher capacity and generation rate (replaces AdvPhotonInvChargeRate)
    private final CustomEnergyStorage energyStorage = new CustomEnergyStorage(50000, 0, 2000) {
        @Override
        public void onEnergyChanged() {
            setChanged();
        }
    };

    private final LazyOptional<IEnergyStorage> energyCap = LazyOptional.of(() -> energyStorage);

    // Standard 1.20.1 2-argument constructor for BlockEntity
    public InverterAdvTileEntity(BlockPos pos, BlockState state) {
        super(BlockEntityType.CHEST, pos, state); // Swap CHEST for your registered BlockEntityType when ready
    }

    // Modern ticking logic for energy generation per tick
    public static void tick(Level level, BlockPos pos, BlockState state, InverterAdvTileEntity entity) {
        if (!level.isClientSide()) {
            // Advanced generation rate per tick
            entity.energyStorage.generateEnergy(500);
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

    // Custom EnergyStorage implementation allowing set/generate helpers
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