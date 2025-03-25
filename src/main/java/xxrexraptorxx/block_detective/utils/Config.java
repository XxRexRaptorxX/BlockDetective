package xxrexraptorxx.block_detective.utils;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {

    public static final String CATEGORY_GENERAL = "general";
    public static final String CATEGORY_BLOCK_TOOLTIP = "block_tooltip";
    public static final String CATEGORY_ITEM_TOOLTIP = "item_tooltip";
    public static final String CATEGORY_BLOCK_INFO_PAGE = "block_info_page";
    public static final String CATEGORY_ITEM_INFO_PAGE = "item_info_page";

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
    public static ModConfigSpec.BooleanValue SHOW_IS_CLIMBABLE;
    public static ModConfigSpec.BooleanValue SHOW_IS_IMPERMEABLE;
    public static ModConfigSpec.BooleanValue SHOW_IS_REPLACEABLE;
    public static ModConfigSpec.BooleanValue SHOW_IS_ANIMAL_SPAWNABLE;
    public static ModConfigSpec.BooleanValue SHOW_IS_BEACON_BASE;
    public static ModConfigSpec.BooleanValue SHOW_IS_INFINIBURN;
    public static ModConfigSpec.BooleanValue SHOW_DAMPENS_VIBRATIONS;
    public static ModConfigSpec.BooleanValue SHOW_IS_PATHFINDABLE;
    public static ModConfigSpec.BooleanValue SHOW_MAX_SIZE;
    public static ModConfigSpec.BooleanValue SHOW_MAX_DAMAGE;
    public static ModConfigSpec.BooleanValue SHOW_DAMAGE;
    public static ModConfigSpec.BooleanValue SHOW_STONE_MINING_SPEED;
    public static ModConfigSpec.BooleanValue SHOW_DIRT_MINING_SPEED;
    public static ModConfigSpec.BooleanValue SHOW_SHOW_WOOD_MINING_SPEED;
    public static ModConfigSpec.BooleanValue SHOW_IS_ENCHANTABLE;
    public static ModConfigSpec.BooleanValue SHOW_IS_FOOD;
    public static ModConfigSpec.BooleanValue SHOW_IS_DYABLE;
    public static ModConfigSpec.BooleanValue SHOW_IS_BEACON_PAYMENT;
    public static ModConfigSpec.BooleanValue SHOW_IS_TRIM_MATERIAL;
    public static ModConfigSpec.BooleanValue SHOW_IS_TRIMMABLE;
    public static ModConfigSpec.BooleanValue SHOW_IS_GRINDSTONE_REPAIRABLE;
    public static ModConfigSpec.BooleanValue SHOW_IS_PIGLIN_CURRENCY;
    public static ModConfigSpec.BooleanValue SHOW_MAKES_PIGLINS_NEUTRAL;

    public static ModConfigSpec.BooleanValue ENABLE_JEI_ITEM_PAGES;
    public static ModConfigSpec.BooleanValue ENABLE_JEI_BLOCK_PAGES;
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
    public static ModConfigSpec.BooleanValue SHOW_IS_CLIMBABLE_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_IS_IMPERMEABLE_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_IS_REPLACEABLE_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_IS_ANIMAL_SPAWNABLE_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_IS_BEACON_BASE_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_IS_INFINIBURN_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_DAMPENS_VIBRATIONS_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_IS_PATHFINDABLE_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_MAX_SIZE_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_MAX_DAMAGE_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_DAMAGE_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_STONE_MINING_SPEED_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_DIRT_MINING_SPEED_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_SHOW_WOOD_MINING_SPEED_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_IS_ENCHANTABLE_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_IS_FOOD_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_IS_DYABLE_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_IS_BEACON_PAYMENT_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_IS_TRIM_MATERIAL_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_IS_TRIMMABLE_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_IS_GRINDSTONE_REPAIRABLE_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_IS_PIGLIN_CURRENCY_IN_JEI;
    public static ModConfigSpec.BooleanValue SHOW_MAKES_PIGLINS_NEUTRAL_IN_JEI;

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
        TOOLTIP_HINT_SIZE = builder.comment("How the hint tooltip should look under the items. TINY = [+], NORMAL = [+] Shift, EXTENDED = Hold Shift for more information").defineEnum("tooltip_hint_size", InformationTypes.NORMAL);
        USE_CTRL_INSTEAD_OF_SHIFT = builder.comment("Use [CTRL] instead of [SHIFT] key to show the additional informations. ").define("use_ctrl_instead_of_shift", false);
        builder.pop();

        builder.comment("Tooltips for blocks").push(CATEGORY_BLOCK_TOOLTIP);
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
        SHOW_IS_CLIMBABLE = builder.comment("Show if the block is climbable in the item tooltips").define("show_is_climbable", true);
        SHOW_IS_IMPERMEABLE = builder.comment("Show if the block is impermeable in the item tooltips").define("show_is_impermeable", false);
        SHOW_IS_REPLACEABLE = builder.comment("Show if the block is replaceable (if your place another block on it) in the item tooltips").define("show_is_replaceable", false);
        SHOW_IS_ANIMAL_SPAWNABLE = builder.comment("Show if animals can naturally spawn on the block in the item tooltips").define("show_is_animal_spawnable", false);
        SHOW_IS_BEACON_BASE = builder.comment("Show if the block is a beacon base block in the item tooltips").define("show_is_beacon_base", false);
        SHOW_IS_INFINIBURN = builder.comment("Show if the block infinitely burns in the item tooltips").define("show_is_infiniburn", false);
        SHOW_DAMPENS_VIBRATIONS = builder.comment("Show if the block dampens vibrations in the item tooltips").define("show_dampens_vibrations", false);
        SHOW_IS_PATHFINDABLE = builder.comment("Show if the block is pathfindable in the item tooltips").define("show_is_pathfindable", false);
        builder.pop();

        builder.comment("Tooltips for items").push(CATEGORY_ITEM_TOOLTIP);
        ENABLE_ITEM_TOOLTIPS = builder.comment("Enable item tooltips").define("enable_item_tooltips", true);

        SHOW_MAX_SIZE = builder.comment("Show the maximum stack size in the item tooltips").define("show_max_size", true);
        SHOW_MAX_DAMAGE = builder.comment("Show the maximum damage (~durability) in the item tooltips").define("show_max_damage", true);
        SHOW_DAMAGE = builder.comment("Show the current damage in the item tooltips").define("show_damage", true);
        SHOW_STONE_MINING_SPEED = builder.comment("Show the mining speed of stone in the item tooltips (only on tools)").define("show_stone_mining_speed", true);
        SHOW_DIRT_MINING_SPEED = builder.comment("Show the mining speed of dirt in the item tooltips (only on tools)").define("show_dirt_mining_speed", true);
        SHOW_SHOW_WOOD_MINING_SPEED = builder.comment("Show the mining speed of logs in the item tooltips (only on tools)").define("show_show_wood_mining_speed", true);
        SHOW_IS_ENCHANTABLE = builder.comment("Show if the item is enchantable in the item tooltips").define("show_is_enchantable", true);
        SHOW_IS_FOOD = builder.comment("Show if the item is food in the item tooltips").define("show_is_food", true);
        SHOW_IS_DYABLE = builder.comment("Show if the item is dyable in the item tooltips").define("show_is_dyable", true);
        SHOW_IS_BEACON_PAYMENT = builder.comment("Show if the item is a beacon payment  in the item tooltips").define("show_is_beacon_payment", false);
        SHOW_IS_TRIM_MATERIAL = builder.comment("Show if the item is a trim material in the item tooltips").define("show_is_trim_material", true);
        SHOW_IS_TRIMMABLE = builder.comment("Show if the item is trimmable in the item tooltips").define("show_is_trimmable", false);
        SHOW_IS_GRINDSTONE_REPAIRABLE = builder.comment("Show if the item is repairable on the grindstone in the item tooltips").define("show_is_grindstone_repairable", false);
        SHOW_IS_PIGLIN_CURRENCY = builder.comment("Show if the item is accepted as piglin currency in the item tooltips").define("show_is_piglin_currency", false);
        SHOW_MAKES_PIGLINS_NEUTRAL = builder.comment("Show if the item makes piglins neutral in the item tooltips").define("show_makes_piglins_neutral", false);
        builder.pop();


        builder.comment("JEI/REI/EMI info pages for blocks").push(CATEGORY_BLOCK_INFO_PAGE);
        ENABLE_JEI_BLOCK_PAGES = builder.comment("Enable JEI/REI/EMI info pages").define("enable_block_info_pages", true);

        SHOW_REGISTRY_NAME_IN_JEI = builder.comment("Show the registry name in the info page").define("show_registry_name_info_page", true);
        SHOW_DESTROY_TIME_IN_JEI = builder.comment("Show the destroy time in the info page").define("show_destroy_time_info_page", true);
        SHOW_EXPLOSION_RESISTANCE_IN_JEI = builder.comment("Show the explosion resistance in the info page").define("show_explosion_resistance_info_page", true);
        SHOW_LIGHT_LEVEL_IN_JEI = builder.comment("Show the light level in the info page").define("show_light_level_info_page", true);
        SHOW_JUMP_FACTOR_IN_JEI = builder.comment("Show the jump factor in the info page").define("show_jump_factor_info_page", true);
        SHOW_SPEED_FACTOR_IN_JEI = builder.comment("Show the speed factor in the info page").define("show_speed_factor_info_page", true);
        SHOW_FRICTION_IN_JEI = builder.comment("Show the friction in the info page").define("show_friction_info_page", true);
        SHOW_IF_FLAMMABLE_IN_JEI = builder.comment("Show if the block is flammable in the info page").define("show_if_flammable_info_page", true);
        SHOW_IF_SOLID_IN_JEI = builder.comment("Show if the block is solid in the info page").define("show_if_solid_info_page", true);
        SHOW_INSTRUMENT_IN_JEI = builder.comment("Show the noteblock instrument in the info page").define("show_instrument_info_page", true);
        SHOW_MAP_COLOR_IN_JEI = builder.comment("Show the map color of this block in the info page").define("show_map_color_info_page", true);
        SHOW_IS_GRAVITY_AFFECTED_IN_JEI = builder.comment("Show of the block is gravity affected in the info page").define("show_if_gravity_affected_info_page", true);
        SHOW_REQUIRES_CORRECT_TOOL_IN_JEI = builder.comment("Show if the block requires the correct tool to drop in the info page").define("show_if_requires_correct_tool_info_page", true);
        SHOW_IS_CLIMBABLE_IN_JEI = builder.comment("Show if the block is climbable in the info page").define("show_is_climbable_info_page", true);
        SHOW_IS_IMPERMEABLE_IN_JEI = builder.comment("Show if the block is impermeable in the info page").define("show_is_impermeable_info_page", true);
        SHOW_IS_REPLACEABLE_IN_JEI = builder.comment("Show if the block is replaceable (if your place another block on it) in the info page").define("show_is_replaceable_info_page", true);
        SHOW_IS_ANIMAL_SPAWNABLE_IN_JEI = builder.comment("Show if animals can naturally spawn on the block in the info page").define("show_is_animal_spawnable_info_page", true);
        SHOW_IS_BEACON_BASE_IN_JEI = builder.comment("Show if the block is a beacon base block in the info page").define("show_is_beacon_base_info_page", true);
        SHOW_IS_INFINIBURN_IN_JEI = builder.comment("Show if the block infinitely burns in the info page").define("show_is_infiniburn_info_page", true);
        SHOW_DAMPENS_VIBRATIONS_IN_JEI = builder.comment("Show if the block dampens vibrations in the info page").define("show_dampens_vibrations_info_page", true);
        SHOW_IS_PATHFINDABLE_IN_JEI = builder.comment("Show if the block is pathfindable in the info page").define("show_is_pathfindable_info_page", true);

        builder.pop();

        builder.comment("JEI/REI/EMI info pages for items").push(CATEGORY_BLOCK_INFO_PAGE);
        ENABLE_JEI_ITEM_PAGES = builder.comment("Enable JEI/REI/EMI info pages").define("enable_item_info_pages", true);

        SHOW_MAX_SIZE_IN_JEI = builder.comment("Show the maximum stack size in the info page").define("show_max_size_info_page", true);
        SHOW_MAX_DAMAGE_IN_JEI = builder.comment("Show the maximum damage (~durability) in the info page").define("show_max_damage_info_page", true);
        SHOW_DAMAGE_IN_JEI = builder.comment("Show the current damage in the info page").define("show_damage_info_page", true);
        SHOW_STONE_MINING_SPEED_IN_JEI = builder.comment("Show the mining speed of stone in the item tooltips (only on info page").define("show_stone_mining_speed_info_page", true);
        SHOW_DIRT_MINING_SPEED_IN_JEI = builder.comment("Show the mining speed of dirt in the item tooltips (only on info page").define("show_dirt_mining_speed_info_page", true);
        SHOW_SHOW_WOOD_MINING_SPEED_IN_JEI = builder.comment("Show the mining speed of logs in the item tooltips (only on info page").define("show_show_wood_mining_speed_info_page", true);
        SHOW_IS_ENCHANTABLE_IN_JEI = builder.comment("Show if the item is enchantable in the info page").define("show_is_enchantable_info_page", true);
        SHOW_IS_FOOD_IN_JEI = builder.comment("Show if the item is food in the info page").define("show_is_food_info_page", true);
        SHOW_IS_DYABLE_IN_JEI = builder.comment("Show if the item is dyable in the info page").define("show_is_dyable_info_page", true);
        SHOW_IS_BEACON_PAYMENT_IN_JEI = builder.comment("Show if the item is a beacon payment  in the info page").define("show_is_beacon_payment_info_page", true);
        SHOW_IS_TRIM_MATERIAL_IN_JEI = builder.comment("Show if the item is a trim material in the info page").define("show_is_trim_material_info_page", true);
        SHOW_IS_TRIMMABLE_IN_JEI = builder.comment("Show if the item is trimmable in the info page").define("show_is_trimmable_info_page", true);
        SHOW_IS_GRINDSTONE_REPAIRABLE_IN_JEI = builder.comment("Show if the item is repairable on the grindstone in the info page").define("show_is_grindstone_repairable_info_page", true);
        SHOW_IS_PIGLIN_CURRENCY_IN_JEI = builder.comment("Show if the item is accepted as piglin currency in the info page").define("show_is_piglin_currency_info_page", true);
        SHOW_MAKES_PIGLINS_NEUTRAL_IN_JEI = builder.comment("Show if the item makes piglins neutral in the info page").define("show_makes_piglins_neutral_info_page", true);

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