package com.orbitalbombardmentrewrite.models;

import orbitalBombardment.blocks.DefenderTileEntity;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: TileEntityDefenderRenderer.class */
public class TileEntityDefenderRenderer extends bje {
    private ModelDefender model = new ModelDefender();
    int rotation;

    public void renderAModelAt(DefenderTileEntity tile, double d, double d1, double d2, float f) {
        if (tile.k != null) {
            this.rotation = tile.p();
        }
        bjo location = new bjo("ob", "textures/blocks/defender.png");
        a(location);
        GL11.glPushMatrix();
        GL11.glTranslatef(((float) d) + 0.5f, ((float) d1) + 1.5f, ((float) d2) + 0.5f);
        GL11.glScalef(1.0f, -1.0f, -1.0f);
        GL11.glRotatef(this.rotation * 90, 0.0f, 1.0f, 0.0f);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(1, 1);
        this.model.Shape7.g = tile.rotate * 90.0f;
        this.model.Shape7.h = tile.rotate * 90.0f;
        this.model.Shape7.h = tile.rotate * 90.0f;
        if (tile.getCurrentCharge() > 0) {
            GL11.glDisable(2896);
        }
        this.model.Shape7.a(0.0625f);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glEnable(2896);
        this.model.renderAll();
        GL11.glPopMatrix();
    }

    public void a(asp par1TileEntity, double par2, double par4, double par6, float par8) {
        renderAModelAt((DefenderTileEntity) par1TileEntity, par2, par4, par6, par8);
    }
}
