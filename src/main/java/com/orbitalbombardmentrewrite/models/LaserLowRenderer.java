package com.orbitalbombardmentrewrite.models;

import orbitalBombardment.blocks.LaserLowTileEntity;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: LaserLowRenderer.class */
public class LaserLowRenderer extends bje {
    float comeIn = 0.0f;
    float counter = 0.0f;
    String color = "";
    private ModelLaser model = new ModelLaser();

    public void renderAModelAt(LaserLowTileEntity tile, double d, double d1, double d2, float f) {
        if (tile.k != null) {
        }
        float rotation = tile.rotate;
        this.comeIn = tile.insideCounter;
        float counter = tile.color;
        float f2 = tile.grow;
        int r = (int) (50.0f - counter);
        int g = (int) (50.0f - counter);
        int b = (int) (50.0f - counter);
        bjo location = new bjo("ob", "textures/blocks/laserLow.png");
        a(location);
        GL11.glPushMatrix();
        GL11.glTranslatef(((float) d) + 0.5f, ((float) d1) + 1.5f, ((float) d2) + 0.5f);
        GL11.glScalef(1.0f, -1.0f, -1.0f);
        GL11.glRotatef(rotation * 90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(1, 1);
        if (tile.low) {
            GL11.glColor4d(r, g, 255.0d, 200.0d);
        }
        if (tile.med) {
            GL11.glColor4d(255.0d, 255 + g, b, 200.0d);
        }
        if (tile.high) {
            GL11.glColor4d(255.0d, g, b, 200.0d);
        }
        bcu shape1 = this.model.Shape1;
        this.model.renderSpecific(shape1);
        GL11.glColor4d(1000.0d, 0.0d, 0.0d, 255.0d);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        this.model.Shape2.o = this.comeIn * (-1.0f);
        this.model.Shape2.q = this.comeIn * (-1.0f);
        bcu shape2 = this.model.Shape2;
        this.model.renderSpecific(shape2);
        this.model.Shape3.o = this.comeIn;
        this.model.Shape3.q = this.comeIn * (-1.0f);
        bcu shape3 = this.model.Shape3;
        this.model.renderSpecific(shape3);
        this.model.Shape4.o = this.comeIn * (-1.0f);
        this.model.Shape4.q = this.comeIn;
        bcu shape4 = this.model.Shape4;
        this.model.renderSpecific(shape4);
        this.model.Shape5.o = this.comeIn;
        this.model.Shape5.q = this.comeIn;
        bcu shape5 = this.model.Shape5;
        this.model.renderSpecific(shape5);
        GL11.glPopMatrix();
    }

    public void a(asp par1TileEntity, double par2, double par4, double par6, float par8) {
        renderAModelAt((LaserLowTileEntity) par1TileEntity, par2, par4, par6, par8);
    }
}
