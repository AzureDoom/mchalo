package mod.azure.mchalo.entity.projectiles;

import mod.azure.mchalo.helper.CommonHelper;
import mod.azure.mchalo.platform.Services;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

public class BulletEntity extends AbstractArrow {
    private static float bulletdamage;

    public BulletEntity(EntityType<? extends BulletEntity> entityType, Level world) {
        super(entityType, world);
        this.pickup = AbstractArrow.Pickup.DISALLOWED;
    }

    public BulletEntity(Level world, Float damage) {
        this(Services.ENTITIES_HELPER.getBulletEntity(), world);
        bulletdamage = damage;
    }

    @Override
    protected void doPostHurtEffects(@NotNull LivingEntity living) {
        super.doPostHurtEffects(living);
        if (!(living instanceof Player)) {
            living.invulnerableTime = 0;
            living.setDeltaMovement(0, 0, 0);
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        tag.putShort("life", (short)this.tickCount);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        this.tickCount = tag.getShort("life");
    }

    @Override
    public void tick() {
        super.tick();
        if (this.tickCount >= 80) this.remove(Entity.RemovalReason.DISCARDED);
        CommonHelper.setOnFire(this);
        if (this.level().isClientSide) {
            var x = this.getX() + (this.random.nextDouble()) * this.getBbWidth() * 0.5D;
            var y = this.getZ() + (this.random.nextDouble()) * this.getBbWidth() * 0.5D;
            this.level().addParticle(ParticleTypes.SMOKE, true, x, this.getY(), y, 0, 0, 0);
        }
    }

    @Override
    public boolean isNoGravity() {
        return !this.isUnderWater();
    }

    public SoundEvent hitSound = this.getDefaultHitGroundSoundEvent();

    @Override
    public void setSoundEvent(@NotNull SoundEvent soundIn) {
        this.hitSound = soundIn;
    }

    @Override
    protected @NotNull SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.ARMOR_EQUIP_IRON.value();
    }

    @Override
    protected void onHitBlock(@NotNull BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        if (!this.level().isClientSide) this.remove(Entity.RemovalReason.DISCARDED);
        this.setSoundEvent(SoundEvents.ARMOR_EQUIP_IRON.value());
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        var entity = entityHitResult.getEntity();
        if (entityHitResult.getType() != HitResult.Type.ENTITY || !entityHitResult.getEntity().is(entity) && !this.level().isClientSide)
            this.remove(Entity.RemovalReason.DISCARDED);
        var entity2 = this.getOwner();
        DamageSource damageSource2;
        if (entity2 == null) damageSource2 = damageSources().arrow(this, this);
        else {
            damageSource2 = damageSources().arrow(this, entity2);
            if (entity2 instanceof LivingEntity livingEntity) livingEntity.setLastHurtMob(entity);
        }
        if (entity.hurt(damageSource2, bulletdamage)) {
            if (entity instanceof LivingEntity livingEntity) {
                this.doPostHurtEffects(livingEntity);
                if (livingEntity != entity2 && livingEntity instanceof Player && entity2 instanceof ServerPlayer && !this.isSilent())
                    ((ServerPlayer) entity2).connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.ARROW_HIT_PLAYER, 0.0F));
            }
        } else {
            if (!this.level().isClientSide) this.remove(Entity.RemovalReason.DISCARDED);
        }
    }

    @Override
    public @NotNull ItemStack getPickupItem() {
        return new ItemStack(Items.AIR);
    }

    @Override
    public boolean shouldRenderAtSqrDistance(double distance) {
        return true;
    }

    @Override
    protected @NotNull ItemStack getDefaultPickupItem() {
        return Items.AIR.getDefaultInstance();
    }

}