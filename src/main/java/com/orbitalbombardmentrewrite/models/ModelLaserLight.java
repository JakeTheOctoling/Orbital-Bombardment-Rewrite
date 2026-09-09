package com.orbitalbombardmentrewrite.models;

/* JADX INFO: loaded from: ModelLaserLight.class */
public class ModelLaserLight extends bbo {
    bcu Shape1;

    public ModelLaserLight() {
        this.t = 32;
        this.u = 32;
        this.Shape1 = new bcu(this, 0, 0);
        this.Shape1.a(-1.0f, 0.0f, -1.0f, 2, 10, 2);
        this.Shape1.a(0.0f, -7.0f, 0.0f);
        this.Shape1.b(32, 32);
        this.Shape1.i = true;
        setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
    }

    public void a(nn entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.a(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        this.Shape1.a(f5);
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
    }
}
