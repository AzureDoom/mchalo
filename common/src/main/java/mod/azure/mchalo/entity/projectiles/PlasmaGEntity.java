package mod.azure.mchalo.entity.projectiles;

import mod.azure.azurelib.common.internal.common.network.packet.EntityPacket;
import mod.azure.mchalo.helper.CommonHelper;
import mod.azure.mchalo.platform.Services;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
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
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

public class PlasmaGEntity extends AbstractArrow {
    protected static float bulletdamage;
    private int idleTicks = 0;

    public PlasmaGEntity(EntityType<? extends PlasmaGEntity> entityType, Level world) {
        super(entityType, world);
        this.pickup = AbstractArrow.Pickup.DISALLOWED;
    }

    public PlasmaGEntity(Level world, Float damage) {
        this(Services.ENTITIES_HELPER.getPlasmaGEntity(), world);
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
    public void tick() {
        var idleOpt = 100;
        if (getDeltaMovement().lengthSqr() < 0.01) idleTicks++;
        else idleTicks = 0;
        if (idleTicks < idleOpt) super.tick();
        if (this.tickCount >= 80) this.remove(Entity.RemovalReason.DISCARDED);
        CommonHelper.spawnLightSource(this, this.level().isWaterAt(blockPosition()));
        if (this.level().isClientSide)
            this.level().addParticle(Services.PARTICLES_HELPER.getPlasmaGParticle(), true, this.getX(), this.getY(), this.getZ(), 0, 0, 0);
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
        if (!this.level().isClientSide) {
            this.remove(Entity.RemovalReason.DISCARDED);
        }
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
                if (!this.level().isClientSide && entity2 instanceof LivingEntity) {
                    EnchantmentHelper.doPostHurtEffects(livingEntity, entity2);
                    EnchantmentHelper.doPostDamageEffects((LivingEntity) entity2, livingEntity);
                }

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