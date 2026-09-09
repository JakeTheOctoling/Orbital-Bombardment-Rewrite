package com.orbitalbombardmentrewrite.models;

import orbitalBombardment.blocks.ExtenderTileEntity;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: TileEntityExtenderRenderer.class */
public class TileEntityExtenderRenderer extends bje {
    private ModelExtender model = new ModelExtender();
    int rotation;

    public void renderAModelAt(ExtenderTileEntity tile, double d, double d1, double d2, float f) {
        if (tile.k != null) {
            this.rotation = tile.p();
        }
        bjo location = new bjo("ob", "textures/blocks/extender.png");
        a(location);
        GL11.glPushMatrix();
        GL11.glTranslatef(((float) d) + 0.5f, ((float) d1) + 1.5f, ((float) d2) + 0.5f);
        GL11.glScalef(1.0f, -1.0f, -1.0f);
        GL11.glRotatef(this.rotation * 90, 0.0f, 1.0f, 0.0f);
        this.model.renderAll();
        GL11.glPopMatrix();
    }

    public void a(asp par1TileEntity, double par2, double par4, double par6, float par8) {
        renderAModelAt((ExtenderTileEntity) par1TileEntity, par2, par4, par6, par8);
    }
}
