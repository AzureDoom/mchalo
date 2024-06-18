package mod.azure.mchalo.recipe;

import mod.azure.mchalo.client.gui.GunTableInventory;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.NotNull;

public interface GunRecipes extends Recipe<GunTableInventory> {
	default @NotNull RecipeType<?> getType() {
		return RecipeType.CRAFTING;
	}
}