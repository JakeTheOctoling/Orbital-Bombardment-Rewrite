package com.orbitalbombardmentrewrite.models;

import orbitalBombardment.blocks.PhotonAcceleratorTileEntity;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: TileEntityPhotonAcceleratorRenderer.class */
public class TileEntityPhotonAcceleratorRenderer extends bje {
    private ModelPhotonAccelerator model = new ModelPhotonAccelerator();
    int rotation;

    public void renderAModelAt(PhotonAcceleratorTileEntity tile, double d, double d1, double d2, float f) {
        float f2 = tile.rotate * 90.0f;
        if (tile.k != null) {
            this.rotation = tile.p();
        }
        bjo location = new bjo("ob", "textures/blocks/photonAccelerator.png");
        a(location);
        GL11.glPushMatrix();
        GL11.glTranslatef(((float) d) + 0.5f, ((float) d1) + 1.5f, ((float) d2) + 0.5f);
        GL11.glScalef(1.0f, -1.0f, -1.0f);
        GL11.glRotatef(this.rotation * 90, 0.0f, 1.0f, 0.0f);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(1, 1);
        if (tile.getOutputRate() > 0) {
            GL11.glDisable(2896);
        }
        this.model.Shape12.a(0.0625f);
        this.model.Shape11.a(0.0625f);
        this.model.Shape10.a(0.0625f);
        this.model.Shape9.a(0.0625f);
        this.model.Shape8.a(0.0625f);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glEnable(2896);
        this.model.renderAll();
        GL11.glPopMatrix();
    }

    public void a(asp par1TileEntity, double par2, double par4, double par6, float par8) {
        renderAModelAt((PhotonAcceleratorTileEntity) par1TileEntity, par2, par4, par6, par8);
    }
}
