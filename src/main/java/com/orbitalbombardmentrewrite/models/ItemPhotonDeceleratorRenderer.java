package com.orbitalbombardmentrewrite.models;

import net.minecraftforge.client.IItemRenderer;
import orbitalBombardment.blocks.PhotonDeceleratorTileEntity;

/* JADX INFO: loaded from: ItemPhotonDeceleratorRenderer.class */
public class ItemPhotonDeceleratorRenderer implements IItemRenderer {
    private ModelPhotonDecelerator model = new ModelPhotonDecelerator();

    public boolean handleRenderType(ye item, IItemRenderer.ItemRenderType type) {
        return true;
    }

    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ye item, IItemRenderer.ItemRendererHelper helper) {
        return true;
    }

    public void renderItem(IItemRenderer.ItemRenderType type, ye item, Object... data) {
        bjd.a.a(new PhotonDeceleratorTileEntity(), 0.0d, 0.0d, 0.0d, 0.0f);
    }
}
