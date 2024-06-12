package mod.azure.mchalo.network;

import commonnetwork.api.Network;
import mod.azure.mchalo.CommonMod;
import net.minecraft.resources.ResourceLocation;

public class PacketHandler {
    public static final ResourceLocation LOCK_SLOT = CommonMod.modResource("select_craft");
    public static final ResourceLocation RELOAD = CommonMod.modResource("reload");
    public static final ResourceLocation ANIMATE = CommonMod.modResource("animate");

    public static void registerMessages() {
        Network.registerPacket(LOCK_SLOT, CraftingPacket.class, CraftingPacket::encode, CraftingPacket::decode, CraftingPacket::handle)
                .registerPacket(RELOAD, ReloadPacket.class, ReloadPacket::encode, ReloadPacket::decode, ReloadPacket::handle)
                .registerPacket(ANIMATE, FiringPacket.class, FiringPacket::encode, FiringPacket::decode, FiringPacket::handle);
    }
}
