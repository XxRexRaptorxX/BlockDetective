package xxrexraptorxx.block_detective.utils;

import net.neoforged.neoforge.common.ModConfigSpec;
import xxrexraptorxx.magmacore.config.ConfigHelper;

public class Config {

    private static final ModConfigSpec.Builder CLIENT_BUILDER = new ModConfigSpec.Builder();
    private static final ModConfigSpec.Builder SERVER_BUILDER = new ModConfigSpec.Builder();
    public static ModConfigSpec CLIENT_CONFIG;
    public static ModConfigSpec SERVER_CONFIG;

    private static ModConfigSpec.EnumValue<InformationTypes> TOOLTIP_HINT_SIZE;
    private static ModConfigSpec.BooleanValue USE_CTRL_INSTEAD_OF_SHIFT;

    private static ModConfigSpec.BooleanValue ENABLE_BLOCK_TOOLTIPS;
    private static ModConfigSpec.BooleanValue SHOW_REGISTRY_NAME;
    private static ModConfigSpec.BooleanValue SHOW_DESTROY_TIME;
    private static ModConfigSpec.BooleanValue SHOW_EXPLOSION_RESISTANCE;
    private static ModConfigSpec.BooleanValue SHOW_JUMP_FACTOR;
    private static ModConfigSpec.BooleanValue SHOW_LIGHT_LEVEL;
    private static ModConfigSpec.BooleanValue SHOW_SPEED_FACTOR;
    private static ModConfigSpec.BooleanValue SHOW_FRICTION;
    private static ModConfigSpec.BooleanValue SHOW_IF_FLAMMABLE;
    private static ModConfigSpec.BooleanValue SHOW_IF_SOLID;
    private static ModConfigSpec.BooleanValue SHOW_INSTRUMENT;
    private static ModConfigSpec.BooleanValue SHOW_MAP_COLOR;
    private static ModConfigSpec.BooleanValue SHOW_IS_GRAVITY_AFFECTED;
    private static ModConfigSpec.BooleanValue SHOW_REQUIRES_CORRECT_TOOL;
    private static ModConfigSpec.BooleanValue SHOW_IS_CLIMBABLE;
    private static ModConfigSpec.BooleanValue SHOW_IS_IMPERMEABLE;
    private static ModConfigSpec.BooleanValue SHOW_IS_REPLACEABLE;
    private static ModConfigSpec.BooleanValue SHOW_IS_ANIMAL_SPAWNABLE;
    private static ModConfigSpec.BooleanValue SHOW_IS_BEACON_BASE;
    private static ModConfigSpec.BooleanValue SHOW_IS_INFINIBURN;
    private static ModConfigSpec.BooleanValue SHOW_DAMPENS_VIBRATIONS;
    private static ModConfigSpec.BooleanValue SHOW_IS_PATHFINDABLE;

    // Client Config Values - Item Tooltips
    private static ModConfigSpec.BooleanValue ENABLE_ITEM_TOOLTIPS;
    private static ModConfigSpec.BooleanValue SHOW_MAX_SIZE;
    private static ModConfigSpec.BooleanValue SHOW_MAX_DAMAGE;
    private static ModConfigSpec.BooleanValue SHOW_DAMAGE;
    private static ModConfigSpec.BooleanValue SHOW_STONE_MINING_SPEED;
    private static ModConfigSpec.BooleanValue SHOW_DIRT_MINING_SPEED;
    private static ModConfigSpec.BooleanValue SHOW_WOOD_MINING_SPEED;
    private static ModConfigSpec.BooleanValue SHOW_IS_ENCHANTABLE;
    private static ModConfigSpec.BooleanValue SHOW_IS_FOOD;
    private static ModConfigSpec.BooleanValue SHOW_IS_DYABLE;
    private static ModConfigSpec.BooleanValue SHOW_IS_BEACON_PAYMENT;
    private static ModConfigSpec.BooleanValue SHOW_IS_TRIM_MATERIAL;
    private static ModConfigSpec.BooleanValue SHOW_IS_TRIMMABLE;
    private static ModConfigSpec.BooleanValue SHOW_IS_GRINDSTONE_REPAIRABLE;
    private static ModConfigSpec.BooleanValue SHOW_IS_PIGLIN_CURRENCY;
    private static ModConfigSpec.BooleanValue SHOW_MAKES_PIGLINS_NEUTRAL;

