package mod.azure.mchalo.platform.services;

import mod.azure.mchalo.blocks.blockentity.GunBlockEntity;
import mod.azure.mchalo.entity.projectiles.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.block.entity.BlockEntityType;

public interface MCHaloEntitiesHelper {
    BlockEntityType<GunBlockEntity> getGunTableEntity();

    EntityType<? extends BulletEntity> getBulletEntity();

    EntityType<?extends GrenadeEntity> getGrenadeEntity();

    EntityType<?extends NeedleEntity> getNeedleEntity();

    EntityType<?extends PlasmaEntity> getPlasmaEntity();

    EntityType<?extends PlasmaGEntity> getPlasmaGEntity();

    EntityType<?extends RocketEntity> getRocketEntity();
}
