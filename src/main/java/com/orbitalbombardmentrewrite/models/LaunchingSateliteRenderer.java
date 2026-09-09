package com.orbitalbombardmentrewrite.models;

import orbitalBombardment.blocks.SateliteTileEntity;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: LaunchingSateliteRenderer.class */
public class LaunchingSateliteRenderer extends bje {
    private ModelLaunchingSatelite model = new ModelLaunchingSatelite();
    int rotation;

    public void renderAModelAt(SateliteTileEntity tile, double d, double d1, double d2, float f) {
        float height = tile.height;
        if (tile.k != null) {
            this.rotation = tile.p();
        }
        bjo location = new bjo("ob", "textures/blocks/launchingSatelite.png");
        a(location);
        GL11.glPushMatrix();
        GL11.glTranslatef(((float) d) + 0.5f, ((float) d1) + 1.5f, ((float) d2) + 0.5f);
        GL11.glScalef(1.0f, -1.0f, -1.0f);
        GL11.glRotatef(this.rotation * 90, 0.0f, 1.0f, 0.0f);
        this.model.Shape1.p = height * (-1.0f);
        this.model.Shape2.p = height * (-1.0f);
        this.model.Shape3.p = height * (-1.0f);
        this.model.Shape4.p = height * (-1.0f);
        this.model.Shape5.p = height * (-1.0f);
        this.model.Shape6.p = height * (-1.0f);
        this.model.renderAll();
        GL11.glPopMatrix();
    }

    public void a(asp par1TileEntity, double par2, double par4, double par6, float par8) {
        renderAModelAt((SateliteTileEntity) par1TileEntity, par2, par4, par6, par8);
    }
}
