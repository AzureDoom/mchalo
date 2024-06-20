package mod.azure.mchalo.config;

import mod.azure.azurelib.common.api.common.config.Config;
import mod.azure.azurelib.common.internal.common.config.Configurable;
import mod.azure.mchalo.CommonMod;

@Config(id = CommonMod.MOD_ID)
public class HaloConfig {

    @Configurable
    @Configurable.Synchronized
    public int battlerifle_max_ammo = 144;
    @Configurable
    @Configurable.Synchronized
    public int battlerifle_mag_size = 36;
    @Configurable
    @Configurable.Synchronized
    public float battlerifle_bullet_damage = 2.5F;

    @Configurable
    @Configurable.Synchronized
    public int magnum_max_ammo = 40;
    @Configurable
    @Configurable.Synchronized
    public int magnum_mag_size = 8;
    @Configurable
    @Configurable.Synchronized
    public float magnum_bullet_damage = 2.5F;

    @Configurable
    @Configurable.Synchronized
    public int shotgun_max_ammo = 48;
    @Configurable
    @Configurable.Synchronized
    public int shotgun_mag_size = 12;
    @Configurable
    @Configurable.Synchronized
    public float shotgun_bullet_damage = 3.5F;

    @Configurable
    @Configurable.Synchronized
    public int sniper_max_ammo = 28;
    @Configurable
    @Configurable.Synchronized
    public int sniper_mag_size = 4;
    @Configurable
    @Configurable.Synchronized
    public float sniper_bullet_damage = 16F;

    @Configurable
    @Configurable.Synchronized
    public int rocketlauncher_max_ammo = 8;
    @Configurable
    @Configurable.Synchronized
    public int rocketlauncher_mag_size = 2;
    @Configurable
    @Configurable.Synchronized
    public int rocketlauncher_damage = 4;

    @Configurable
    @Configurable.Synchronized
    public int propshield_max_damage = 500;

    @Configurable
    @Configurable.Synchronized
    public int plasmapistol_max_ammo = 100;
    @Configurable
    @Configurable.Synchronized
    public int plasmapistol_mag_size = 25;
    @Configurable
    @Configurable.Synchronized
    public float plasmapistol_bullet_damage = 6.5F;

    @Configurable
    @Configurable.Synchronized
    public int plasmarifle_max_ammo = 100;
    @Configurable
    @Configurable.Synchronized
    public int plasmarifle_mag_size = 25;
    @Configurable
    @Configurable.Synchronized
    public float plasmarifle_bullet_damage = 15.5F;

    @Configurable
    @Configurable.Synchronized
    public int needler_max_ammo = 120;
    @Configurable
    @Configurable.Synchronized
    public int needler_mag_size = 20;
    @Configurable
    @Configurable.Synchronized
    public float needler_bullet_damage = 6.5F;

    @Configurable
    @Configurable.Synchronized
    public int mauler_max_ammo = 25;
    @Configurable
    @Configurable.Synchronized
    public int mauler_mag_size = 5;
    @Configurable
    @Configurable.Synchronized
    public float mauler_bullet_damage = 3.5F;

    @Configurable
    @Configurable.Synchronized
    public boolean grenades_cause_fire = false;
    @Configurable
    @Configurable.Synchronized
    public boolean grenades_break_blocks = false;

    @Configurable
    @Configurable.Synchronized
    public int bruteshot_max_ammo = 18;
    @Configurable
    @Configurable.Synchronized
    public int bruteshot_mag_size = 1;
    @Configurable
    @Configurable.Synchronized
    public float bruteshot_bullet_damage = 7.5F;

}
