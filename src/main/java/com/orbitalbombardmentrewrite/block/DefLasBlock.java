package com.orbitalbombardmentrewrite.block;

import net.minecraft.core.BlockPos;
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
import org.jetbrains.annotations.Nullable;

public class DefLasBlock extends BaseEntityBlock {

    public DefLasBlock() {
        super(BlockBehaviour.Properties.of()
                .mapColor(MapColor.METAL)
                .strength(10.0f, 25.0f)
                .sound(SoundType.METAL)
                .lightLevel(state -> 15) // Replaces old a(1.0f) light level
                .noOcclusion());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DefenderLaserTileEntity(BlockEntityType.CHEST, pos, state); // Update type when registered
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        // Return null for now to prevent the compilation error
        return null;

        // When you have registered your block entity type, it will look like this:
        // return createTickerHelper(type, ModBlockEntities.DEFENDER_LASER_TILE.get(), DefenderLaserTileEntity::tick);
    }
    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
}