package com.orbitalbombardmentrewrite.models;

import net.minecraftforge.client.IItemRenderer;
import orbitalBombardment.blocks.SateliteTileEntity;

/* JADX INFO: loaded from: ItemLaunchingSateliteRenderer.class */
public class ItemLaunchingSateliteRenderer implements IItemRenderer {
    private ModelLaunchingSatelite modelLauncher = new ModelLaunchingSatelite();

    public boolean handleRenderType(ye item, IItemRenderer.ItemRenderType type) {
        return true;
    }

    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ye item, IItemRenderer.ItemRendererHelper helper) {
        return true;
    }

    public void renderItem(IItemRenderer.ItemRenderType type, ye item, Object... data) {
        bjd.a.a(new SateliteTileEntity(), 0.0d, 0.0d, 0.0d, 0.0f);
    }
}
