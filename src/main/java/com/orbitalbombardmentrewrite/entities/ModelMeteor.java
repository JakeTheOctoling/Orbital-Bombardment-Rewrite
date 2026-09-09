package com.orbitalbombardmentrewrite.entities;

/* JADX INFO: loaded from: ModelMeteor.class */
public class ModelMeteor extends bbo {
    bcu Shape1;

    public ModelMeteor() {
        this.t = 64;
        this.u = 32;
        this.Shape1 = new bcu(this, 0, 0);
        this.Shape1.a(-3.0f, 0.0f, -3.0f, 6, 6, 6);
        this.Shape1.a(0.0f, 18.0f, 0.0f);
        this.Shape1.b(64, 32);
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
        super.a(f, f1, f2, f3, f4, f5, (nn) null);
    }

    public void renderAll() {
        this.Shape1.a(0.0625f);
    }
}