    // Client Config Values - JEI Block Info Pages
    private static ModConfigSpec.BooleanValue ENABLE_JEI_BLOCK_PAGES;
    private static ModConfigSpec.BooleanValue SHOW_REGISTRY_NAME_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_DESTROY_TIME_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_EXPLOSION_RESISTANCE_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_LIGHT_LEVEL_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_JUMP_FACTOR_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_SPEED_FACTOR_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_FRICTION_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_IF_FLAMMABLE_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_IF_SOLID_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_INSTRUMENT_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_MAP_COLOR_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_IS_GRAVITY_AFFECTED_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_REQUIRES_CORRECT_TOOL_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_IS_CLIMBABLE_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_IS_IMPERMEABLE_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_IS_REPLACEABLE_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_IS_ANIMAL_SPAWNABLE_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_IS_BEACON_BASE_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_IS_INFINIBURN_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_DAMPENS_VIBRATIONS_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_IS_PATHFINDABLE_IN_JEI;

    // Client Config Values - JEI Item Info Pages
    private static ModConfigSpec.BooleanValue ENABLE_JEI_ITEM_PAGES;
    private static ModConfigSpec.BooleanValue SHOW_MAX_SIZE_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_MAX_DAMAGE_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_DAMAGE_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_STONE_MINING_SPEED_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_DIRT_MINING_SPEED_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_WOOD_MINING_SPEED_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_IS_ENCHANTABLE_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_IS_FOOD_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_IS_DYABLE_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_IS_BEACON_PAYMENT_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_IS_TRIM_MATERIAL_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_IS_TRIMMABLE_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_IS_GRINDSTONE_REPAIRABLE_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_IS_PIGLIN_CURRENCY_IN_JEI;
    private static ModConfigSpec.BooleanValue SHOW_MAKES_PIGLINS_NEUTRAL_IN_JEI;

