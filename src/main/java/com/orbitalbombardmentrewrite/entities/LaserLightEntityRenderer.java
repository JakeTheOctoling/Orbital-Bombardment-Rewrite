package com.orbitalbombardmentrewrite.entities;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class LaserLightEntityRenderer extends EntityRenderer<LaserLightEntity> {

    private static final ResourceLocation TEXTURE = ResourceLocation.tryParse("orbitalbombardmentrewrite:textures/entity/laser_light.png");

    public LaserLightEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(LaserLightEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(LaserLightEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();

        // Apply Z and Y rotations using modern PoseStack
        poseStack.mulPose(Axis.YP.rotationDegrees((float) entity.getAngleZ()));
        poseStack.mulPose(Axis.ZP.rotationDegrees((float) entity.getAngleY()));

        // Scale beam length
        poseStack.scale((float) entity.getRenderSize(), 1.0F, 1.0F);

        poseStack.popPose();
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}