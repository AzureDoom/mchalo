package mod.azure.mchalo.network;

import commonnetwork.networking.data.PacketContext;
import commonnetwork.networking.data.Side;
import mod.azure.mchalo.item.HaloGunBase;
import net.minecraft.network.FriendlyByteBuf;

public class FiringPacket {
    public FiringPacket() {
    }

    public static FiringPacket decode(FriendlyByteBuf buf) {
        return new FiringPacket();
    }

    public static void handle(PacketContext<FiringPacket> ctx) {
        if (Side.SERVER.equals(ctx.side()) && ctx.sender().getMainHandItem().getItem() instanceof HaloGunBase)
            HaloGunBase.animate(ctx.sender());
    }

    public void encode(FriendlyByteBuf buf) {

    }
}
