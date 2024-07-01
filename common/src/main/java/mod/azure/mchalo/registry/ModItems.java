package mod.azure.mchalo.registry;

import mod.azure.mchalo.CommonMod;
import mod.azure.mchalo.entity.projectiles.helper.ProjectileEnum;
import mod.azure.mchalo.item.EnergySwordItem;
import mod.azure.mchalo.item.HaloGunBase;
import mod.azure.mchalo.item.PropShieldItem;
import mod.azure.mchalo.item.ammo.GrenadeItem;
import mod.azure.mchalo.item.ammo.HaloAmmoItem;
import mod.azure.mchalo.registry.interfaces.CommonItemRegistryInterface;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ModItems implements CommonItemRegistryInterface {
    public static final Supplier<Item> ENERGYSWORD = CommonItemRegistryInterface.registerItem(CommonMod.MOD_ID, "energy_sword", EnergySwordItem::new);
    public static final Supplier<Item> PROPSHIELD = CommonItemRegistryInterface.registerItem(CommonMod.MOD_ID, "prop_shield_h2", PropShieldItem::new);
    /* Ammo */
    public static final Supplier<Item> SNIPER_ROUND = CommonItemRegistryInterface.registerItem(CommonMod.MOD_ID, "sniper_round", HaloAmmoItem::new);
    /* Weapons */
    public static final Supplier<Item> SNIPER = CommonItemRegistryInterface.registerItem(CommonMod.MOD_ID, "sniper_rifle", () -> new HaloGunBase("sniper_h3", ProjectileEnum.SNIPER, CommonMod.config.sniper_max_ammo, ModSounds.SNIPERRELOAD.get(), ModSounds.SNIPER.get(), CommonMod.config.sniper_mag_size, CommonMod.config.sniper_bullet_damage) {
    });
    public static final Supplier<Item> SHOTGUN_CLIP = CommonItemRegistryInterface.registerItem(CommonMod.MOD_ID, "shotgun_clip", HaloAmmoItem::new);
    public static final Supplier<Item> SHOTGUN = CommonItemRegistryInterface.registerItem(CommonMod.MOD_ID, "shotgun_h2", () -> new HaloGunBase("shotgun_h2", ProjectileEnum.SHELL,  CommonMod.config.shotgun_max_ammo, ModSounds.SHOTGUNRELOAD.get(), ModSounds.SHOTGUN.get(), CommonMod.config.shotgun_mag_size, CommonMod.config.shotgun_bullet_damage) {
    });
    public static final Supplier<Item> MAULER = CommonItemRegistryInterface.registerItem(CommonMod.MOD_ID, "mauler", () -> new HaloGunBase("mauler", ProjectileEnum.MAULER, CommonMod.config.mauler_max_ammo, ModSounds.MAULERRELOAD.get(), ModSounds.MAULER.get(), CommonMod.config.mauler_mag_size, CommonMod.config.mauler_bullet_damage) {
    });
    public static final Supplier<Item> BULLETCLIP = CommonItemRegistryInterface.registerItem(CommonMod.MOD_ID, "bullet_clip", HaloAmmoItem::new);
    public static final Supplier<Item> MAGNUM = CommonItemRegistryInterface.registerItem(CommonMod.MOD_ID, "magnum_h3", () -> new HaloGunBase("magnum_h3", ProjectileEnum.BULLET, CommonMod.config.magnum_max_ammo, ModSounds.PISTOLRELOAD.get(), ModSounds.PISTOL.get(), CommonMod.config.magnum_mag_size, CommonMod.config.magnum_bullet_damage) {
    });
    public static final Supplier<Item> BATTLERIFLE = CommonItemRegistryInterface.registerItem(CommonMod.MOD_ID, "battle_rifle", () -> new HaloGunBase("battle_rifle", ProjectileEnum.BRBULLET, CommonMod.config.battlerifle_max_ammo, ModSounds.BATTLERIFLERELOAD.get(), ModSounds.BATTLERIFLE.get(), CommonMod.config.battlerifle_mag_size, CommonMod.config.battlerifle_bullet_damage) {
    });
    public static final Supplier<Item> NEEDLES = CommonItemRegistryInterface.registerItem(CommonMod.MOD_ID, "needles", HaloAmmoItem::new);
    public static final Supplier<Item> NEEDLER = CommonItemRegistryInterface.registerItem(CommonMod.MOD_ID, "needler", () -> new HaloGunBase("needler", ProjectileEnum.NEEDLE, CommonMod.config.needler_max_ammo, ModSounds.NEEDLERRELOAD.get(), ModSounds.NEEDLER.get(), CommonMod.config.needler_mag_size, CommonMod.config.needler_bullet_damage) {
    });
    public static final Supplier<Item> BATTERIES = CommonItemRegistryInterface.registerItem(CommonMod.MOD_ID, "batteries", HaloAmmoItem::new);
    public static final Supplier<Item> PLASMAPISTOL = CommonItemRegistryInterface.registerItem(CommonMod.MOD_ID, "plasma_pistol", () -> new HaloGunBase("plasma_pistol", ProjectileEnum.PLASMAG, CommonMod.config.plasmapistol_max_ammo, ModSounds.PLASMAPISTOLELOAD.get(), ModSounds.PLASMAPISTOL.get(), CommonMod.config.plasmapistol_mag_size, CommonMod.config.plasmapistol_bullet_damage) {
    });
    public static final Supplier<Item> PLASMARIFLE = CommonItemRegistryInterface.registerItem(CommonMod.MOD_ID, "plasma_rifle", () -> new HaloGunBase("plasma_rifle", ProjectileEnum.PLASMA, CommonMod.config.plasmarifle_max_ammo, ModSounds.PLASMARIFLERELOAD.get(), ModSounds.PLASMARIFLE.get(), CommonMod.config.plasmarifle_mag_size, CommonMod.config.plasmarifle_bullet_damage) {
    });
    public static final Supplier<Item> GRENADE = CommonItemRegistryInterface.registerItem(CommonMod.MOD_ID, "grenade", GrenadeItem::new);
    public static final Supplier<Item> BRUTESHOT = CommonItemRegistryInterface.registerItem(CommonMod.MOD_ID, "brute_shot", () -> new HaloGunBase("brute_shot", ProjectileEnum.GRENADE, CommonMod.config.bruteshot_max_ammo, ModSounds.BRUTESHOTRELOAD.get(), ModSounds.BRUTESHOT.get(), CommonMod.config.bruteshot_mag_size, CommonMod.config.bruteshot_bullet_damage) {
    });
    public static final Supplier<Item> ROCKET = CommonItemRegistryInterface.registerItem(CommonMod.MOD_ID, "rocket", HaloAmmoItem::new);
    public static final Supplier<Item> ROCKETLAUNCHER = CommonItemRegistryInterface.registerItem(CommonMod.MOD_ID, "rocket_launcher_h3", () -> new HaloGunBase("rocket_launcher_h3", ProjectileEnum.ROCKET, CommonMod.config.rocketlauncher_max_ammo, ModSounds.ROCKETRELOAD.get(), ModSounds.ROCKET.get(), CommonMod.config.rocketlauncher_mag_size, CommonMod.config.rocketlauncher_damage) {
    });
    /* Blocks */
    public static final Supplier<Item> GUN_TABLE = CommonItemRegistryInterface.registerItem(CommonMod.MOD_ID, "gun_table", () -> new BlockItem(ModBlocks.GUN_TABLE.get(), new Item.Properties()));

    public static void init() {
    }
}