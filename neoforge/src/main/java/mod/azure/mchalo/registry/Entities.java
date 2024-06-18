package mod.azure.mchalo.registry;

import mod.azure.mchalo.CommonMod;
import mod.azure.mchalo.NeoForgeMod;
import mod.azure.mchalo.blocks.blockentity.GunBlockEntity;
import mod.azure.mchalo.entity.projectiles.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public record Entities() {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, CommonMod.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, CommonMod.MOD_ID);
    public static final Supplier<BlockEntityType<GunBlockEntity>> GUN_TABLE_ENTITY = BLOCK_ENTITIES.register("guntable", () -> BlockEntityType.Builder.of(GunBlockEntity::new, NeoForgeMod.Blocks.GUN_TABLE.get()).build(null));
    public static final Supplier<EntityType<BulletEntity>> BULLET = ENTITIES.register("bullet", () -> EntityType.Builder.<BulletEntity>of(BulletEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(90).updateInterval(1).build(CommonMod.modResource("bullet").toString()));
    public static final Supplier<EntityType<NeedleEntity>> NEEDLE = ENTITIES.register("needle", () -> EntityType.Builder.<NeedleEntity>of(NeedleEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(90).updateInterval(1).build(CommonMod.modResource("needle").toString()));
    public static final Supplier<EntityType<PlasmaEntity>> PLASMA = ENTITIES.register("plasma", () -> EntityType.Builder.<PlasmaEntity>of(PlasmaEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(90).updateInterval(1).build(CommonMod.modResource("plasma").toString()));
    public static final Supplier<EntityType<PlasmaGEntity>> PLASMAG = ENTITIES.register("plasmag", () -> EntityType.Builder.<PlasmaGEntity>of(PlasmaGEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(90).updateInterval(1).build(CommonMod.modResource("plasmag").toString()));
    public static final Supplier<EntityType<GrenadeEntity>> GRENADE = ENTITIES.register("grenade", () -> EntityType.Builder.<GrenadeEntity>of(GrenadeEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(90).updateInterval(1).build(CommonMod.modResource("grenade").toString()));
    public static final Supplier<EntityType<RocketEntity>> ROCKET = ENTITIES.register("rocket", () -> EntityType.Builder.<RocketEntity>of(RocketEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(90).updateInterval(1).build(CommonMod.modResource("rocket").toString()));
}
