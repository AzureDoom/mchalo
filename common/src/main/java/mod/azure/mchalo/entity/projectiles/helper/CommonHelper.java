package mod.azure.mchalo.entity.projectiles.helper;

import mod.azure.azurelib.common.internal.common.blocks.TickingLightEntity;
import mod.azure.azurelib.common.internal.common.registry.AzureBlocksRegistry;
import mod.azure.azurelib.common.platform.Services;
import mod.azure.mchalo.entity.projectiles.*;
import mod.azure.mchalo.item.HaloGunBase;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import java.util.function.Predicate;

public record CommonHelper() {

    public static final Predicate<LivingEntity> IS_CREATIVEorSPECTATOR = livingEntity -> livingEntity instanceof Player player && (player
            .isCreative()
            || player.isSpectator());

    public static void setOnFire(Projectile projectile) {
        if (projectile.isOnFire())
            projectile.level().getEntitiesOfClass(LivingEntity.class, projectile.getBoundingBox().inflate(2)).forEach(e -> {
                if (e.isAlive() && !(e instanceof Player))
                    e.setRemainingFireTicks(90);
            });
    }

    /**
     * Removes matching item from offhand first then checks inventory for item
     *
     * @param ammo         Item you want to be used as ammo
     * @param playerEntity Player whose inventory is being checked.
     */
    public static void removeAmmo(Item ammo, Player playerEntity) {
        if (playerEntity.getItemInHand(playerEntity.getUsedItemHand()).getItem() instanceof HaloGunBase && !playerEntity.isCreative()) { // Creative mode reloading breaks things
            for (var item : playerEntity.getInventory().offhand) {
                if (item.getItem() == ammo) {
                    item.shrink(1);
                    break;
                }
                for (var item1 : playerEntity.getInventory().items) {
                    if (item1.getItem() == ammo) {
                        item1.shrink(1);
                        break;
                    }
                }
            }
        }
    }

    /**
     * Call wherever you are firing weapon to place the half tick light-block, making sure do so only on the server.
     *
     * @param entity         Usually the player or mob that is using the weapon
     * @param isInWaterBlock Checks if it's in a water block to refresh faster.
     */
    public static void spawnLightSource(Entity entity, boolean isInWaterBlock) {
        BlockPos lightBlockPos = null;
        if (lightBlockPos == null) {
            lightBlockPos = CommonHelper.findFreeSpace(entity.level(), entity.blockPosition());
            if (lightBlockPos == null) return;
            entity.level().setBlockAndUpdate(lightBlockPos, AzureBlocksRegistry.TICKING_LIGHT_BLOCK.get().defaultBlockState());
        } else if (CommonHelper.checkDistance(lightBlockPos, entity.blockPosition()) && entity.level().getBlockEntity(lightBlockPos) instanceof TickingLightEntity tickingLightEntity) {
            tickingLightEntity.refresh(isInWaterBlock ? 20 : 0);
        }
    }

    private static boolean checkDistance(BlockPos blockPosA, BlockPos blockPosB) {
        return Math.abs(blockPosA.getX() - blockPosB.getX()) <= 2 && Math.abs(blockPosA.getY() - blockPosB.getY()) <= 2 && Math.abs(blockPosA.getZ() - blockPosB.getZ()) <= 2;
    }

    private static BlockPos findFreeSpace(Level world, BlockPos blockPos) {
        if (blockPos == null) return null;

        var offsets = new int[2 * 2 + 1];
        offsets[0] = 0;
        for (var i = 2; i <= 2 * 2; i += 2) {
            offsets[i - 1] = i / 2;
            offsets[i] = -i / 2;
        }
        for (var x : offsets)
            for (var y : offsets)
                for (var z : offsets) {
                    var offsetPos = blockPos.offset(x, y, z);
                    var state = world.getBlockState(offsetPos);
                    if (state.isAir() || state.getBlock().equals(AzureBlocksRegistry.TICKING_LIGHT_BLOCK.get()))
                        return offsetPos;
                }
        return null;
    }

    public static BulletEntity createBullet(Level worldIn, Float damage) {
        return new BulletEntity(worldIn, damage);
    }

    public static NeedleEntity createNeedle(Level worldIn, Float damage) {
        return new NeedleEntity(worldIn, damage);
    }

    public static RocketEntity createRocket(Level world) {
        return new RocketEntity(world);
    }

    public static PlasmaEntity createPlamsa(Level worldIn, Float damage) {
        return new PlasmaEntity(worldIn, damage);
    }

    public static PlasmaGEntity createGPlamsa(Level worldIn, Float damage) {
        return new PlasmaGEntity(worldIn, damage);
    }

    public static GrenadeEntity createGrenade(Level worldIn) {
        return new GrenadeEntity(worldIn, false);
    }
}
