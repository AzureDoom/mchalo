package mod.azure.mchalo.platform;

import mod.azure.mchalo.blocks.blockentity.GunBlockEntity;
import mod.azure.mchalo.entity.projectiles.*;
import mod.azure.mchalo.platform.services.MCHaloEntitiesHelper;
import mod.azure.mchalo.registry.Entities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class FabricMCHaloEntitiesHelper implements MCHaloEntitiesHelper {
    @Override
    public BlockEntityType<GunBlockEntity> getGunTableEntity() {
        return Entities.GUN_TABLE_ENTITY;
    }

    @Override
    public EntityType<? extends BulletEntity> getBulletEntity() {
        return Entities.BULLET;
    }

    @Override
    public EntityType<? extends GrenadeEntity> getGrenadeEntity() {
        return Entities.GRENADE;
    }

    @Override
    public EntityType<? extends NeedleEntity> getNeedleEntity() {
        return Entities.NEEDLE;
    }

    @Override
    public EntityType<? extends PlasmaEntity> getPlasmaEntity() {
        return Entities.PLASMA;
    }

    @Override
    public EntityType<? extends PlasmaGEntity> getPlasmaGEntity() {
        return Entities.PLASMAG;
    }

    @Override
    public EntityType<? extends RocketEntity> getRocketEntity() {
        return Entities.ROCKET;
    }
}
