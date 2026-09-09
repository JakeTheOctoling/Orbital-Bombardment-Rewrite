package com.orbitalbombardmentrewrite.gui;

import orbitalBombardment.OrbitalBombardment;
import orbitalBombardment.blocks.PhotonDeceleratorTileEntity;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: PhotonDeceleratorGui.class */
public class PhotonDeceleratorGui extends awe {
    bjo texture = new bjo("OB".toLowerCase(), "textures/gui/photonDecelerator.png");
    public final int xSize = 200;
    public final int ySize = 120;
    uf entity2;

    public PhotonDeceleratorGui(uf entity) {
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
        PhotonDeceleratorTileEntity acceleratorTileEntity = this.entity2.q.r(OrbitalBombardment.instance.lastGeneralX, OrbitalBombardment.instance.lastGeneralY, OrbitalBombardment.instance.lastGeneralZ);
        this.o.a("Incoming Rate: " + acceleratorTileEntity.getPowerIncoming(), posX + 30, posY + 35, -1);
        this.o.a("Scaled Power Output: " + acceleratorTileEntity.getScaledOutput(), posX + 30, posY + 45, -1);
    }

    public boolean f() {
        return false;
    }
}
