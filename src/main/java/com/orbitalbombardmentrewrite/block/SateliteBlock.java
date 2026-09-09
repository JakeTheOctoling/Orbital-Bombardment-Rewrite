package com.orbitalbombardmentrewrite.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
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

public class SateliteBlock extends BaseEntityBlock {

    public SateliteBlock() {
        super(BlockBehaviour.Properties.of()
                .mapColor(MapColor.METAL)
                .strength(10.0f, 25.0f)
                .sound(SoundType.METAL)
                .noOcclusion());
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof SateliteTileEntity satellite) {
                // TODO: Open satellite control GUI when MenuProvider/NetworkHooks are implemented
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    // Modern replacement for checking if placement on top of ChargeBlockTileEntity is valid
    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockEntity tileBelow = level.getBlockEntity(pos.below());
        return tileBelow instanceof ChargeBlockTileEntity;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SateliteTileEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        // Pass your registered block entity type object here (e.g., ModBlockEntities.SATELLITE.get())
        // For now, if you haven't registered your BlockEntityType yet, you can just return null:
        return null;

        // Once registered, it will look like this:
        // return createTickerHelper(type, ModBlockEntities.SATELLITE_TILE.get(), SateliteTileEntity::tick);
    }
    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
}