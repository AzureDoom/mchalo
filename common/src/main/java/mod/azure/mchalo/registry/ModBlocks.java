package mod.azure.mchalo.registry;

import mod.azure.mchalo.CommonMod;
import mod.azure.mchalo.blocks.GunTableBlock;
import mod.azure.mchalo.registry.interfaces.CommonBlockRegistryInterface;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class ModBlocks implements CommonBlockRegistryInterface {
    public static final Supplier<Block> GUN_TABLE = CommonBlockRegistryInterface.registerBlock(CommonMod.MOD_ID,"gun_table", () -> new GunTableBlock(
            BlockBehaviour.Properties.of().strength(4.0f).noOcclusion()));

    public static void init() {
    }
}
