package mod.azure.mchalo;

import mod.azure.mchalo.config.HaloConfig;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.enchantment.Enchantment;

public record CommonMod() {
    public static HaloConfig config;
    public static final String MOD_ID = "mchalo";
    public static final TagKey<Enchantment> HAS_MENDING = TagKey.create(Registries.ENCHANTMENT, modResource("has_mending"));

    public static ResourceLocation modResource(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }
}
