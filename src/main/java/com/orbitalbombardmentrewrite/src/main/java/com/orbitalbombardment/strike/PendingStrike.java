package com.example.orbitalbombardment.strike;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

/** A queued strike, ticking down until impact. Purely server-side. */
public class PendingStrike {

    public final ResourceKey<Level> dimension;
    public final BlockPos targetPos;
    public int ticksRemaining;

    public PendingStrike(ResourceKey<Level> dimension, BlockPos targetPos, int warmupTicks) {
        this.dimension = dimension;
        this.targetPos = targetPos;
        this.ticksRemaining = warmupTicks;
    }
}
