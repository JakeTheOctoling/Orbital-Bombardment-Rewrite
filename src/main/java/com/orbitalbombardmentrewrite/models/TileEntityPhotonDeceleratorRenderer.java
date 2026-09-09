package com.orbitalbombardmentrewrite.models;

import orbitalBombardment.blocks.PhotonDeceleratorTileEntity;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: TileEntityPhotonDeceleratorRenderer.class */
public class TileEntityPhotonDeceleratorRenderer extends bje {
    private ModelPhotonDecelerator model = new ModelPhotonDecelerator();
    int rotation;

    public void renderAModelAt(PhotonDeceleratorTileEntity tile, double d, double d1, double d2, float f) {
        if (tile.k != null) {
            this.rotation = tile.p();
        }
        bjo location = new bjo("ob", "textures/blocks/photonDecelerator.png");
        a(location);
        GL11.glPushMatrix();
        GL11.glTranslatef(((float) d) + 0.5f, ((float) d1) + 1.5f, ((float) d2) + 0.5f);
        GL11.glScalef(1.0f, -1.0f, -1.0f);
        GL11.glRotatef(this.rotation * 90, 0.0f, 1.0f, 0.0f);
        this.model.Shape5.g = tile.rotate * 90.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(1, 1);
        if (tile.getPowerIncoming() > 0) {
            GL11.glDisable(2896);
        }
        this.model.Shape5.a(0.0625f);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glEnable(2896);
        this.model.renderAll();
        GL11.glPopMatrix();
    }

    public void a(asp par1TileEntity, double par2, double par4, double par6, float par8) {
        renderAModelAt((PhotonDeceleratorTileEntity) par1TileEntity, par2, par4, par6, par8);
    }
}
