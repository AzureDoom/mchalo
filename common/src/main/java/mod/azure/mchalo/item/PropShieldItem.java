package mod.azure.mchalo.item;

import mod.azure.azurelib.common.api.common.animatable.GeoItem;
import mod.azure.azurelib.common.internal.client.RenderProvider;
import mod.azure.azurelib.common.internal.common.animatable.SingletonGeoAnimatable;
import mod.azure.azurelib.common.internal.common.util.AzureLibUtil;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager.ControllerRegistrar;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.object.PlayState;
import mod.azure.mchalo.CommonMod;
import mod.azure.mchalo.client.render.GunRender;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

public class PropShieldItem extends Item implements GeoItem {

    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);

    public PropShieldItem() {
        super(new Item.Properties().stacksTo(1).durability(CommonMod.config.propshield_max_damage + 1));
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return UseAnim.BLOCK;
    }

    @Override
    public int getUseDuration(@NotNull ItemStack stack, @NotNull LivingEntity livingEntity) {
        return 72000;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, Player user, @NotNull InteractionHand hand) {
        var itemStack = user.getItemInHand(hand);
        user.startUsingItem(hand);
        return InteractionResultHolder.consume(itemStack);
    }

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack stack, ItemStack ingredient) {
        return ingredient.is(ItemTags.IRON_ORES) || super.isValidRepairItem(stack, ingredient);
    }

    @Override
    public void appendHoverText(ItemStack stack, @NotNull TooltipContext tooltipContext, List<Component> tooltip, @NotNull TooltipFlag context) {
        tooltip.add(Component.translatable("Item Health: " + (stack.getMaxDamage() - stack.getDamageValue() - 1) + " / " + (stack.getMaxDamage() - 1)).withStyle(ChatFormatting.ITALIC));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public void registerControllers(ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "shoot_controller", event -> PlayState.CONTINUE));
    }

    @Override
    public void createRenderer(Consumer<RenderProvider> consumer) {
        consumer.accept(new RenderProvider() {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return new GunRender<PropShieldItem>("prop_shield_h2");
            }
        });
    }

}
