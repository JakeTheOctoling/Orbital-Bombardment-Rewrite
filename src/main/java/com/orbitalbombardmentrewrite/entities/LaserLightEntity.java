package com.orbitalbombardmentrewrite.entities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

public class LaserLightEntity extends Entity {

    private int ticksAlive = 0;
    private double renderSize;
    private double angleZ;
    private double angleY;

    public LaserLightEntity(EntityType<?> type, Level level) {
        super(type, level);
    }

    public LaserLightEntity(EntityType<?> type, Level level, double xH, double yH, double zH, double xT, double yT, double zT) {
        this(type, level);
        this.setPos(xH, yH, zH);

        double dx = xH - xT;
        double dy = yH - yT;
        double dz = zH - zT;

        this.renderSize = Math.sqrt((dx * dx) + (dy * dy) + (dz * dz));
        this.angleZ = 360.0D - (((Math.atan2(dz, dx) * 180.0D) / Math.PI) + 180.0D);
        this.angleY = ((-Math.atan2(dy, Math.sqrt((this.renderSize * this.renderSize) - (dy * dy)))) * 180.0D) / Math.PI;
    }

    @Override
    protected void defineSynchedData() {
        // Register synched entity data here if needed on client
    }

    @Override
    public void tick() {
        super.tick();
        this.ticksAlive++;

        if (this.ticksAlive > 20) {
            this.discard(); // Modern replacement for C() / setDead()
            this.ticksAlive = 0;
        }
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        this.ticksAlive = tag.getInt("TicksAlive");
        this.renderSize = tag.getDouble("RenderSize");
        this.angleZ = tag.getDouble("AngleZ");
        this.angleY = tag.getDouble("AngleY");
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        tag.putInt("TicksAlive", this.ticksAlive);
        tag.putDouble("RenderSize", this.renderSize);
        tag.putDouble("AngleZ", this.angleZ);
        tag.putDouble("AngleY", this.angleY);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    // Getters for custom rendering
    public double getRenderSize() { return renderSize; }
    public double getAngleZ() { return angleZ; }
    public double getAngleY() { return angleY; }
}