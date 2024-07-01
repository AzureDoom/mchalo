package mod.azure.mchalo;

import mod.azure.azurelib.common.internal.common.AzureLib;
import mod.azure.mchalo.network.PacketHandler;
import net.fabricmc.api.ModInitializer;

public final class FabricLibMod implements ModInitializer {

    @Override
    public void onInitialize() {
        CommonMod.init();
        AzureLib.initialize();
        new PacketHandler().registerMessages();
        AzureLib.hasKeyBindsInitialized = true;
    }
}
