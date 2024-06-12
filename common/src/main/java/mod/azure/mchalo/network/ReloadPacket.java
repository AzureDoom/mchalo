package mod.azure.mchalo.network;

import commonnetwork.networking.data.PacketContext;
import commonnetwork.networking.data.Side;
import mod.azure.mchalo.item.HaloGunBase;
import net.minecraft.network.FriendlyByteBuf;

public class ReloadPacket {

    public ReloadPacket() {
    }

    public static ReloadPacket decode(FriendlyByteBuf buf) {
        return new ReloadPacket();
    }

    public static void handle(PacketContext<ReloadPacket> ctx) {
        if (Side.SERVER.equals(ctx.side()) && ctx.sender().getMainHandItem().getItem() instanceof HaloGunBase)
            HaloGunBase.reload(ctx.sender());
    }

    public void encode(FriendlyByteBuf buf) {

    }
}