    static {
        TOOLTIP_HINT_SIZE = CLIENT_BUILDER.comment("How the hint tooltip should look under the items. TINY = [+], NORMAL = [+] Shift, EXTENDED = Hold Shift for more information")
                .defineEnum("tooltip_hint_size", InformationTypes.NORMAL);
        USE_CTRL_INSTEAD_OF_SHIFT = CLIENT_BUILDER.comment("Use [CTRL] instead of [SHIFT] key to show the additional informations")
                .define("use_ctrl_instead_of_shift", false);
        CLIENT_BUILDER.pop();

        ConfigHelper.setCategory(CLIENT_BUILDER, "block_tooltips");
        ENABLE_BLOCK_TOOLTIPS = CLIENT_BUILDER.comment("Enable block tooltips")
                .define("enable_block_tooltips", true);
        SHOW_REGISTRY_NAME = CLIENT_BUILDER.comment("Show the registry name in the item tooltips")
                .define("show_registry_name", true);
        SHOW_DESTROY_TIME = CLIENT_BUILDER.comment("Show the destroy time in the item tooltips")
                .define("show_destroy_time", true);
        SHOW_EXPLOSION_RESISTANCE = CLIENT_BUILDER.comment("Show the explosion resistance in the item tooltips")
                .define("show_explosion_resistance", true);
        SHOW_JUMP_FACTOR = CLIENT_BUILDER.comment("Show the jump factor in the item tooltips")
                .define("show_jump_factor", true);
        SHOW_LIGHT_LEVEL = CLIENT_BUILDER.comment("Show the light level in the item tooltips")
                .define("show_light_level", true);
        SHOW_SPEED_FACTOR = CLIENT_BUILDER.comment("Show the speed factor in the item tooltips")
                .define("show_speed_factor", true);
        SHOW_FRICTION = CLIENT_BUILDER.comment("Show the friction in the item tooltips")
                .define("show_friction", true);
        SHOW_IF_FLAMMABLE = CLIENT_BUILDER.comment("Show if the block is flammable in the item tooltips")
                .define("show_if_flammable", true);
        SHOW_IF_SOLID = CLIENT_BUILDER.comment("Show if the block is solid in the item tooltips")
                .define("show_if_solid", true);
        SHOW_INSTRUMENT = CLIENT_BUILDER.comment("Show the noteblock instrument in the item tooltips")
                .define("show_instrument", true);
        SHOW_MAP_COLOR = CLIENT_BUILDER.comment("Show the map color of this block in the item tooltips")
                .define("show_map_color", true);
        SHOW_IS_GRAVITY_AFFECTED = CLIENT_BUILDER.comment("Show of the block is gravity affected in the item tooltips")
                .define("show_if_gravity_affected", true);
        SHOW_REQUIRES_CORRECT_TOOL = CLIENT_BUILDER.comment("Show if the block requires the correct tool to drop in the item tooltips")
                .define("show_if_requires_correct_tool", true);
        SHOW_IS_CLIMBABLE = CLIENT_BUILDER.comment("Show if the block is climbable in the item tooltips")
                .define("show_is_climbable", true);
        SHOW_IS_IMPERMEABLE = CLIENT_BUILDER.comment("Show if the block is impermeable in the item tooltips")
                .define("show_is_impermeable", false);
        SHOW_IS_REPLACEABLE = CLIENT_BUILDER.comment("Show if the block is replaceable (if your place another block on it) in the item tooltips")
                .define("show_is_replaceable", false);
        SHOW_IS_ANIMAL_SPAWNABLE = CLIENT_BUILDER.comment("Show if animals can naturally spawn on the block in the item tooltips")
                .define("show_is_animal_spawnable", false);
        SHOW_IS_BEACON_BASE = CLIENT_BUILDER.comment("Show if the block is a beacon base block in the item tooltips")
                .define("show_is_beacon_base", false);
        SHOW_IS_INFINIBURN = CLIENT_BUILDER.comment("Show if the block infinitely burns in the item tooltips")
                .define("show_is_infiniburn", false);
        SHOW_DAMPENS_VIBRATIONS = CLIENT_BUILDER.comment("Show if the block dampens vibrations in the item tooltips")
                .define("show_dampens_vibrations", false);
        SHOW_IS_PATHFINDABLE = CLIENT_BUILDER.comment("Show if the block is pathfindable in the item tooltips")
                .define("show_is_pathfindable", false);
        CLIENT_BUILDER.pop();

        ConfigHelper.setCategory(CLIENT_BUILDER, "item_tooltips");
        ENABLE_ITEM_TOOLTIPS = CLIENT_BUILDER.comment("Enable item tooltips")
                .define("enable_item_tooltips", true);
        SHOW_MAX_SIZE = CLIENT_BUILDER.comment("Show the maximum stack size in the item tooltips")
                .define("show_max_size", true);
        SHOW_MAX_DAMAGE = CLIENT_BUILDER.comment("Show the maximum damage (~durability) in the item tooltips")
                .define("show_max_damage", true);
        SHOW_DAMAGE = CLIENT_BUILDER.comment("Show the current damage in the item tooltips")
                .define("show_damage", true);
        SHOW_STONE_MINING_SPEED = CLIENT_BUILDER.comment("Show the mining speed of stone in the item tooltips (only on tools)")
                .define("show_stone_mining_speed", true);
        SHOW_DIRT_MINING_SPEED = CLIENT_BUILDER.comment("Show the mining speed of dirt in the item tooltips (only on tools)")
                .define("show_dirt_mining_speed", true);
        SHOW_WOOD_MINING_SPEED = CLIENT_BUILDER.comment("Show the mining speed of logs in the item tooltips (only on tools)")
                .define("show_show_wood_mining_speed", true);
        SHOW_IS_ENCHANTABLE = CLIENT_BUILDER.comment("Show if the item is enchantable in the item tooltips")
                .define("show_is_enchantable", true);
        SHOW_IS_FOOD = CLIENT_BUILDER.comment("Show if the item is food in the item tooltips")
                .define("show_is_food", true);
        SHOW_IS_DYABLE = CLIENT_BUILDER.comment("Show if the item is dyable in the item tooltips")
                .define("show_is_dyable", true);
        SHOW_IS_BEACON_PAYMENT = CLIENT_BUILDER.comment("Show if the item is a beacon payment in the item tooltips")
                .define("show_is_beacon_payment", false);
        SHOW_IS_TRIM_MATERIAL = CLIENT_BUILDER.comment("Show if the item is a trim material in the item tooltips")
                .define("show_is_trim_material", true);
        SHOW_IS_TRIMMABLE = CLIENT_BUILDER.comment("Show if the item is trimmable in the item tooltips")
                .define("show_is_trimmable", false);
        SHOW_IS_GRINDSTONE_REPAIRABLE = CLIENT_BUILDER.comment("Show if the item is repairable on the grindstone in the item tooltips")
                .define("show_is_grindstone_repairable", false);
        SHOW_IS_PIGLIN_CURRENCY = CLIENT_BUILDER.comment("Show if the item is accepted as piglin currency in the item tooltips")
                .define("show_is_piglin_currency", false);
        SHOW_MAKES_PIGLINS_NEUTRAL = CLIENT_BUILDER.comment("Show if the item makes piglins neutral in the item tooltips")
                .define("show_makes_piglins_neutral", false);
        CLIENT_BUILDER.pop();

        ConfigHelper.setCategory(CLIENT_BUILDER, "block_info_pages");
        ENABLE_JEI_BLOCK_PAGES = CLIENT_BUILDER.comment("Enable JEI/REI/EMI info pages")
                .define("enable_block_info_pages", true);
        SHOW_REGISTRY_NAME_IN_JEI = CLIENT_BUILDER.comment("Show the registry name in the info page")
                .define("show_registry_name_info_page", true);
        SHOW_DESTROY_TIME_IN_JEI = CLIENT_BUILDER.comment("Show the destroy time in the info page")
                .define("show_destroy_time_info_page", true);
        SHOW_EXPLOSION_RESISTANCE_IN_JEI = CLIENT_BUILDER.comment("Show the explosion resistance in the info page")
                .define("show_explosion_resistance_info_page", true);
        SHOW_LIGHT_LEVEL_IN_JEI = CLIENT_BUILDER.comment("Show the light level in the info page")
                .define("show_light_level_info_page", true);
        SHOW_JUMP_FACTOR_IN_JEI = CLIENT_BUILDER.comment("Show the jump factor in the info page")
                .define("show_jump_factor_info_page", true);
        SHOW_SPEED_FACTOR_IN_JEI = CLIENT_BUILDER.comment("Show the speed factor in the info page")
                .define("show_speed_factor_info_page", true);
        SHOW_FRICTION_IN_JEI = CLIENT_BUILDER.comment("Show the friction in the info page")
                .define("show_friction_info_page", true);
        SHOW_IF_FLAMMABLE_IN_JEI = CLIENT_BUILDER.comment("Show if the block is flammable in the info page")
                .define("show_if_flammable_info_page", true);
        SHOW_IF_SOLID_IN_JEI = CLIENT_BUILDER.comment("Show if the block is solid in the info page")
                .define("show_if_solid_info_page", true);
        SHOW_INSTRUMENT_IN_JEI = CLIENT_BUILDER.comment("Show the noteblock instrument in the info page")
                .define("show_instrument_info_page", true);
        SHOW_MAP_COLOR_IN_JEI = CLIENT_BUILDER.comment("Show the map color of this block in the info page")
                .define("show_map_color_info_page", true);
        SHOW_IS_GRAVITY_AFFECTED_IN_JEI = CLIENT_BUILDER.comment("Show of the block is gravity affected in the info page")
                .define("show_if_gravity_affected_info_page", true);
        SHOW_REQUIRES_CORRECT_TOOL_IN_JEI = CLIENT_BUILDER.comment("Show if the block requires the correct tool to drop in the info page")
                .define("show_if_requires_correct_tool_info_page", true);
        SHOW_IS_CLIMBABLE_IN_JEI = CLIENT_BUILDER.comment("Show if the block is climbable in the info page")
                .define("show_is_climbable_info_page", true);
        SHOW_IS_IMPERMEABLE_IN_JEI = CLIENT_BUILDER.comment("Show if the block is impermeable in the info page")
                .define("show_is_impermeable_info_page", true);
        SHOW_IS_REPLACEABLE_IN_JEI = CLIENT_BUILDER.comment("Show if the block is replaceable (if your place another block on it) in the info page")
                .define("show_is_replaceable_info_page", true);
        SHOW_IS_ANIMAL_SPAWNABLE_IN_JEI = CLIENT_BUILDER.comment("Show if animals can naturally spawn on the block in the info page")
                .define("show_is_animal_spawnable_info_page", true);
        SHOW_IS_BEACON_BASE_IN_JEI = CLIENT_BUILDER.comment("Show if the block is a beacon base block in the info page")
                .define("show_is_beacon_base_info_page", true);
        SHOW_IS_INFINIBURN_IN_JEI = CLIENT_BUILDER.comment("Show if the block infinitely burns in the info page")
                .define("show_is_infiniburn_info_page", true);
        SHOW_DAMPENS_VIBRATIONS_IN_JEI = CLIENT_BUILDER.comment("Show if the block dampens vibrations in the info page")
                .define("show_dampens_vibrations_info_page", true);
        SHOW_IS_PATHFINDABLE_IN_JEI = CLIENT_BUILDER.comment("Show if the block is pathfindable in the info page")
                .define("show_is_pathfindable_info_page", true);
        CLIENT_BUILDER.pop();

        ConfigHelper.setCategory(CLIENT_BUILDER, "item_info_pages");
        ENABLE_JEI_ITEM_PAGES = CLIENT_BUILDER.comment("Enable JEI/REI/EMI info pages")
                .define("enable_item_info_pages", true);
        SHOW_MAX_SIZE_IN_JEI = CLIENT_BUILDER.comment("Show the maximum stack size in the info page")
                .define("show_max_size_info_page", true);
        SHOW_MAX_DAMAGE_IN_JEI = CLIENT_BUILDER.comment("Show the maximum damage (~durability) in the info page")
                .define("show_max_damage_info_page", true);
        SHOW_DAMAGE_IN_JEI = CLIENT_BUILDER.comment("Show the current damage in the info page")
                .define("show_damage_info_page", true);
        SHOW_STONE_MINING_SPEED_IN_JEI = CLIENT_BUILDER.comment("Show the mining speed of stone in the info page (only on tools)")
                .define("show_stone_mining_speed_info_page", true);
        SHOW_DIRT_MINING_SPEED_IN_JEI = CLIENT_BUILDER.comment("Show the mining speed of dirt in the info page (only on tools)")
                .define("show_dirt_mining_speed_info_page", true);
        SHOW_WOOD_MINING_SPEED_IN_JEI = CLIENT_BUILDER.comment("Show the mining speed of logs in the info page (only on tools)")
                .define("show_show_wood_mining_speed_info_page", true);
        SHOW_IS_ENCHANTABLE_IN_JEI = CLIENT_BUILDER.comment("Show if the item is enchantable in the info page")
                .define("show_is_enchantable_info_page", true);
        SHOW_IS_FOOD_IN_JEI = CLIENT_BUILDER.comment("Show if the item is food in the info page")
                .define("show_is_food_info_page", true);
        SHOW_IS_DYABLE_IN_JEI = CLIENT_BUILDER.comment("Show if the item is dyable in the info page")
                .define("show_is_dyable_info_page", true);
        SHOW_IS_BEACON_PAYMENT_IN_JEI = CLIENT_BUILDER.comment("Show if the item is a beacon payment in the info page")
                .define("show_is_beacon_payment_info_page", true);
        SHOW_IS_TRIM_MATERIAL_IN_JEI = CLIENT_BUILDER.comment("Show if the item is a trim material in the info page")
                .define("show_is_trim_material_info_page", true);
        SHOW_IS_TRIMMABLE_IN_JEI = CLIENT_BUILDER.comment("Show if the item is trimmable in the info page")
                .define("show_is_trimmable_info_page", true);
        SHOW_IS_GRINDSTONE_REPAIRABLE_IN_JEI = CLIENT_BUILDER.comment("Show if the item is repairable on the grindstone in the info page")
                .define("show_is_grindstone_repairable_info_page", true);
        SHOW_IS_PIGLIN_CURRENCY_IN_JEI = CLIENT_BUILDER.comment("Show if the item is accepted as piglin currency in the info page")
                .define("show_is_piglin_currency_info_page", true);
        SHOW_MAKES_PIGLINS_NEUTRAL_IN_JEI = CLIENT_BUILDER.comment("Show if the item makes piglins neutral in the info page")
                .define("show_makes_piglins_neutral_info_page", true);
        CLIENT_BUILDER.pop();

        SERVER_CONFIG = SERVER_BUILDER.build();
        CLIENT_CONFIG = CLIENT_BUILDER.build();
    }

