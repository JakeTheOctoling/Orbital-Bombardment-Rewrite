package com.example.orbitalbombardment.block.entity;

import com.example.orbitalbombardment.config.Config;
import com.example.orbitalbombardment.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.energy.IEnergyStorage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CapacitorBlockEntity extends BlockEntity {

    /**
     * maxExtract is 0 on the public IEnergyStorage side: nothing external (cables, other mods)
     * can pull energy out. Only drainForStrike() below, called directly by our own item code,
     * can remove energy — it writes to the protected `energy` field directly.
     */
    private static class InternalEnergyStorage extends EnergyStorage {
        InternalEnergyStorage(int capacity, int maxTransfer) {
            super(capacity, maxTransfer, 0);
        }

        int drainInternal(int amount, boolean simulate) {
            int extracted = Math.min(energy, amount);
            if (!simulate) {
                energy -= extracted;
                onEnergyChanged();
            }
            return extracted;
        }
    }

    private final InternalEnergyStorage energyStorage = new InternalEnergyStorage(
            Config.CAPACITOR_MAX_FE.get(), Config.CAPACITOR_MAX_TRANSFER.get()) {
        @Override
        public void onEnergyChanged() {
            setChanged();
        }
    };

    private final LazyOptional<IEnergyStorage> energyCap = LazyOptional.of(() -> energyStorage);

    public CapacitorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ENERGY_CAPACITOR.get(), pos, state);
    }

    public static void serverTick(net.minecraft.world.level.Level level, BlockPos pos, BlockState state,
                                   CapacitorBlockEntity entity) {
        // Room for passive drain, redstone-triggered discharge, comparator output, etc.
    }

    public int getEnergyStored() {
        return energyStorage.getEnergyStored();
    }

    public int getMaxEnergyStored() {
        return energyStorage.getMaxEnergyStored();
    }

    /** Called directly by the orbital strike item — bypasses the 0 external-extract limit. */
    public int drainForStrike(int amount, boolean simulate) {
        return energyStorage.drainInternal(amount, simulate);
    }

    public boolean hasEnoughForStrike() {
        return energyStorage.getEnergyStored() >= Config.STRIKE_FE_COST.get();
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ENERGY_STORAGE) {
            return energyCap.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        energyCap.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("Energy", energyStorage.getEnergyStored());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        energyStorage.deserializeNBT(net.minecraft.nbt.IntTag.valueOf(tag.getInt("Energy")));
    }
}
