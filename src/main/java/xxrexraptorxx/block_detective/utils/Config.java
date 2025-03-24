package xxrexraptorxx.block_detective.utils;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {

    public static final String CATEGORY_GENERAL = "general";
    public static final String CATEGORY_TOOLTIP = "tooltip";
    public static final String CATEGORY_JEI = "jei";

    public static ModConfigSpec CLIENT_CONFIG;
    public static ModConfigSpec SERVER_CONFIG;

    public static ModConfigSpec.BooleanValue UPDATE_CHECKER;
    public static ModConfigSpec.BooleanValue PATREON_REWARDS;

    public static ModConfigSpec.EnumValue<InformationTypes> TOOLTIP_HINT_SIZE;

    public static ModConfigSpec.BooleanValue USE_CTRL_INSTEAD_OF_SHIFT;

    public static ModConfigSpec.BooleanValue ENABLE_ITEM_TOOLTIPS;
    public static ModConfigSpec.BooleanValue ENABLE_BLOCK_TOOLTIPS;
    public static ModConfigSpec.BooleanValue SHOW_REGISTRY_NAME;
    public static ModConfigSpec.BooleanValue SHOW_DESTROY_TIME;
    public static ModConfigSpec.BooleanValue SHOW_JUMP_FACTOR;
    public static ModConfigSpec.BooleanValue SHOW_LIGHT_LEVEL;
    public static ModConfigSpec.BooleanValue SHOW_SPEED_FACTOR;
    public static ModConfigSpec.BooleanValue SHOW_FRICTION;
    public static ModConfigSpec.BooleanValue SHOW_IF_FLAMMABLE;
    public static ModConfigSpec.BooleanValue SHOW_IF_SOLID;
    public static ModConfigSpec.BooleanValue SHOW_INSTRUMENT;
    public static ModConfigSpec.BooleanValue SHOW_MAP_COLOR;
    public static ModConfigSpec.BooleanValue SHOW_EXPLOSION_RESISTANCE;
    public static ModConfigSpec.BooleanValue SHOW_REQUIRES_CORRECT_TOOL;
    public static ModConfigSpec.BooleanValue SHOW_IS_GRAVITY_AFFECTED;

    public static ModConfigSpec.BooleanValue ENABLE_JEI_ITEM_PAGES;
    public static ModConfigSpec.BooleanValue SHOW_REGISTRY_NAME_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_DESTROY_TIME_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_JUMP_FACTOR_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_LIGHT_LEVEL_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_SPEED_FACTOR_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_FRICTION_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_IF_FLAMMABLE_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_IF_SOLID_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_INSTRUMENT_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_MAP_COLOR_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_EXPLOSION_RESISTANCE_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_REQUIRES_CORRECT_TOOL_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_IS_GRAVITY_AFFECTED_IN_JEI;

    public static void init(ModContainer container) {
        initServer();
        initClient();

        container.registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG);
        container.registerConfig(ModConfig.Type.CLIENT, CLIENT_CONFIG);
    }


    public static void initClient() {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        builder.comment("General").push(CATEGORY_GENERAL);
        UPDATE_CHECKER = builder.comment("Activate the Update-Checker").define("update-checker", true);
        builder.pop();

        builder.comment("Tooltips").push(CATEGORY_TOOLTIP);
        TOOLTIP_HINT_SIZE = builder.comment("How the hint tooltip should look under the blocks. TINY = [+], NORMAL = [+] Shift, EXTENDED = Hold Shift for more information").defineEnum("tooltip_hint_size", InformationTypes.NORMAL);
        USE_CTRL_INSTEAD_OF_SHIFT = builder.comment("Use [CTRL] instead of [SHIFT] key to show the additional informations. ").define("use_ctrl_instead_of_shift", false);

        ENABLE_ITEM_TOOLTIPS = builder.comment("Enable item tooltips").define("enable_item_tooltips", true);
        ENABLE_BLOCK_TOOLTIPS = builder.comment("Enable block tooltips").define("enable_block_tooltips", true);

        SHOW_REGISTRY_NAME = builder.comment("Show the registry name in the item tooltips").define("show_registry_name", true);
        SHOW_DESTROY_TIME = builder.comment("Show the destroy time in the item tooltips").define("show_destroy_time", true);
        SHOW_EXPLOSION_RESISTANCE = builder.comment("Show the explosion resistance in the item tooltips").define("show_explosion_resistance", true);
        SHOW_JUMP_FACTOR = builder.comment("Show the jump factor in the item tooltips").define("show_jump_factor", true);
        SHOW_LIGHT_LEVEL = builder.comment("Show the light level in the item tooltips").define("show_light_level", true);
        SHOW_SPEED_FACTOR = builder.comment("Show the speed factor in the item tooltips").define("show_speed_factor", true);
        SHOW_FRICTION = builder.comment("Show the friction in the item tooltips").define("show_friction", true);
        SHOW_IF_FLAMMABLE = builder.comment("Show if the block is flammable in the item tooltips").define("show_if_flammable", true);
        SHOW_IF_SOLID = builder.comment("Show if the block is solid in the item tooltips").define("show_if_solid", true);
        SHOW_INSTRUMENT = builder.comment("Show the noteblock instrument in the item tooltips").define("show_instrument", true);
        SHOW_MAP_COLOR = builder.comment("Show the map color of this block in the item tooltips").define("show_map_color", true);
        SHOW_IS_GRAVITY_AFFECTED = builder.comment("Show of the block is gravity affected in the item tooltips").define("show_if_gravity_affected", true);
        SHOW_REQUIRES_CORRECT_TOOL = builder.comment("Show if the block requires the correct tool to drop in the item tooltips").define("show_if_requires_correct_tool", true);
        builder.pop();

        builder.comment("JEI/REI/EMI Pages").push(CATEGORY_JEI);
        ENABLE_JEI_ITEM_PAGES = builder.comment("Enable JEI/REI/EMI item info pages").define("enable_jei_item_pages", true);
        SHOW_REGISTRY_NAME_IN_JEI = builder.comment("Show the registry name in the item page").define("show_registry_name_jei", true);
        SHOW_DESTROY_TIME_IN_JEI = builder.comment("Show the destroy time in the item page").define("show_destroy_time_jei", true);
        SHOW_EXPLOSION_RESISTANCE_IN_JEI = builder.comment("Show the explosion resistance in the item page").define("show_explosion_resistance_jei", true);
        SHOW_LIGHT_LEVEL_IN_JEI = builder.comment("Show the light level in the item page").define("show_light_level_jei", true);
        SHOW_JUMP_FACTOR_IN_JEI = builder.comment("Show the jump factor in the item page").define("show_jump_factor_jei", true);
        SHOW_SPEED_FACTOR_IN_JEI = builder.comment("Show the speed factor in the item page").define("show_speed_factor_jei", true);
        SHOW_FRICTION_IN_JEI = builder.comment("Show the friction in the item page").define("show_friction_jei", true);
        SHOW_IF_FLAMMABLE_IN_JEI = builder.comment("Show if the block is flammable in the item page").define("show_if_flammable_jei", true);
        SHOW_IF_SOLID_IN_JEI = builder.comment("Show if the block is solid in the item page").define("show_if_solid_jei", true);
        SHOW_INSTRUMENT_IN_JEI = builder.comment("Show the noteblock instrument in the item page").define("show_instrument_jei", true);
        SHOW_MAP_COLOR_IN_JEI = builder.comment("Show the map color of this block in the item page").define("show_map_color_jei", true);
        SHOW_IS_GRAVITY_AFFECTED_IN_JEI = builder.comment("Show of the block is gravity affected in the item page").define("show_if_gravity_affected", true);
        SHOW_REQUIRES_CORRECT_TOOL_IN_JEI = builder.comment("Show if the block requires the correct tool to drop in the item page").define("show_if_requires_correct_tool", true);
        builder.pop();

        CLIENT_CONFIG = builder.build();
    }

    public static void initServer() {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        builder.comment("General").push(CATEGORY_GENERAL);
        PATREON_REWARDS = builder.comment("Enables ingame rewards on first spawn for Patreons").define("patreon_rewards", true);
        builder.pop();

        SERVER_CONFIG = builder.build();
    }

}