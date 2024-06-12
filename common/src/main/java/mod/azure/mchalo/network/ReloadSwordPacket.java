package mod.azure.mchalo.network;

import commonnetwork.networking.data.PacketContext;
import commonnetwork.networking.data.Side;
import mod.azure.mchalo.item.EnergySwordItem;
import mod.azure.mchalo.item.HaloGunBase;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.InteractionHand;

public class ReloadSwordPacket {

    public ReloadSwordPacket() {
    }

    public static ReloadSwordPacket decode(FriendlyByteBuf buf) {
        return new ReloadSwordPacket();
    }

    public static void handle(PacketContext<ReloadSwordPacket> ctx) {
        if (Side.SERVER.equals(ctx.side()) && ctx.sender().getMainHandItem().getItem() instanceof EnergySwordItem)
            EnergySwordItem.reload(ctx.sender(), InteractionHand.MAIN_HAND);
    }

    public void encode(FriendlyByteBuf buf) {

    }
}
