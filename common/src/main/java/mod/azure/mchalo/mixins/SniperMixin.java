package mod.azure.mchalo.mixins;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import mod.azure.azurelib.common.api.client.helper.ClientUtils;
import mod.azure.mchalo.CommonMod;
import mod.azure.mchalo.platform.Services;
import mod.azure.mchalo.registry.ModItems;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public abstract class SniperMixin {


    private static final ResourceLocation sniper = CommonMod.modResource("textures/gui/sniper_scope.png");
    private static final ResourceLocation battlerifle = CommonMod.modResource("textures/gui/sniper_scope_2x.png");

    @Shadow
    private final Minecraft minecraft;
    private boolean scoped = true;

    protected SniperMixin(Minecraft minecraft) {
        this.minecraft = minecraft;
    }

    @Inject(at = @At("TAIL"), method = "render")
    private void render(GuiGraphics guiGraphics, DeltaTracker partialTicks, CallbackInfo ci) {
        assert this.minecraft.player != null;
        var itemStack = this.minecraft.player.getInventory().getSelected();
        if (this.minecraft.options.getCameraType().isFirstPerson() && itemStack.is(ModItems.SNIPER.get())) {
            if (ClientUtils.SCOPE.isDown()) {
                if (this.scoped) this.scoped = false;
                this.renderSniperOverlay(guiGraphics, sniper);
            } else if (!this.scoped) this.scoped = true;
        }
        if (this.minecraft.options.getCameraType().isFirstPerson() && itemStack.is(ModItems.BATTLERIFLE.get())) {
            if (ClientUtils.SCOPE.isDown()) {
                if (this.scoped) this.scoped = false;
                this.renderSniperOverlay(guiGraphics, battlerifle);
            } else if (!this.scoped) this.scoped = true;
        }
    }

    private void renderSniperOverlay(GuiGraphics guiGraphics, ResourceLocation identifier) {
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, identifier);
        var tessellator = Tesselator.getInstance();
        var bufferBuilder = tessellator.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferBuilder.addVertex(0.0F, guiGraphics.guiHeight(), -90.0F).setUv(0.0F, 1.0F);
        bufferBuilder.addVertex(guiGraphics.guiWidth(), guiGraphics.guiHeight(), -90.0F).setUv(1.0F, 1.0F);
        bufferBuilder.addVertex(guiGraphics.guiWidth(), 0.0F, -90.0F).setUv(1.0F, 0.0F);
        bufferBuilder.addVertex(0.0F, 0.0F, -90.0F).setUv(0.0F, 0.0F);
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }
}