    public static InformationTypes getTooltipHintSize() {
        return TOOLTIP_HINT_SIZE.get();
    }

    public static boolean getUseCtrlInsteadOfShift() {
        return USE_CTRL_INSTEAD_OF_SHIFT.get();
    }

    public static boolean isBlockTooltipsEnabled() {
        return ENABLE_BLOCK_TOOLTIPS.get();
    }

    public static boolean isRegistryNameShown() {
        return SHOW_REGISTRY_NAME.get();
    }

    public static boolean isDestroyTimeShown() {
        return SHOW_DESTROY_TIME.get();
    }

    public static boolean isExplosionResistanceShown() {
        return SHOW_EXPLOSION_RESISTANCE.get();
    }

    public static boolean isJumpFactorShown() {
        return SHOW_JUMP_FACTOR.get();
    }

    public static boolean isLightLevelShown() {
        return SHOW_LIGHT_LEVEL.get();
    }

    public static boolean isSpeedFactorShown() {
        return SHOW_SPEED_FACTOR.get();
    }

    public static boolean isFrictionShown() {
        return SHOW_FRICTION.get();
    }

    public static boolean isFlammableFlagShown() {
        return SHOW_IF_FLAMMABLE.get();
    }

    public static boolean isSolidFlagShown() {
        return SHOW_IF_SOLID.get();
    }

