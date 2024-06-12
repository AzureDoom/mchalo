package mod.azure.mchalo.registry;

import mod.azure.mchalo.CommonMod;
import mod.azure.mchalo.client.gui.GunTableScreenHandler;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public record Screens() {
    public static final DeferredRegister<MenuType<?>> CONTAIN = DeferredRegister.create(BuiltInRegistries.MENU, CommonMod.MOD_ID);

    public static final Supplier<MenuType<GunTableScreenHandler>> SCREEN_HANDLER_TYPE = CONTAIN.register("gun_table_gui", () -> new MenuType<>(GunTableScreenHandler::new, FeatureFlags.VANILLA_SET));
}
