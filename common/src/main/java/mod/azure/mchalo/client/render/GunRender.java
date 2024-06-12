package mod.azure.mchalo.client.render;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import mod.azure.azurelib.common.api.common.animatable.GeoItem;
import mod.azure.mchalo.CommonMod;
import mod.azure.mchalo.client.models.GunModel;
import net.minecraft.world.item.Item;

public class GunRender<T extends Item & GeoItem> extends GeoItemRenderer<T> {
    public GunRender(String id) {
        super(new GunModel<>(CommonMod.modResource(id + "/" + id)));
    }
}