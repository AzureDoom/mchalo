package mod.azure.mchalo.registry;

import mod.azure.mchalo.CommonMod;
import mod.azure.mchalo.registry.interfaces.CommonSoundRegistryInterface;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class ModSounds implements CommonSoundRegistryInterface {
    public static final Supplier<SoundEvent> SNIPER = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "sniper_fire_h3", () -> SoundEvent.createVariableRangeEvent(
            CommonMod.modResource("sniper_fire_h3")));
    public static final Supplier<SoundEvent> SNIPERRELOAD = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "sniper_reload", () -> SoundEvent.createVariableRangeEvent(CommonMod.modResource("sniper_reload")));
    public static final Supplier<SoundEvent> SHOTGUN = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "shotgun", () -> SoundEvent.createVariableRangeEvent(CommonMod.modResource("shotgun")));
    public static final Supplier<SoundEvent> SHOTGUNRELOAD = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "shotgunreload", () -> SoundEvent.createVariableRangeEvent(CommonMod.modResource("shotgunreload")));
    public static final Supplier<SoundEvent> PISTOL = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "pistol", () -> SoundEvent.createVariableRangeEvent(CommonMod.modResource("pistol")));
    public static final Supplier<SoundEvent> PISTOLRELOAD = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "pistolreload", () -> SoundEvent.createVariableRangeEvent(CommonMod.modResource("pistolreload")));
    public static final Supplier<SoundEvent> BATTLERIFLE = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "battle_rifle", () -> SoundEvent.createVariableRangeEvent(CommonMod.modResource("battle_rifle")));
    public static final Supplier<SoundEvent> BATTLERIFLERELOAD = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "battle_rifle_reload", () -> SoundEvent.createVariableRangeEvent(CommonMod.modResource("battle_rifle_reload")));
    public static final Supplier<SoundEvent> ROCKET = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "rocket_h3_1", () -> SoundEvent.createVariableRangeEvent(CommonMod.modResource("rocket_h3_1")));
    public static final Supplier<SoundEvent> ROCKETRELOAD = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "rocket_reload", () -> SoundEvent.createVariableRangeEvent(CommonMod.modResource("rocket_reload")));
    public static final Supplier<SoundEvent> PLASMAPISTOL = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "plasmapistol", () -> SoundEvent.createVariableRangeEvent(CommonMod.modResource("plasmapistol")));
    public static final Supplier<SoundEvent> PLASMAPISTOLELOAD = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "plasmapistol_reload", () -> SoundEvent.createVariableRangeEvent(CommonMod.modResource("plasmapistol_reload")));
    public static final Supplier<SoundEvent> PLASMARIFLE = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "plasmarifle", () -> SoundEvent.createVariableRangeEvent(CommonMod.modResource("plasmarifle")));
    public static final Supplier<SoundEvent> PLASMARIFLERELOAD = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "plasmarifle_reload", () -> SoundEvent.createVariableRangeEvent(CommonMod.modResource("plasmarifle_reload")));
    public static final Supplier<SoundEvent> NEEDLER = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "needler", () -> SoundEvent.createVariableRangeEvent(CommonMod.modResource("needler")));
    public static final Supplier<SoundEvent> NEEDLERRELOAD = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "needler_reload", () -> SoundEvent.createVariableRangeEvent(CommonMod.modResource("needler_reload")));
    public static final Supplier<SoundEvent> MAULER = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "mauler", () -> SoundEvent.createVariableRangeEvent(CommonMod.modResource("mauler")));
    public static final Supplier<SoundEvent> MAULERRELOAD = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "mauler_reload", () -> SoundEvent.createVariableRangeEvent(CommonMod.modResource("mauler_reload")));
    public static final Supplier<SoundEvent> BRUTESHOT = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "bruteshot", () -> SoundEvent.createVariableRangeEvent(CommonMod.modResource("bruteshot")));
    public static final Supplier<SoundEvent> BRUTESHOTRELOAD = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "bruteshot_reload", () -> SoundEvent.createVariableRangeEvent(CommonMod.modResource("bruteshot_reload")));
    public static final Supplier<SoundEvent> ENERGYSWORD1A = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "energy_melee1a", () -> SoundEvent.createVariableRangeEvent(CommonMod.modResource("energy_melee1a")));
    public static final Supplier<SoundEvent> ENERGYSWORD1B = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "energy_melee1b", () -> SoundEvent.createVariableRangeEvent(CommonMod.modResource("energy_melee1b")));
    public static final Supplier<SoundEvent> ENERGYSWORD1C = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "energy_melee1c", () -> SoundEvent.createVariableRangeEvent(CommonMod.modResource("energy_melee1c")));
    public static final Supplier<SoundEvent> ENERGYSWORDLOOP = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "energy_loop", () -> SoundEvent.createVariableRangeEvent(CommonMod.modResource("energy_loop")));
    public static final Supplier<SoundEvent> ENERGYSWORDOPEN = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "energy_open", () -> SoundEvent.createVariableRangeEvent(CommonMod.modResource("energy_open")));
    public static final Supplier<SoundEvent> BRUTESHOT_MELEE1 = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "brute_shot_melee1", () -> SoundEvent.createVariableRangeEvent(CommonMod.modResource("brute_shot_melee1")));
    public static final Supplier<SoundEvent> BRUTESHOT_MELEE2 = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "brute_shot_melee2", () -> SoundEvent.createVariableRangeEvent(CommonMod.modResource("brute_shot_melee2")));
    public static final Supplier<SoundEvent> BRUTESHOT_MELEE3 = CommonSoundRegistryInterface.registerSound(CommonMod.MOD_ID, "brute_shot_melee3", () -> SoundEvent.createVariableRangeEvent(CommonMod.modResource("brute_shot_melee3")));
    
    public static void init() {
    }
}
