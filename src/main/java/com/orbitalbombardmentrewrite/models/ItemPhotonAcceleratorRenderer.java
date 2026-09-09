package com.orbitalbombardmentrewrite.models;

import net.minecraftforge.client.IItemRenderer;
import orbitalBombardment.blocks.PhotonAcceleratorTileEntity;

/* JADX INFO: loaded from: ItemPhotonAcceleratorRenderer.class */
public class ItemPhotonAcceleratorRenderer implements IItemRenderer {
    private ModelPhotonAccelerator model = new ModelPhotonAccelerator();

    public boolean handleRenderType(ye item, IItemRenderer.ItemRenderType type) {
        return true;
    }

    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ye item, IItemRenderer.ItemRendererHelper helper) {
        return true;
    }

    public void renderItem(IItemRenderer.ItemRenderType type, ye item, Object... data) {
        bjd.a.a(new PhotonAcceleratorTileEntity(), 0.0d, 0.0d, 0.0d, 0.0f);
    }
}
