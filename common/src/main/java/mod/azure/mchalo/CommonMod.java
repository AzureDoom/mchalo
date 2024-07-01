package mod.azure.mchalo;

import mod.azure.azurelib.common.internal.common.AzureLibMod;
import mod.azure.azurelib.common.internal.common.config.format.ConfigFormats;
import mod.azure.mchalo.config.HaloConfig;
import mod.azure.mchalo.registry.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;

public record CommonMod() {
    public static HaloConfig config;
    public static final String MOD_ID = "mchalo";
    public static final TagKey<Enchantment> HAS_MENDING = TagKey.create(Registries.ENCHANTMENT, modResource("has_mending"));
    public static final TagKey<Item> IS_WEAPON = TagKey.create(Registries.ITEM, modResource("is_weapon"));

    public static void init() {
        config = AzureLibMod.registerConfig(HaloConfig.class, ConfigFormats.json()).getConfigInstance();
        ModBlocks.init();
        ModEntities.init();
        ModItems.init();
        ModParticles.init();
        ModParticles.init();
        ModRecipes.init();
        ModScreens.init();
        ModSounds.init();
        ModTabs.init();
    }

    public static ResourceLocation modResource(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }
}
