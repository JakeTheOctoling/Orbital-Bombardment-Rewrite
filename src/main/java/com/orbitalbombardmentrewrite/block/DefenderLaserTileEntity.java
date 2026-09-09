package com.orbitalbombardmentrewrite.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.energy.IEnergyStorage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DefenderLaserTileEntity extends BlockEntity {

    private int ticksCount = 0;
    private float rotate = 0.0f;

    // FE (Forge Energy) Storage Buffer
    private final CustomEnergyStorage energyStorage = new CustomEnergyStorage(10000, 500, 0) {
        @Override
        public void onEnergyChanged() {
            setChanged();
        }
    };

    private final LazyOptional<IEnergyStorage> energyCap = LazyOptional.of(() -> energyStorage);

    public DefenderLaserTileEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    // Modern 1.20.1 Tick Method
    public static void tick(Level level, BlockPos pos, BlockState state, DefenderLaserTileEntity entity) {
        entity.rotate += 1.0E-6f * entity.energyStorage.getEnergyStored();
        if (entity.rotate >= 3.141f) {
            entity.rotate = -3.141f;
        }

        if (entity.ticksCount >= 15) {
            entity.ticksCount = 0;

            if (!level.isClientSide()) {
                // Damage nearby living entities
                List<LivingEntity> targets = getNearbyEntitiesForDamage(level, pos);
                for (LivingEntity target : targets) {
                    target.hurt(level.damageSources().magic(), 10.0f);
                }

                // Check for base defender block underneath; if missing, trigger a minor explosion
                BlockEntity entityBelow = level.getBlockEntity(pos.below());
                if (!(entityBelow instanceof DefenderTileEntity)) {
                    level.explode(null, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 0.1f, Level.ExplosionInteraction.BLOCK);
                }
            }
        }
        entity.ticksCount++;
    }

    private static List<LivingEntity> getNearbyEntitiesForDamage(Level level, BlockPos pos) {
        int radius = 5;
        AABB area = new AABB(pos).inflate(radius);
        return level.getEntitiesOfClass(LivingEntity.class, area);
    }

    // NBT Data Saving & Loading
    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("Energy", this.energyStorage.getEnergyStored());
        tag.putInt("TicksCount", this.ticksCount);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.energyStorage.setEnergy(tag.getInt("Energy"));
        this.ticksCount = tag.getInt("TicksCount");
    }

    // Capability Registration for FE
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

    // Helper Energy Storage Class
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
    }
}