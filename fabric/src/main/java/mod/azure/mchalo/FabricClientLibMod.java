package mod.azure.mchalo;

import mod.azure.azurelib.common.api.client.helper.ClientUtils;
import mod.azure.azurelib.common.internal.common.AzureLib;
import mod.azure.mchalo.client.gui.GunTableScreen;
import mod.azure.mchalo.client.render.ProjectileRender;
import mod.azure.mchalo.client.render.projectiles.EmptyRender;
import mod.azure.mchalo.entity.projectiles.helper.EntityEnum;
import mod.azure.mchalo.network.PacketHandler;
import mod.azure.mchalo.particle.PlasmaParticle;
import mod.azure.mchalo.registry.ModEntities;
import mod.azure.mchalo.registry.ModItems;
import mod.azure.mchalo.registry.ModParticles;
import mod.azure.mchalo.registry.ModScreens;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class FabricClientLibMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        AzureLib.hasKeyBindsInitialized = true;
        new PacketHandler().registerMessages();
        MenuScreens.register(ModScreens.SCREEN_HANDLER_TYPE.get(), GunTableScreen::new);
        EntityRendererRegistry.register(ModEntities.BULLET.get(), EmptyRender::new);
        EntityRendererRegistry.register(ModEntities.NEEDLE.get(), ctx -> new ProjectileRender<>(ctx, EntityEnum.NEEEDLE, "needle"));
        EntityRendererRegistry.register(ModEntities.ROCKET.get(), EmptyRender::new);
        EntityRendererRegistry.register(ModEntities.PLASMA.get(), EmptyRender::new);
        EntityRendererRegistry.register(ModEntities.PLASMAG.get(), EmptyRender::new);
        EntityRendererRegistry.register(ModEntities.GRENADE.get(), ctx -> new ProjectileRender<>(ctx, EntityEnum.GRENADE, "rocket"));
        ItemProperties.register(
                ModItems.SNIPER.get(), ResourceLocation.parse("scoped"), (itemStack, clientWorld, livingEntity, seed) -> {
            if (livingEntity != null) return ClientUtils.SCOPE.isDown() ? 1.0F : 0.0F;
            return 0.0F;
        });
        ItemProperties.register(ModItems.BATTLERIFLE.get(), ResourceLocation.parse("scoped"), (itemStack, clientWorld, livingEntity, seed) -> {
            if (livingEntity != null) return ClientUtils.SCOPE.isDown() ? 1.0F : 0.0F;
            return 0.0F;
        });
        ParticleFactoryRegistry.getInstance().register(ModParticles.PLASMA.get(), PlasmaParticle.PurpleFactory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.PLASMAG.get(), PlasmaParticle.GreenFactory::new);
    }
}
