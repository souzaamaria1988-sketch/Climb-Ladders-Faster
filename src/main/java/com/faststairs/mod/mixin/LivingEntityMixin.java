package com.faststairs.mod.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.faststairs.mod.FastStairsMod;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "travel", at = @At("HEAD"))
    private void modifyStairClimbSpeed(Vec3d movementInput, CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;

        // Check if the entity is a player
        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;

            // Get the block position below the player
            BlockPos posBelow = new BlockPos(Math.floor(player.getX()),
                                              Math.floor(player.getY() - 0.5),
                                              Math.floor(player.getZ()));

            World world = player.getEntityWorld();
            BlockState blockBelow = world.getBlockState(posBelow);

            // Check if the block below is a stair by checking block name
            String blockName = blockBelow.getBlock().getTranslationKey();
            if (blockName != null && blockName.contains("stairs")) {
                // Check if player is moving upward on stairs
                if (player.getVelocity().y > 0) {
                    // Multiply vertical velocity by configured multiplier for faster stair climbing
                    Vec3d currentVelocity = player.getVelocity();
                    player.setVelocity(new Vec3d(currentVelocity.x,
                                                  currentVelocity.y * FastStairsMod.STAIR_CLIMB_SPEED_MULTIPLIER,
                                                  currentVelocity.z));
                }
            }
        }
    }
}
