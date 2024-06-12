package mod.azure.mchalo.registry;

import mod.azure.mchalo.CommonMod;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public record Particles() {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, CommonMod.MOD_ID);
    public static final Supplier<SimpleParticleType> PLASMA = PARTICLES.register("plasma", () -> new SimpleParticleType(true));
    public static final Supplier<SimpleParticleType> PLASMAG = PARTICLES.register("plasmag", () -> new SimpleParticleType(true));
}
