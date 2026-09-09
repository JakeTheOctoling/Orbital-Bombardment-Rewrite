package com.orbitalbombardmentrewrite.proxies;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientProxy extends CommonProxy {

    public ClientProxy() {
        // Constructor left clean
    }

    public void clientSetup(final FMLClientSetupEvent event) {
        // Client-side initialization tasks go here
    }

    @Override
    public void initRenderers() {
        // Handled via event subscribers
    }

    @Override
    public void initSounds() {
        // Handled via event subscribers
    }
}