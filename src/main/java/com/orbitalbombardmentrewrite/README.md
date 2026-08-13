# Orbital Bombardment (rewrite skeleton) — Forge 47.4.20 / MC 1.20.1

This is a source skeleton, NOT a full mod. Drop these files into a Forge 1.20.1 MDK
(download from files.minecraftforge.net — do NOT reuse anything from the old 1.6.4 zip,
it predates Gradle/DeferredRegister/capabilities and isn't portable code).

## Setup
1. Download the Forge MDK for 1.20.1 / 47.4.20.
2. Copy `src/main/java/com/example/orbitalbombardment` and
   `src/main/resources/*` from this skeleton into the MDK's matching folders,
   overwriting the example package.
3. Rename the `com.example.orbitalbombardment` package to your own group id if you want
   (update `mods.toml`'s modId only if you also rename the mod id itself).
4. `./gradlew genEclipseRuns` / `genIntellijRuns` as usual, run `runClient`.

## What's implemented
- **Registration**: items, blocks, block entities via `DeferredRegister` (registry package)
- **Energy Capacitor block**: stores FE via a custom `IEnergyStorage` that blocks external
  extraction (`maxExtract = 0`) — only the mod's own strike code can drain it, so cables/other
  mods can charge it but can't siphon it back out
- **Orbital Strike Device item**: raycasts on right-click, finds a nearby capacitor with
  enough charge, drains it, and queues a delayed strike
- **StrikeManager**: server-tick-based delay queue; on impact does a real explosion +
  optional lightning bolts, fire toggle via config
- **Networking**: a `SimpleChannel` sends a "strike incoming" packet to nearby clients so
  they can render a telegraph effect during the warmup (currently a placeholder particle
  column — swap for a real beam renderer)
- **Config**: `ForgeConfigSpec` for capacitor capacity/transfer rate, FE cost, warmup ticks,
  explosion radius, fire, lightning count, targeting range, link range

## What's still a placeholder / needs your design decisions
- **Capacitor linking**: `StrikeManager.findNearbyCapacitor()` just scans a cube around the
  player for the nearest charged capacitor. If you want it tied to a specific bound
  capacitor (like the old mod's satellite-per-player feel) instead of "any capacitor
  nearby", replace this with a linking mechanism (e.g. shift-right-click a capacitor with
  the device to bind its BlockPos into the item's NBT).
- **Client visuals**: the particle column in `StrikeEffectPacket` is a stand-in. A proper
  beam (custom renderer or a stretched entity) plus an impact flash/shockwave visual would
  sell the "orbital" feel a lot better.
- **Block/item models & textures**: none included — you'll need blockstates, models, and
  textures for `energy_capacitor` and `orbital_strike_device`, plus a loot table for the
  capacitor block (BaseEntityBlock blocks need `dropsSelf` or an explicit loot table or they
  won't drop when broken).
- **FE integration with other mods**: since it exposes standard `ForgeCapabilities.ENERGY_STORAGE`,
  any FE-based generator (immersive engineering, mekanism's FE side, etc.) should be able to
  pipe into it with cables already — worth testing against whatever tech mod you're pairing
  it with.
- **Balance**: default FE cost (500k) and capacity (1M) are placeholders, tune to taste.

## Suggested build order from here
1. Get it compiling and loading in-game (fix any Forge version-specific API drift — 1.20.1's
   APIs shift slightly between Forge builds, double check against 47.4.20 specifically)
2. Add blockstate/models so the capacitor renders
3. Wire up real capacitor linking instead of the nearby-scan placeholder
4. Replace the particle telegraph with an actual beam effect
5. Playtest balance
