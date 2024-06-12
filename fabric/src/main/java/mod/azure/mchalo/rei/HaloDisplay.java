package mod.azure.mchalo.rei;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.mojang.datafixers.util.Pair;
import mod.azure.mchalo.recipe.GunTableRecipe;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;

public class HaloDisplay implements Display {
	public final List<EntryIngredient> input;
	public final List<Integer> count;
	public final EntryIngredient output;
	public final GunTableRecipe recipe2;

	public HaloDisplay(GunTableRecipe recipe) {
		input = recipe.ingredients().stream().map(com.mojang.datafixers.util.Pair::getFirst).map(EntryIngredients::ofIngredient).toList();
		count = recipe.ingredients().stream().map(com.mojang.datafixers.util.Pair::getSecond).toList();
		this.output = EntryIngredients.of(recipe.output());
		this.recipe2 = recipe;
	}

	@Override
	public List<EntryIngredient> getInputEntries() {
		return recipe2.ingredients().stream().map(Pair::getFirst).map(EntryIngredients::ofIngredient).toList();
	}

	@Override
	public List<EntryIngredient> getOutputEntries() {
		return Collections.singletonList(output);
	}

	@Override
	public CategoryIdentifier<?> getCategoryIdentifier() {
		return ReiPlugin.CRAFTING;
	}
}