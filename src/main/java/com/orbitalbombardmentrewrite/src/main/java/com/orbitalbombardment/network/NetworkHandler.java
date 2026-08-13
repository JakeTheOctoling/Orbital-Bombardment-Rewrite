package com.example.orbitalbombardment.network;

import com.example.orbitalbombardment.OrbitalBombardment;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class NetworkHandler {

    private static final String PROTOCOL_VERSION = "1";

    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(OrbitalBombardment.MODID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals);

    public static void register(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            int id = 0;
            CHANNEL.registerMessage(id++, StrikeEffectPacket.class,
                    StrikeEffectPacket::encode, StrikeEffectPacket::decode, StrikeEffectPacket::handle);
        });
    }
}
