package com.orbitalbombardmentrewrite.models;

import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: ModelSatelite.class */
public class ModelSatelite extends bbo {
    bcu Base;
    bcu base2;
    bcu base3;
    bcu pole;
    bcu crystal;
    bcu Shape1;
    bcu Shape2;
    bcu Shape3;
    bcu Shape4;
    bcu Shape5;
    bcu Shape6;

    public ModelSatelite() {
        this.t = 256;
        this.u = 256;
        this.Base = new bcu(this, 5, 0);
        this.Base.a(0.0f, 0.0f, 0.0f, 16, 10, 16);
        this.Base.a(-8.0f, 14.0f, -8.0f);
        this.Base.b(256, 256);
        this.Base.i = true;
        setRotation(this.Base, 0.0f, 0.0f, 0.0f);
        this.base2 = new bcu(this, 76, 0);
        this.base2.a(0.0f, 0.0f, 0.0f, 14, 1, 14);
        this.base2.a(-7.0f, 13.0f, -7.0f);
        this.base2.b(256, 256);
        this.base2.i = true;
        setRotation(this.base2, 0.0f, 0.0f, 0.0f);
        this.base3 = new bcu(this, 146, 0);
        this.base3.a(0.0f, 0.0f, 0.0f, 12, 1, 12);
        this.base3.a(-6.0f, 12.0f, -6.0f);
        this.base3.b(256, 256);
        this.base3.i = true;
        setRotation(this.base3, 0.0f, 0.0f, 0.0f);
        this.pole = new bcu(this, 199, 0);
        this.pole.a(0.0f, 0.0f, 0.0f, 2, 25, 2);
        this.pole.a(-1.0f, -13.0f, -1.0f);
        this.pole.b(256, 256);
        this.pole.i = true;
        setRotation(this.pole, 0.0f, 0.0f, 0.0f);
        this.Shape1 = new bcu(this, 0, 60);
        this.Shape1.a(0.0f, 0.0f, 0.0f, 6, 1, 6);
        this.Shape1.a(-3.0f, -11.0f, -3.0f);
        this.Shape1.b(256, 256);
        this.Shape1.i = true;
        setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
        this.Shape2 = new bcu(this, 0, 72);
        this.Shape2.a(0.0f, 0.0f, 0.0f, 4, 1, 4);
        this.Shape2.a(-2.0f, -9.0f, -2.0f);
        this.Shape2.b(256, 256);
        this.Shape2.i = true;
        setRotation(this.Shape2, 0.0f, 0.0f, 0.0f);
        this.Shape3 = new bcu(this, 0, 82);
        this.Shape3.a(0.0f, 0.0f, 0.0f, 1, 12, 1);
        this.Shape3.a(4.0f, 0.0f, 4.0f);
        this.Shape3.b(256, 256);
        this.Shape3.i = true;
        setRotation(this.Shape3, 0.0f, 0.0f, 0.0f);
        this.Shape4 = new bcu(this, 10, 82);
        this.Shape4.a(0.0f, 0.0f, 0.0f, 1, 12, 1);
        this.Shape4.a(4.0f, 0.0f, -5.0f);
        this.Shape4.b(256, 256);
        this.Shape4.i = true;
        setRotation(this.Shape4, 0.0f, 0.0f, 0.0f);
        this.Shape5 = new bcu(this, 20, 81);
        this.Shape5.a(0.0f, 0.0f, 0.0f, 1, 13, 1);
        this.Shape5.a(-5.0f, 0.0f, -5.0f);
        this.Shape5.b(256, 256);
        this.Shape5.i = true;
        setRotation(this.Shape5, 0.0f, 0.0f, 0.0f);
        this.Shape6 = new bcu(this, 30, 80);
        this.Shape6.a(0.0f, 0.0f, 0.0f, 1, 13, 1);
        this.Shape6.a(-5.0f, 0.0f, 4.0f);
        this.Shape6.b(256, 256);
        this.Shape6.i = true;
        setRotation(this.Shape6, 0.0f, 0.0f, 0.0f);
        this.crystal = new bcu(this, 0, 37);
        this.crystal.a(0.0f, 0.0f, 0.0f, 7, 7, 7);
        this.crystal.a(-0.4f, -23.0f, 0.0f);
        this.crystal.b(256, 256);
        this.crystal.i = true;
        GL11.glColor4d(255.0d, 255.0d, 255.0d, 255.0d);
        setRotation(this.crystal, -0.45376f, 0.454032f, 0.65f);
    }

    public void a(nn entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.a(entity, f, f1, f2, f3, f4, f5);
        this.Base.a(f5);
        this.base2.a(f5);
        this.base3.a(f5);
        this.pole.a(f5);
        this.crystal.a(f5);
        this.Shape1.a(f5);
        this.Shape2.a(f5);
        this.Shape3.a(f5);
        this.Shape4.a(f5);
        this.Shape5.a(f5);
        this.Shape6.a(f5);
    }

    private void setRotation(bcu model, float x, float y, float z) {
        model.f = x;
        model.g = y;
        model.h = z;
    }

    public void renderAll() {
        this.Base.a(0.0625f);
        this.base2.a(0.0625f);
        this.base3.a(0.0625f);
        this.pole.a(0.0625f);
        this.Shape1.a(0.0625f);
        this.Shape2.a(0.0625f);
        this.Shape3.a(0.0625f);
        this.Shape4.a(0.0625f);
        this.Shape5.a(0.0625f);
        this.Shape6.a(0.0625f);
    }
}
