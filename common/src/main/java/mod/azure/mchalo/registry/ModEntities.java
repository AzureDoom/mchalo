package mod.azure.mchalo.registry;

import mod.azure.mchalo.CommonMod;
import mod.azure.mchalo.blocks.blockentity.GunBlockEntity;
import mod.azure.mchalo.entity.projectiles.*;
import mod.azure.mchalo.registry.interfaces.CommonBlockEntityRegistryInterface;
import mod.azure.mchalo.registry.interfaces.CommonEntityRegistryInterface;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public record ModEntities() implements CommonEntityRegistryInterface, CommonBlockEntityRegistryInterface {
    public static final Supplier<BlockEntityType<GunBlockEntity>> GUN_TABLE_ENTITY = CommonBlockEntityRegistryInterface.registerBlockEntity(CommonMod.MOD_ID,"guntable", () -> BlockEntityType.Builder.of(GunBlockEntity::new, ModBlocks.GUN_TABLE.get()).build(null));
    public static final Supplier<EntityType<BulletEntity>> BULLET = CommonEntityRegistryInterface.registerEntity(CommonMod.MOD_ID, "bullet", BulletEntity::new, MobCategory.MISC, 0.5F, 0.5F);
    public static final Supplier<EntityType<NeedleEntity>> NEEDLE = CommonEntityRegistryInterface.registerEntity(CommonMod.MOD_ID, "needle", NeedleEntity::new, MobCategory.MISC, 0.5F, 0.5F);
    public static final Supplier<EntityType<PlasmaEntity>> PLASMA = CommonEntityRegistryInterface.registerEntity(CommonMod.MOD_ID, "plasma", PlasmaEntity::new, MobCategory.MISC, 0.5F, 0.5F);
    public static final Supplier<EntityType<PlasmaGEntity>> PLASMAG = CommonEntityRegistryInterface.registerEntity(CommonMod.MOD_ID, "plasmag", PlasmaGEntity::new, MobCategory.MISC, 0.5F, 0.5F);
    public static final Supplier<EntityType<GrenadeEntity>> GRENADE = CommonEntityRegistryInterface.registerEntity(CommonMod.MOD_ID, "grenade", GrenadeEntity::new, MobCategory.MISC, 0.5F, 0.5F);
    public static final Supplier<EntityType<RocketEntity>> ROCKET = CommonEntityRegistryInterface.registerEntity(CommonMod.MOD_ID, "rocket", RocketEntity::new, MobCategory.MISC, 0.5F, 0.5F);
    public static void init() {
    }
}
