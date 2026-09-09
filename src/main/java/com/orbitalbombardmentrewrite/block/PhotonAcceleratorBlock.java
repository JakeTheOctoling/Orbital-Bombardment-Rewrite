package com.orbitalbombardmentrewrite.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class PhotonAcceleratorBlock extends BaseEntityBlock {

    public PhotonAcceleratorBlock() {
        super(BlockBehaviour.Properties.of()
                .mapColor(MapColor.METAL)
                .strength(2.0f, 15.0f)
                .sound(SoundType.METAL)
                .noOcclusion());
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof PhotonAcceleratorTileEntity accelerator) {
                // TODO: Open GUI Menu via MenuProvider/NetworkHooks when registered
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    // Modern client-side particle display tick (replaces 1.7.10 random display tick)
    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof PhotonAcceleratorTileEntity accelerator) {
            // Check if active/outputting
            if (accelerator.getEnergyStored() > 0) {
                double x = pos.getX() + 0.5D;
                double y = pos.getY() + 1.0D;
                double z = pos.getZ() + 0.5D;

                for (int i = 0; i <= 2; i++) {
                    double offsetX = (x + random.nextDouble()) + 0.3D - 0.8D;
                    double offsetY = (y + random.nextDouble()) + 0.3D - 0.8D + 1.0D;
                    double offsetZ = (z + random.nextDouble()) + 0.3D - 0.8D;

                    level.addParticle(ParticleTypes.CRIMSON_SPORE, offsetX, offsetY, offsetZ, 0.0D, 0.0D, 0.0D);
                }
            }
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PhotonAcceleratorTileEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return null;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
}