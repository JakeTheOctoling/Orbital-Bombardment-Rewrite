package com.orbitalbombardmentrewrite.models;

import orbitalBombardment.blocks.DefenderLaserTileEntity;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: DefenderLaserRenderer.class */
public class DefenderLaserRenderer extends bje {
    float comeIn = 0.0f;
    float counter = 0.0f;
    String color = "";
    private ModelLaser model = new ModelLaser();

    public void renderAModelAt(DefenderLaserTileEntity tile, double d, double d1, double d2, float f) {
        if (tile.k != null) {
        }
        float rotation = tile.rotate;
        bjo location = new bjo("ob", "textures/blocks/laserLow.png");
        a(location);
        GL11.glPushMatrix();
        GL11.glTranslatef(((float) d) + 0.5f, ((float) d1) + 1.5f, ((float) d2) + 0.5f);
        GL11.glScalef(1.0f, -1.0f, 1.0f);
        GL11.glRotatef(rotation * 90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(1, 1);
        GL11.glColor4d(1.0d, 0.0d, 10.0d, 200.0d);
        this.model.Shape1.g = rotation;
        this.model.renderSpecific(this.model.Shape1);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glPopMatrix();
    }

    public void a(asp par1TileEntity, double par2, double par4, double par6, float par8) {
        renderAModelAt((DefenderLaserTileEntity) par1TileEntity, par2, par4, par6, par8);
    }
}
