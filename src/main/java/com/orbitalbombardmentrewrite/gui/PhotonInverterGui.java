package com.orbitalbombardmentrewrite.gui;

import orbitalBombardment.lib.OBConstants;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: PhotonInverterGui.class */
public class PhotonInverterGui extends awe {
    bjo texture = new bjo("OB".toLowerCase(), "textures/gui/photonInverter.png");
    public final int xSize = 200;
    public final int ySize = 120;
    uf entity2;

    public PhotonInverterGui(uf entity) {
        this.entity2 = entity;
    }

    public void a(int x, int y, float f1) {
        e();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        atv.w().J().a(this.texture);
        int posX = (this.g - 200) / 2;
        int posY = (this.h - 120) / 2;
        b(posX, posY, 0, 0, 200, 120);
        super.a(x, y, f1);
        this.o.a("Production Rate: " + OBConstants.PhotonInvChargeRate + "PU/t", posX + 30, posY + 40, -1);
    }

    public boolean f() {
        return false;
    }
}
