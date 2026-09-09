package com.orbitalbombardmentrewrite.models;

/* JADX INFO: loaded from: ModelPhotonAccelerator.class */
public class ModelPhotonAccelerator extends bbo {
    bcu Shape1;
    bcu Shape2;
    bcu Shape3;
    bcu Shape4;
    bcu Shape5;
    bcu Shape6;
    bcu Shape7;
    bcu Shape8;
    bcu Shape9;
    bcu Shape10;
    bcu Shape11;
    bcu Shape12;

    public ModelPhotonAccelerator() {
        this.t = 128;
        this.u = 32;
        this.Shape1 = new bcu(this, 0, 0);
        this.Shape1.a(-8.0f, -10.0f, -8.0f, 16, 11, 16);
        this.Shape1.a(0.0f, 23.0f, 0.0f);
        this.Shape1.b(128, 32);
        this.Shape1.i = true;
        setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
        this.Shape2 = new bcu(this, 64, 0);
        this.Shape2.a(-7.0f, 0.0f, -7.0f, 14, 1, 14);
        this.Shape2.a(0.0f, 12.0f, 0.0f);
        this.Shape2.b(128, 32);
        this.Shape2.i = true;
        setRotation(this.Shape2, 0.0f, 0.0f, 0.0f);
        this.Shape3 = new bcu(this, 85, 15);
        this.Shape3.a(0.0f, 0.0f, -1.0f, 1, 12, 2);
        this.Shape3.a(-2.0f, 2.0f, 0.0f);
        this.Shape3.b(128, 32);
        this.Shape3.i = true;
        setRotation(this.Shape3, 0.0f, 0.0f, 0.4014257f);
        this.Shape4 = new bcu(this, 85, 15);
        this.Shape4.a(0.0f, 0.0f, 0.0f, 1, 12, 2);
        this.Shape4.a(1.0f, 2.0f, -1.0f);
        this.Shape4.b(128, 32);
        this.Shape4.i = true;
        setRotation(this.Shape4, 0.0f, 0.0f, -0.4120629f);
        this.Shape5 = new bcu(this, 97, 15);
        this.Shape5.a(-1.0f, -12.0f, -1.0f, 4, 13, 4);
        this.Shape5.a(-1.0f, 2.066667f, -1.0f);
        this.Shape5.b(128, 32);
        this.Shape5.i = true;
        setRotation(this.Shape5, 0.0f, 0.0f, 0.0f);
        this.Shape6 = new bcu(this, 85, 16);
        this.Shape6.a(-1.0f, 0.0f, 2.0f, 2, 12, 1);
        this.Shape6.a(0.0f, 2.0f, -1.0f);
        this.Shape6.b(128, 32);
        this.Shape6.i = true;
        setRotation(this.Shape6, 0.3839724f, 0.0f, 0.0f);
        this.Shape7 = new bcu(this, 85, 16);
        this.Shape7.a(0.0f, 0.0f, 0.0f, 2, 12, 1);
        this.Shape7.a(-1.0f, 1.5f, -2.0f);
        this.Shape7.b(128, 32);
        this.Shape7.i = true;
        setRotation(this.Shape7, -0.3839724f, 0.0f, 0.0f);
        this.Shape8 = new bcu(this, 51, 0);
        this.Shape8.a(-3.0f, -3.0f, -3.0f, 6, 1, 6);
        this.Shape8.a(0.0f, 0.0f, 0.0f);
        this.Shape8.b(128, 32);
        this.Shape8.i = true;
        setRotation(this.Shape8, 0.0f, 0.0f, 0.0f);
        this.Shape9 = new bcu(this, 51, 0);
        this.Shape9.a(-3.0f, -1.0f, -3.0f, 6, 1, 6);
        this.Shape9.a(0.0f, 0.0f, 0.0f);
        this.Shape9.b(128, 32);
        this.Shape9.i = true;
        setRotation(this.Shape9, 0.0f, 0.0f, 0.0f);
        this.Shape10 = new bcu(this, 51, 0);
        this.Shape10.a(0.0f, 0.0f, 0.0f, 6, 1, 6);
        this.Shape10.a(-3.0f, -5.0f, -3.0f);
        this.Shape10.b(128, 32);
        this.Shape10.i = true;
        setRotation(this.Shape10, 0.0f, 0.0f, 0.0f);
        this.Shape11 = new bcu(this, 51, 0);
        this.Shape11.a(0.0f, 0.0f, 0.0f, 6, 1, 6);
        this.Shape11.a(-3.0f, -7.0f, -3.0f);
        this.Shape11.b(128, 32);
        this.Shape11.i = true;
        setRotation(this.Shape11, 0.0f, 0.0f, 0.0f);
        this.Shape12 = new bcu(this, 51, 0);
        this.Shape12.a(0.0f, 0.0f, 0.0f, 6, 1, 6);
        this.Shape12.a(-3.0f, -9.0f, -3.0f);
        this.Shape12.b(128, 32);
        this.Shape12.i = true;
        setRotation(this.Shape12, 0.0f, 0.0f, 0.0f);
    }

    public void a(nn entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.a(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        this.Shape1.a(f5);
        this.Shape2.a(f5);
        this.Shape3.a(f5);
        this.Shape4.a(f5);
        this.Shape5.a(f5);
        this.Shape6.a(f5);
        this.Shape7.a(f5);
        this.Shape8.a(f5);
        this.Shape9.a(f5);
        this.Shape10.a(f5);
        this.Shape11.a(f5);
        this.Shape12.a(f5);
    }

    private void setRotation(bcu model, float x, float y, float z) {
        model.f = x;
        model.g = y;
        model.h = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5);
    }

    public void renderAll() {
        this.Shape1.a(0.0625f);
        this.Shape2.a(0.0625f);
        this.Shape3.a(0.0625f);
        this.Shape4.a(0.0625f);
        this.Shape5.a(0.0625f);
        this.Shape6.a(0.0625f);
        this.Shape7.a(0.0625f);
    }
}
