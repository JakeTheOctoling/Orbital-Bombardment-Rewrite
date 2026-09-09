package com.orbitalbombardmentrewrite.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import orbitalBombardment.OrbitalBombardment;

/* JADX INFO: loaded from: GuiHandlerForOb.class */
public class GuiHandlerForOb implements IGuiHandler {
    public GuiHandlerForOb() {
        NetworkRegistry.instance().registerGuiHandler(OrbitalBombardment.instance, this);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0001. Please report as an issue. */
    public Object getServerGuiElement(int ID, uf player, abw world, int x, int y, int z) {
        switch (ID) {
        }
        return null;
    }

    public Object getClientGuiElement(int ID, uf player, abw world, int x, int y, int z) {
        switch (ID) {
            case 0:
                return new ChargeBlockGui(player);
            case 1:
                return new PhotonInverterGui(player);
            case 2:
                return new PhotonInverterAdvGui(player);
            case 3:
                return new ExtenderGui(player);
            case 4:
                return new PhotonAcceleratorGui(player);
            case 5:
                return new PhotonDeceleratorGui(player);
            default:
                return null;
        }
    }
}
