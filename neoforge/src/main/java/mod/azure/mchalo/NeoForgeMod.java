package mod.azure.mchalo;

import mod.azure.azurelib.common.internal.common.AzureLibMod;
import mod.azure.azurelib.common.internal.common.config.format.ConfigFormats;
import mod.azure.mchalo.blocks.GunTableBlock;
import mod.azure.mchalo.config.HaloConfig;
import mod.azure.mchalo.network.PacketHandler;
import mod.azure.mchalo.registry.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@Mod(CommonMod.MOD_ID)
public final class NeoForgeMod {

    public NeoForgeMod(IEventBus modEventBus) {
        CommonMod.config = AzureLibMod.registerConfig(HaloConfig.class, ConfigFormats.json()).getConfigInstance();
        modEventBus.addListener(this::setup);
        Items.ITEMS.register(modEventBus);
        Blocks.BLOCKS.register(modEventBus);
        Sounds.SOUNDS.register(modEventBus);
        Entities.ENTITIES.register(modEventBus);
        Entities.BLOCK_ENTITIES.register(modEventBus);
        Particles.PARTICLES.register(modEventBus);
        Tabs.TABS.register(modEventBus);
        Recipes.SERIAL.register(modEventBus);
        Screens.CONTAIN.register(modEventBus);
    }

    private void setup(final FMLCommonSetupEvent event) {
        new PacketHandler().registerMessages();
    }

    public record Blocks() {
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, CommonMod.MOD_ID);
        public static final Supplier<Block> GUN_TABLE = BLOCKS.register("gun_table", () -> new GunTableBlock(
                BlockBehaviour.Properties.of().strength(4.0f).noOcclusion()));

    }
}