    public static boolean isInstrumentShown() {
        return SHOW_INSTRUMENT.get();
    }

    public static boolean isMapColorShown() {
        return SHOW_MAP_COLOR.get();
    }

    public static boolean isGravityAffectedFlagShown() {
        return SHOW_IS_GRAVITY_AFFECTED.get();
    }

    public static boolean isCorrectToolRequiredFlagShown() {
        return SHOW_REQUIRES_CORRECT_TOOL.get();
    }

    public static boolean isClimbableFlagShown() {
        return SHOW_IS_CLIMBABLE.get();
    }

    public static boolean isImpermeableFlagShown() {
        return SHOW_IS_IMPERMEABLE.get();
    }

    public static boolean isReplaceableFlagShown() {
        return SHOW_IS_REPLACEABLE.get();
    }

    public static boolean isAnimalSpawnableFlagShown() {
        return SHOW_IS_ANIMAL_SPAWNABLE.get();
    }

    public static boolean isBeaconBaseFlagShown() {
        return SHOW_IS_BEACON_BASE.get();
    }

    public static boolean isInfiniburnFlagShown() {
        return SHOW_IS_INFINIBURN.get();
    }

    public static boolean isVibrationDampeningShown() {
        return SHOW_DAMPENS_VIBRATIONS.get();
    }

