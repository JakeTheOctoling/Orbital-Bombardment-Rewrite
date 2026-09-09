package com.orbitalbombardmentrewrite.models;

import net.minecraftforge.client.IItemRenderer;
import orbitalBombardment.blocks.ExtenderTileEntity;

/* JADX INFO: loaded from: ItemExtenderRenderer.class */
public class ItemExtenderRenderer implements IItemRenderer {
    private ModelExtender modelExtender = new ModelExtender();

    public boolean handleRenderType(ye item, IItemRenderer.ItemRenderType type) {
        return true;
    }

    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ye item, IItemRenderer.ItemRendererHelper helper) {
        return true;
    }

    public void renderItem(IItemRenderer.ItemRenderType type, ye item, Object... data) {
        bjd.a.a(new ExtenderTileEntity(), 0.0d, 0.0d, 0.0d, 0.0f);
    }
}
