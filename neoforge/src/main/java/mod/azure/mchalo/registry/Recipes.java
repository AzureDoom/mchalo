package mod.azure.mchalo.registry;

import mod.azure.mchalo.CommonMod;
import mod.azure.mchalo.recipe.GunTableRecipe;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public record Recipes() {
    public static final DeferredRegister<RecipeSerializer<?>> SERIAL = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, CommonMod.MOD_ID);

    public static final Supplier<RecipeSerializer<?>> GUN_TABLE_RECIPE_SERIALIZER = SERIAL.register("gun_table", () -> GunTableRecipe.Serializer.INSTANCE);
}
