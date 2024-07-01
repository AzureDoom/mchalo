package mod.azure.mchalo.registry;

import mod.azure.mchalo.CommonMod;
import mod.azure.mchalo.recipe.GunTableRecipe;
import mod.azure.mchalo.registry.interfaces.CommonRecipeRegistryInterface;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.function.Supplier;

public record ModRecipes() implements CommonRecipeRegistryInterface{
    public static final Supplier<RecipeSerializer<?>> GUN_TABLE_SERIAL = CommonRecipeRegistryInterface.registerRecipe(CommonMod.MOD_ID, "gun_table", () -> GunTableRecipe.Serializer.INSTANCE);

    public static void init() {
    }
}
