package com.example.orbitalbombardment.block;

import com.example.orbitalbombardment.block.entity.CapacitorBlockEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

/**
 * Stores FE pushed into it by any generator/cable that supports the Forge energy capability.
 * The orbital strike item drains this block's buffer when it fires.
 */
public class CapacitorBlock extends BaseEntityBlock {

    public CapacitorBlock(Properties properties) {
        super(properties);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(net.minecraft.core.BlockPos pos, BlockState state) {
        return new CapacitorBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, com.example.orbitalbombardment.registry.ModBlockEntities.ENERGY_CAPACITOR.get(),
                CapacitorBlockEntity::serverTick);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, net.minecraft.core.BlockPos pos, Player player,
                                  InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide && level.getBlockEntity(pos) instanceof CapacitorBlockEntity capacitor) {
            player.displayClientMessage(
                    net.minecraft.network.chat.Component.literal(
                            "FE stored: " + capacitor.getEnergyStored() + " / " + capacitor.getMaxEnergyStored()),
                    true);
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
