package com.orbitalbombardmentrewrite.models;

import orbitalBombardment.blocks.InverterAdvTileEntity;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: TileEntityInverterAdvRenderer.class */
public class TileEntityInverterAdvRenderer extends bje {
    private ModelPhotonInverter model = new ModelPhotonInverter();
    long rotation;

    public void renderAModelAt(InverterAdvTileEntity tile, double d, double d1, double d2, float f) {
        if (tile.k != null) {
            this.rotation = tile.time;
            if (this.rotation < 6000) {
                this.rotation -= 6000;
            }
            if (this.rotation >= 6000) {
                this.rotation -= 6000;
            }
            if (tile.time > 12000) {
                this.rotation = 0L;
            }
        }
        bjo location = new bjo("ob", "textures/blocks/solarPanel.png");
        a(location);
        GL11.glPushMatrix();
        GL11.glTranslatef(((float) d) + 0.5f, ((float) d1) + 1.5f, ((float) d2) + 0.5f);
        GL11.glScalef(1.0f, -1.0f, -1.0f);
        this.model.Shape3.f = (this.rotation / 15280.0f) * 2.0f;
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model.renderAll();
        GL11.glPopMatrix();
    }

    public void a(asp par1TileEntity, double par2, double par4, double par6, float par8) {
        renderAModelAt((InverterAdvTileEntity) par1TileEntity, par2, par4, par6, par8);
    }
}
