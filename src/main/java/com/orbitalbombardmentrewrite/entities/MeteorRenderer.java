package com.orbitalbombardmentrewrite.entities;

/* JADX INFO: loaded from: MeteorRenderer.class */
public class MeteorRenderer extends bhe {
    private static final bjo Your_Texture = new bjo("ob", "textures/entity/meteor.png");

    public MeteorRenderer(bbo par1ModelBase, float par2) {
        super(par1ModelBase, par2);
    }

    protected bjo a(nn entity) {
        return Your_Texture;
    }
}