    public static boolean isPathfindableFlagShown() {
        return SHOW_IS_PATHFINDABLE.get();
    }

    // Client Config Getters - Item Tooltips
    public static boolean isItemTooltipsEnabled() {
        return ENABLE_ITEM_TOOLTIPS.get();
    }

    public static boolean isMaxSizeShown() {
        return SHOW_MAX_SIZE.get();
    }

    public static boolean isMaxDamageShown() {
        return SHOW_MAX_DAMAGE.get();
    }

    public static boolean isDamageShown() {
        return SHOW_DAMAGE.get();
    }

    public static boolean isStoneMiningSpeedShown() {
        return SHOW_STONE_MINING_SPEED.get();
    }

    public static boolean isDirtMiningSpeedShown() {
        return SHOW_DIRT_MINING_SPEED.get();
    }

    public static boolean isWoodMiningSpeedShown() {
        return SHOW_WOOD_MINING_SPEED.get();
    }

    public static boolean isEnchantableFlagShown() {
        return SHOW_IS_ENCHANTABLE.get();
    }

    public static boolean isFoodFlagShown() {
        return SHOW_IS_FOOD.get();
    }

    public static boolean isDyableFlagShown() {
        return SHOW_IS_DYABLE.get();
    }

    public static boolean isBeaconPaymentFlagShown() {
        return SHOW_IS_BEACON_PAYMENT.get();
    }

