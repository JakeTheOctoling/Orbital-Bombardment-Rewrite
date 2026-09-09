package com.orbitalbombardmentrewrite.models;

import orbitalBombardment.blocks.ChargeBlockTileEntity;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: TileEntitySateliteRenderer.class */
public class TileEntitySateliteRenderer extends bje {
    private ModelSatelite model = new ModelSatelite();

    public void renderAModelAt(ChargeBlockTileEntity tile, double d, double d1, double d2, float f) {
        int rotation = 0;
        if (tile.k != null) {
            rotation = tile.p();
        }
        bjo location = new bjo("ob", "textures/blocks/satelite.png");
        a(location);
        GL11.glPushMatrix();
        GL11.glTranslatef(((float) d) + 0.5f, ((float) d1) + 1.5f, ((float) d2) + 0.5f);
        GL11.glScalef(1.0f, -1.0f, -1.0f);
        GL11.glRotatef(rotation * 90, 0.0f, 1.0f, 0.0f);
        this.model.crystal.a(Math.abs(tile.rotate) - 5.0f, Math.abs(tile.rotate) - 23.0f, Math.abs(tile.rotate) - 3.0f);
        this.model.crystal.h = tile.rotate;
        this.model.crystal.f = tile.rotate;
        this.model.crystal.g = tile.rotate;
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(1, 1);
        if (tile.getCurrentCharge() > 0) {
            GL11.glDisable(2896);
        }
        this.model.crystal.a(0.0625f);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glEnable(2896);
        this.model.renderAll();
        GL11.glPopMatrix();
    }

    public void a(asp par1TileEntity, double par2, double par4, double par6, float par8) {
        renderAModelAt((ChargeBlockTileEntity) par1TileEntity, par2, par4, par6, par8);
    }
}
