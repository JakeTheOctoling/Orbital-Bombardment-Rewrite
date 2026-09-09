package com.orbitalbombardmentrewrite.entities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraftforge.network.NetworkHooks;

public class MeteorEntity extends Entity {
    private int ticksAlive;

    public MeteorEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
        this.noPhysics = false;
    }

    public MeteorEntity(Level level, double x, double y, double z) {
        super(EntityType.FALLING_BLOCK, level);
        this.setPos(x, y, z);

        java.util.Random veloRan = new java.util.Random();
        float choose = veloRan.nextFloat();
        double vx = 0, vy = 0, vz = 0;

        if (choose > 0.5f) {
            vx = veloRan.nextFloat() * -2.0f;
            vy = veloRan.nextFloat() * 2.0f;
            vz = veloRan.nextFloat() * 2.0f;
        } else {
            vx = veloRan.nextFloat() * 2.0f;
            vy = veloRan.nextFloat() * -2.0f;
            vz = veloRan.nextFloat() * -2.0f;
        }

        this.setDeltaMovement(vx, vy, vz);
    }

    @Override
    protected void defineSynchedData() {}

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
        this.ticksAlive = compound.getInt("TicksAlive");
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putInt("TicksAlive", this.ticksAlive);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void tick() {
        super.tick();
        this.ticksAlive++;

        Level level = this.level();

        if (level.isClientSide()) {
            java.util.Random random = new java.util.Random();
            for (int i = 0; i < 4; i++) {
                double px = this.getX() + (random.nextDouble() - 0.5) * 0.6;
                double py = this.getY() + 0.5 + (random.nextDouble() - 0.5) * 0.6;
                double pz = this.getZ() + (random.nextDouble() - 0.5) * 0.6;
                level.addParticle(ParticleTypes.EXPLOSION_EMITTER, px, py, pz, 0.0D, 0.0D, 0.0D);
            }
        }

        if (!level.isClientSide()) {
            if (this.ticksAlive >= 120 || this.horizontalCollision || this.verticalCollision) {
                level.explode(this, this.getX(), this.getY(), this.getZ(), 4.0f, Level.ExplosionInteraction.TNT);
                this.discard();
            }
        }
    }
}