    public static boolean isTrimMaterialFlagShown() {
        return SHOW_IS_TRIM_MATERIAL.get();
    }

    public static boolean isTrimmableFlagShown() {
        return SHOW_IS_TRIMMABLE.get();
    }

    public static boolean isGrindstoneRepairableFlagShown() {
        return SHOW_IS_GRINDSTONE_REPAIRABLE.get();
    }

    public static boolean isPiglinCurrencyFlagShown() {
        return SHOW_IS_PIGLIN_CURRENCY.get();
    }

    public static boolean isPiglinNeutralityFlagShown() {
        return SHOW_MAKES_PIGLINS_NEUTRAL.get();
    }

    // Client Config Getters - JEI Block Info Pages
    public static boolean isJeiBlockPagesEnabled() {
        return ENABLE_JEI_BLOCK_PAGES.get();
    }

    public static boolean isRegistryNameInJeiShown() {
        return SHOW_REGISTRY_NAME_IN_JEI.get();
    }

    public static boolean isDestroyTimeInJeiShown() {
        return SHOW_DESTROY_TIME_IN_JEI.get();
    }

    public static boolean isExplosionResistanceInJeiShown() {
        return SHOW_EXPLOSION_RESISTANCE_IN_JEI.get();
    }

    public static boolean isLightLevelInJeiShown() {
        return SHOW_LIGHT_LEVEL_IN_JEI.get();
    }

    public static boolean isJumpFactorInJeiShown() {
        return SHOW_JUMP_FACTOR_IN_JEI.get();
    }

    public static boolean isSpeedFactorInJeiShown() {
        return SHOW_SPEED_FACTOR_IN_JEI.get();
    }

    public static boolean isFrictionInJeiShown() {
        return SHOW_FRICTION_IN_JEI.get();
    }

    public static boolean isFlammableInJeiShown() {
        return SHOW_IF_FLAMMABLE_IN_JEI.get();
    }

    public static boolean isSolidInJeiShown() {
        return SHOW_IF_SOLID_IN_JEI.get();
    }

