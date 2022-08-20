package xxrexraptorxx.block_detective.utils;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber
public class Config {

    public static final String CATEGORY_GENERAL = "general";
    public static final String CATEGORY_TOOLTIP = "tooltip";
    public static final String CATEGORY_JEI = "jei";

    public static ForgeConfigSpec CLIENT_CONFIG;
    public static ForgeConfigSpec SERVER_CONFIG;

    public static ForgeConfigSpec.BooleanValue UPDATE_CHECKER;
    public static ForgeConfigSpec.BooleanValue PATREON_REWARDS;

    public static ForgeConfigSpec.BooleanValue SHOW_REGISTRY_NAME;
    public static ForgeConfigSpec.BooleanValue SHOW_DESTROY_TIME;
    public static ForgeConfigSpec.BooleanValue SHOW_JUMP_FACTOR;
    public static ForgeConfigSpec.BooleanValue SHOW_SPEED_FACTOR;
    public static ForgeConfigSpec.BooleanValue SHOW_FRICTION;
    public static ForgeConfigSpec.BooleanValue SHOW_IF_FLAMMABLE;
    public static ForgeConfigSpec.BooleanValue SHOW_IF_SOLID;

    public static ForgeConfigSpec.BooleanValue SHOW_REGISTRY_NAME_IN_JEI;
    public static ForgeConfigSpec.BooleanValue SHOW_DESTROY_TIME_IN_JEI;
    public static ForgeConfigSpec.BooleanValue SHOW_JUMP_FACTOR_IN_JEI;
    public static ForgeConfigSpec.BooleanValue SHOW_SPEED_FACTOR_IN_JEI;
    public static ForgeConfigSpec.BooleanValue SHOW_FRICTION_IN_JEI;
    public static ForgeConfigSpec.BooleanValue SHOW_IF_FLAMMABLE_IN_JEI;
    public static ForgeConfigSpec.BooleanValue SHOW_IF_SOLID_IN_JEI;


    public static void init() {
        initServer();
        initClient();

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT_CONFIG);
    }


    public static void initClient() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.comment("General").push(CATEGORY_GENERAL);
        UPDATE_CHECKER = builder.comment("Activate the Update-Checker").define("update-checker", true);
        builder.pop();

        builder.comment("Tooltips").push(CATEGORY_TOOLTIP);
        SHOW_REGISTRY_NAME = builder.comment("Show the registry name in the item tooltips").define("show_registry_name", true);
        SHOW_DESTROY_TIME = builder.comment("Show the destroy time in the item tooltips").define("show_destroy_time", true);
        SHOW_JUMP_FACTOR = builder.comment("Show the jump factor in the item tooltips").define("show_jump_factor", true);
        SHOW_SPEED_FACTOR = builder.comment("Show the speed factor in the item tooltips").define("show_speed_factor", true);
        SHOW_FRICTION = builder.comment("Show the friction in the item tooltips").define("show_friction", true);
        SHOW_IF_FLAMMABLE = builder.comment("Show if the block is flammable in the item tooltips").define("show_if_flammable", true);
        SHOW_IF_SOLID = builder.comment("Show if the block is solid in the item tooltips").define("show_if_solid", true);
        builder.pop();

        CLIENT_CONFIG = builder.build();
    }

    public static void initServer() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.comment("General").push(CATEGORY_GENERAL);
        PATREON_REWARDS = builder.comment("Enables ingame rewards on first spawn for Patreons").define("patreon_rewards", true);
        builder.pop();

        SERVER_CONFIG = builder.build();
    }

}