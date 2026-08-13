package com.example.orbitalbombardment.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class Config {

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.IntValue CAPACITOR_MAX_FE = BUILDER
            .comment("Max FE the capacitor block can store")
            .defineInRange("capacitorMaxFE", 1_000_000, 1_000, Integer.MAX_VALUE);

    public static final ForgeConfigSpec.IntValue CAPACITOR_MAX_TRANSFER = BUILDER
            .comment("Max FE/tick the capacitor can accept from cables/generators")
            .defineInRange("capacitorMaxTransfer", 10_000, 1, Integer.MAX_VALUE);

    public static final ForgeConfigSpec.IntValue STRIKE_FE_COST = BUILDER
            .comment("FE consumed per orbital strike")
            .defineInRange("strikeFECost", 500_000, 0, Integer.MAX_VALUE);

    public static final ForgeConfigSpec.IntValue CAPACITOR_LINK_RANGE = BUILDER
            .comment("Blocks around the player to search for a usable capacitor")
            .defineInRange("capacitorLinkRange", 16, 1, 128);

    public static final ForgeConfigSpec.DoubleValue TARGETING_RANGE = BUILDER
            .comment("Max distance the strike device can raycast to pick a target")
            .defineInRange("targetingRange", 64.0, 4.0, 512.0);

    public static final ForgeConfigSpec.IntValue STRIKE_WARMUP_TICKS = BUILDER
            .comment("Delay in ticks between calling a strike and it landing (20 ticks = 1s)")
            .defineInRange("strikeWarmupTicks", 100, 0, 12000);

    public static final ForgeConfigSpec.IntValue STRIKE_EXPLOSION_RADIUS = BUILDER
            .comment("Explosion radius on impact")
            .defineInRange("strikeExplosionRadius", 6, 1, 64);

    public static final ForgeConfigSpec.BooleanValue STRIKE_CAUSES_FIRE = BUILDER
            .comment("Whether the impact ignites blocks")
            .define("strikeCausesFire", true);

    public static final ForgeConfigSpec.IntValue STRIKE_LIGHTNING_COUNT = BUILDER
            .comment("Number of lightning bolts spawned on impact (0 to disable)")
            .defineInRange("strikeLightningCount", 3, 0, 16);

    public static final ForgeConfigSpec SPEC = BUILDER.build();

    public static void register() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SPEC);
    }
}
