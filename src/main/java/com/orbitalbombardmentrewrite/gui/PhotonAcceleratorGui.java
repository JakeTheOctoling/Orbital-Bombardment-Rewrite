package com.orbitalbombardmentrewrite.gui;

import orbitalBombardment.OrbitalBombardment;
import orbitalBombardment.blocks.PhotonAcceleratorTileEntity;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: PhotonAcceleratorGui.class */
public class PhotonAcceleratorGui extends awe {
    bjo texture = new bjo("OB".toLowerCase(), "textures/gui/photonAccelerator.png");
    public final int xSize = 200;
    public final int ySize = 120;
    uf entity2;

    public PhotonAcceleratorGui(uf entity) {
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
        PhotonAcceleratorTileEntity acceleratorTileEntity = this.entity2.q.r(OrbitalBombardment.instance.lastGeneralX, OrbitalBombardment.instance.lastGeneralY, OrbitalBombardment.instance.lastGeneralZ);
        this.o.a("# Decelerators: " + acceleratorTileEntity.getListSize(), posX + 30, posY + 25, -1);
        this.o.a("Total output rate: " + acceleratorTileEntity.getOutputRate(), posX + 30, posY + 35, -1);
        this.o.a("Scaled output rate: " + acceleratorTileEntity.getScaledOutput(), posX + 30, posY + 45, -1);
    }

    public boolean f() {
        return false;
    }
}
