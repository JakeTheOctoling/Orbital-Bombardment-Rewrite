package com.orbitalbombardmentrewrite.models;

import net.minecraftforge.client.IItemRenderer;
import orbitalBombardment.blocks.ChargeBlockTileEntity;

/* JADX INFO: loaded from: ItemSateliteRenderer.class */
public class ItemSateliteRenderer implements IItemRenderer {
    private ModelSatelite SateliteModel = new ModelSatelite();

    public boolean handleRenderType(ye item, IItemRenderer.ItemRenderType type) {
        return true;
    }

    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ye item, IItemRenderer.ItemRendererHelper helper) {
        return true;
    }

    public void renderItem(IItemRenderer.ItemRenderType type, ye item, Object... data) {
        bjd.a.a(new ChargeBlockTileEntity(), 0.0d, 0.0d, 0.0d, 0.0f);
    }
}
