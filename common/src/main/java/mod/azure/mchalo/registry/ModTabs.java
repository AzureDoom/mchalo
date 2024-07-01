package mod.azure.mchalo.registry;

import mod.azure.mchalo.CommonMod;
import mod.azure.mchalo.platform.Services;
import mod.azure.mchalo.registry.interfaces.CommonCreativeTabRegistryInterface;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public record ModTabs() implements CommonCreativeTabRegistryInterface {

    public static final Supplier<CreativeModeTab> ITEM_GROUP = Services.COMMON_REGISTRY.registerCreativeModeTab(
            CommonMod.MOD_ID,
            "items",
            () -> Services.COMMON_REGISTRY.newCreativeTabBuilder().title(
                    Component.translatable("itemGroup." + CommonMod.MOD_ID + ".items"))
                    .icon(() -> new ItemStack(ModItems.ENERGYSWORD.get()))
                    .displayItems((enabledFeatures, entries) -> {
                        entries.accept(ModItems.ENERGYSWORD.get());
                        entries.accept(ModItems.MAGNUM.get());
                        entries.accept(ModItems.BATTLERIFLE.get());
                        entries.accept(ModItems.BULLETCLIP.get());
                        entries.accept(ModItems.SHOTGUN.get());
                        entries.accept(ModItems.MAULER.get());
                        entries.accept(ModItems.SHOTGUN_CLIP.get());
                        entries.accept(ModItems.SNIPER.get());
                        entries.accept(ModItems.SNIPER_ROUND.get());
                        entries.accept(ModItems.BRUTESHOT.get());
                        entries.accept(ModItems.GRENADE.get());
                        entries.accept(ModItems.NEEDLER.get());
                        entries.accept(ModItems.NEEDLES.get());
                        entries.accept(ModItems.PLASMAPISTOL.get());
                        entries.accept(ModItems.PLASMARIFLE.get());
                        entries.accept(ModItems.BATTERIES.get());
                        entries.accept(ModItems.ROCKETLAUNCHER.get());
                        entries.accept(ModItems.ROCKET.get());
                        entries.accept(ModItems.PROPSHIELD.get());
                        entries.accept(ModItems.GUN_TABLE.get());
                    }).build());

    public static void init() {
    }
}
