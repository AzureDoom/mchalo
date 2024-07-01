package mod.azure.mchalo.registry;

import mod.azure.mchalo.CommonMod;
import mod.azure.mchalo.particle.MCHaloParticleType;
import mod.azure.mchalo.registry.interfaces.CommonParticleRegistryInterface;

import java.util.function.Supplier;

public record ModParticles() implements CommonParticleRegistryInterface {

    public static final Supplier<MCHaloParticleType> PLASMA = CommonParticleRegistryInterface.registerParticle(
            CommonMod.MOD_ID, "plasma", () -> new MCHaloParticleType(true));
    public static final Supplier<MCHaloParticleType> PLASMAG = CommonParticleRegistryInterface.registerParticle(CommonMod.MOD_ID, "plasmag", () -> new MCHaloParticleType(true));

    public static void init() {
    }
}
