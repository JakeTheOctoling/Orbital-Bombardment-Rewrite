package com.orbitalbombardmentrewrite.models;

import net.minecraftforge.client.IItemRenderer;
import orbitalBombardment.blocks.DefenderTileEntity;

/* JADX INFO: loaded from: ItemDefenderRenderer.class */
public class ItemDefenderRenderer implements IItemRenderer {
    private ModelDefender model = new ModelDefender();

    public boolean handleRenderType(ye item, IItemRenderer.ItemRenderType type) {
        return true;
    }

    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ye item, IItemRenderer.ItemRendererHelper helper) {
        return true;
    }

    public void renderItem(IItemRenderer.ItemRenderType type, ye item, Object... data) {
        bjd.a.a(new DefenderTileEntity(), 0.0d, 0.0d, 0.0d, 0.0f);
    }
}
