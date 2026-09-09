package com.orbitalbombardmentrewrite.gui;

import orbitalBombardment.OrbitalBombardment;
import orbitalBombardment.blocks.ChargeBlockTileEntity;
import orbitalBombardment.blocks.ExtenderTileEntity;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: ExtenderGui.class */
public class ExtenderGui extends awe {
    bjo texture = new bjo("OB".toLowerCase(), "textures/gui/extender.png");
    public final int xSize = 200;
    public final int ySize = 120;
    uf entity2;

    public ExtenderGui(uf entity) {
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
        int xC = OrbitalBombardment.instance.lastExtenderX;
        int yC = OrbitalBombardment.instance.lastExtenderY;
        int zC = OrbitalBombardment.instance.lastExtenderZ;
        abw world = this.entity2.q;
        ExtenderTileEntity entity = world.r(xC, yC, zC);
        this.o.a("Photon Charge: " + entity.currentCharge + " PU", posX + 30, posY + 40, -1);
    }

    public boolean f() {
        return false;
    }

    public void a(aut button) {
        switch (button.g) {
            case 0:
                int xC = OrbitalBombardment.instance.lastChargerX;
                int yC = OrbitalBombardment.instance.lastChargerY;
                int zC = OrbitalBombardment.instance.lastChargerZ;
                abw world = this.entity2.q;
                ChargeBlockTileEntity entity = world.r(xC, yC, zC);
                entity.setCurrentCharge(entity.getCurrentCharge() - 30000);
                break;
        }
    }
}