    public static boolean isInstrumentInJeiShown() {
        return SHOW_INSTRUMENT_IN_JEI.get();
    }

    public static boolean isMapColorInJeiShown() {
        return SHOW_MAP_COLOR_IN_JEI.get();
    }

    public static boolean isGravityAffectedInJeiShown() {
        return SHOW_IS_GRAVITY_AFFECTED_IN_JEI.get();
    }

    public static boolean isCorrectToolRequiredInJeiShown() {
        return SHOW_REQUIRES_CORRECT_TOOL_IN_JEI.get();
    }

    public static boolean isClimbableInJeiShown() {
        return SHOW_IS_CLIMBABLE_IN_JEI.get();
    }

    public static boolean isImpermeableInJeiShown() {
        return SHOW_IS_IMPERMEABLE_IN_JEI.get();
    }

    public static boolean isReplaceableInJeiShown() {
        return SHOW_IS_REPLACEABLE_IN_JEI.get();
    }

    public static boolean isAnimalSpawnableInJeiShown() {
        return SHOW_IS_ANIMAL_SPAWNABLE_IN_JEI.get();
    }

    public static boolean isBeaconBaseInJeiShown() {
        return SHOW_IS_BEACON_BASE_IN_JEI.get();
    }

    public static boolean isInfiniburnInJeiShown() {
        return SHOW_IS_INFINIBURN_IN_JEI.get();
    }

    public static boolean isVibrationDampeningInJeiShown() {
        return SHOW_DAMPENS_VIBRATIONS_IN_JEI.get();
    }

    public static boolean isPathfindableInJeiShown() {
        return SHOW_IS_PATHFINDABLE_IN_JEI.get();
    }

    // Client Config Getters - JEI Item Info Pages
    public static boolean isJeiItemPagesEnabled() {
        return ENABLE_JEI_ITEM_PAGES.get();
    }

    public static boolean isMaxSizeInJeiShown() {
        return SHOW_MAX_SIZE_IN_JEI.get();
    }

    public static boolean isMaxDamageInJeiShown() {
        return SHOW_MAX_DAMAGE_IN_JEI.get();
    }

    public static boolean isDamageInJeiShown() {
        return SHOW_DAMAGE_IN_JEI.get();
    }

    public static boolean isStoneMiningSpeedInJeiShown() {
        return SHOW_STONE_MINING_SPEED_IN_JEI.get();
    }

    public static boolean isDirtMiningSpeedInJeiShown() {
        return SHOW_DIRT_MINING_SPEED_IN_JEI.get();
    }

    public static boolean isWoodMiningSpeedInJeiShown() {
        return SHOW_WOOD_MINING_SPEED_IN_JEI.get();
    }

    public static boolean isEnchantableInJeiShown() {
        return SHOW_IS_ENCHANTABLE_IN_JEI.get();
    }

    public static boolean isFoodInJeiShown() {
        return SHOW_IS_FOOD_IN_JEI.get();
    }

    public static boolean isDyableInJeiShown() {
        return SHOW_IS_DYABLE_IN_JEI.get();
    }

    public static boolean isBeaconPaymentInJeiShown() {
        return SHOW_IS_BEACON_PAYMENT_IN_JEI.get();
    }

    public static boolean isTrimMaterialInJeiShown() {
        return SHOW_IS_TRIM_MATERIAL_IN_JEI.get();
    }

    public static boolean isTrimmableInJeiShown() {
        return SHOW_IS_TRIMMABLE_IN_JEI.get();
    }

    public static boolean isGrindstoneRepairableInJeiShown() {
        return SHOW_IS_GRINDSTONE_REPAIRABLE_IN_JEI.get();
    }

    public static boolean isPiglinCurrencyInJeiShown() {
        return SHOW_IS_PIGLIN_CURRENCY_IN_JEI.get();
    }

    public static boolean isPiglinNeutralityInJeiShown() {
        return SHOW_MAKES_PIGLINS_NEUTRAL_IN_JEI.get();
    }

}