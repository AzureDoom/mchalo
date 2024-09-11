package mod.azure.mchalo.client.models;

import mod.azure.azurelib.common.api.client.model.DefaultedItemGeoModel;
import mod.azure.azurelib.common.api.common.animatable.GeoItem;
import mod.azure.azurelib.common.internal.common.constant.DataTickets;
import mod.azure.azurelib.core.animation.AnimationState;
import mod.azure.mchalo.item.EnergySwordItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class GunModel<T extends Item & GeoItem> extends DefaultedItemGeoModel<T> {
    public GunModel(ResourceLocation assetSubpath) {
        super(assetSubpath);
    }

    @Override
    public void setCustomAnimations(T animatable, long instanceId, AnimationState<T> animationState) {
        if (!(animatable instanceof EnergySwordItem))
            switch (animationState.getData(DataTickets.ITEM_RENDER_PERSPECTIVE)) {
                case GUI, GROUND, HEAD, NONE, FIXED -> animationState.getController().stop();
            }
        super.setCustomAnimations(animatable, instanceId, animationState);
    }
}
