package mod.azure.mchalo;

import mod.azure.azurelib.common.api.client.helper.ClientUtils;
import mod.azure.mchalo.client.gui.GunTableScreen;
import mod.azure.mchalo.client.render.ProjectileRender;
import mod.azure.mchalo.client.render.projectiles.EmptyRender;
import mod.azure.mchalo.helper.EntityEnum;
import mod.azure.mchalo.particle.PlasmaParticle;
import mod.azure.mchalo.registry.Entities;
import mod.azure.mchalo.registry.Items;
import mod.azure.mchalo.registry.Particles;
import mod.azure.mchalo.registry.Screens;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = CommonMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public record NeoForgeClientMod() {

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(Entities.BULLET.get(), EmptyRender::new);
        event.registerEntityRenderer(Entities.NEEDLE.get(), ctx -> new ProjectileRender<>(ctx, EntityEnum.NEEEDLE, "needle"));
        event.registerEntityRenderer(Entities.ROCKET.get(), EmptyRender::new);
        event.registerEntityRenderer(Entities.PLASMA.get(), EmptyRender::new);
        event.registerEntityRenderer(Entities.PLASMAG.get(), EmptyRender::new);
        event.registerEntityRenderer(Entities.GRENADE.get(), ctx -> new ProjectileRender<>(ctx, EntityEnum.GRENADE, "rocket"));
    }

    @SubscribeEvent
    public static void registerScreens(final RegisterMenuScreensEvent event){
        event.register(Screens.SCREEN_HANDLER_TYPE.get(), GunTableScreen::new);
    }

    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        ItemProperties.register(Items.SNIPER.get(), ResourceLocation.parse("scoped"), (itemStack, clientWorld, livingEntity, seed) -> NeoForgeClientMod.isScoped(livingEntity));
        ItemProperties.register(Items.BATTLERIFLE.get(), ResourceLocation.parse("scoped"), (itemStack, clientWorld, livingEntity, seed) -> NeoForgeClientMod.isScoped(livingEntity));
    }

    @SubscribeEvent
    public static void registry(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(Particles.PLASMA.get(), PlasmaParticle.PurpleFactory::new);
        event.registerSpriteSet(Particles.PLASMAG.get(), PlasmaParticle.GreenFactory::new);
    }

    public static float isScoped(LivingEntity livingEntity) {
        if (livingEntity != null) return ClientUtils.SCOPE.isDown() ? 1.0F : 0.0F;
        return 0.0F;
    }
}
