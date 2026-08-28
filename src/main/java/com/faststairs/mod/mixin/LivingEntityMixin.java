package com.faststairs.mod.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Inject;
import com.faststairs.mod.FastStairsMod;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "travel", at = @At("TAIL"))
    private void modifyStairClimbSpeed(Vec3d movementInput, CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;

        // Check if the entity is a player
        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            World world = player.getEntityWorld();
            
            // Get the block position the player is standing on
            BlockPos posBelow = new BlockPos(Math.floor(player.getX()),
                                              Math.floor(player.getY() - 0.2),
                                              Math.floor(player.getZ()));

            BlockState blockBelow = world.getBlockState(posBelow);
            
            // Check if the block below is a stair by checking block name
            String blockName = blockBelow.getBlock().getTranslationKey();
            if (blockName != null && blockName.contains("stairs")) {
                // Check if player is moving upward on stairs
                Vec3d velocity = player.getVelocity();
                if (velocity.y > 0.0) {
                    // Multiply vertical velocity by configured multiplier for faster stair climbing
                    player.setVelocity(velocity.x,
                                      velocity.y * FastStairsMod.STAIR_CLIMB_SPEED_MULTIPLIER,
                                      velocity.z);
                }
            }
        }
    }
}
