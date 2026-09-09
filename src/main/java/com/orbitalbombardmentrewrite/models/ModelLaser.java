package com.orbitalbombardmentrewrite.models;

/* JADX INFO: loaded from: ModelLaser.class */
public class ModelLaser extends bbo {
    bcu Shape1;
    bcu Shape2;
    bcu Shape3;
    bcu Shape4;
    bcu Shape5;

    public ModelLaser() {
        this.t = 32;
        this.u = 32;
        this.Shape1 = new bcu(this, 0, 0);
        this.Shape1.a(-2.0f, -19000.0f, -2.0f, 4, 20000, 4);
        this.Shape1.a(0.0f, 23.0f, 0.0f);
        this.Shape1.b(32, 32);
        this.Shape1.i = true;
        setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
        this.Shape2 = new bcu(this, 0, 0);
        this.Shape2.a(8.0f, -19000.0f, 8.0f, 1, 20000, 1);
        this.Shape2.a(0.0f, 23.0f, 0.0f);
        this.Shape2.b(32, 32);
        this.Shape2.i = true;
        setRotation(this.Shape2, 0.0f, 0.0f, 0.0f);
        this.Shape3 = new bcu(this, 0, 0);
        this.Shape3.a(-8.0f, -19000.0f, 8.0f, 1, 20000, 1);
        this.Shape3.a(0.0f, 23.0f, 0.0f);
        this.Shape3.b(32, 32);
        this.Shape3.i = true;
        setRotation(this.Shape3, 0.0f, 0.0f, 0.0f);
        this.Shape4 = new bcu(this, 0, 0);
        this.Shape4.a(8.0f, -19000.0f, -8.0f, 1, 20000, 1);
        this.Shape4.a(0.0f, 23.0f, 0.0f);
        this.Shape4.b(32, 32);
        this.Shape4.i = true;
        setRotation(this.Shape4, 0.0f, 0.0f, 0.0f);
        this.Shape5 = new bcu(this, 0, 0);
        this.Shape5.a(-8.0f, -19000.0f, -8.0f, 1, 20000, 1);
        this.Shape5.a(0.0f, 23.0f, 0.0f);
        this.Shape5.b(32, 32);
        this.Shape5.i = true;
        setRotation(this.Shape5, 0.0f, 0.0f, 0.0f);
    }

    public void renderSpecific(bcu model) {
        model.a(0.0625f);
    }

    public void a(nn entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.a(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        this.Shape1.a(f5);
        this.Shape2.a(f5);
        this.Shape3.a(f5);
        this.Shape4.a(f5);
        this.Shape5.a(f5);
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
    }
}
