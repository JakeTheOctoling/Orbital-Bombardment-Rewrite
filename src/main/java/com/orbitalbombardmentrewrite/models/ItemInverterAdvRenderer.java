package com.orbitalbombardmentrewrite.models;

import net.minecraftforge.client.IItemRenderer;
import orbitalBombardment.blocks.InverterAdvTileEntity;

/* JADX INFO: loaded from: ItemInverterAdvRenderer.class */
public class ItemInverterAdvRenderer implements IItemRenderer {
    private ModelPhotonInverter model = new ModelPhotonInverter();

    public boolean handleRenderType(ye item, IItemRenderer.ItemRenderType type) {
        return true;
    }

    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ye item, IItemRenderer.ItemRendererHelper helper) {
        return true;
    }

    public void renderItem(IItemRenderer.ItemRenderType type, ye item, Object... data) {
        bjd.a.a(new InverterAdvTileEntity(), 0.0d, 0.0d, 0.0d, 0.0f);
    }
}
