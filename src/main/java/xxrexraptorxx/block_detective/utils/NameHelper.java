package xxrexraptorxx.block_detective.utils;

import dev.architectury.networking.forge.NetworkManagerImpl;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.neoforged.neoforge.common.Tags;
import xxrexraptorxx.block_detective.main.References;
import xxrexraptorxx.magmacore.utils.FormattingHelper;

import java.lang.reflect.Field;
import java.util.Objects;

public class NameHelper {

    /**
     * Converts "true" or "false" boolean values to "yes" or "no".
     */
    public static String ConvertBooleanToString(Boolean value) {
        if (value) {
            return FormattingHelper.setModLangComponent("message", References.MODID, "yes").getString();
        } else {
            return FormattingHelper.setModLangComponent("message", References.MODID, "no").getString();
        }
    }


    public static String getMapColorName(MapColor color) {
        try {
            Field[] fields = MapColor.class.getDeclaredFields();
            for (Field field : fields) {
                if (java.lang.reflect.Modifier.isStatic(field.getModifiers()) && field.getType() == MapColor.class) {
                    MapColor mapColor = (MapColor) field.get(null);
                    if (mapColor == color) {
                        return field.getName();
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "Unknown";
    }


    private static final String textSeparator = ": ";
    private static final String lineSeperator = "\n";


    public static Component getPageDescription(Block block) {
        BlockState state = block.defaultBlockState();

        MutableComponent description = Component.literal(BuiltInRegistries.ITEM.getKey(block.asItem()).toString()).withStyle(ChatFormatting.YELLOW)
            .append(lineSeperator);

        if (Config.isDestroyTimeInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "destroy_time").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(String.valueOf(block.defaultDestroyTime())).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isExplosionResistanceInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "explosion_resistance").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(String.valueOf(block.getExplosionResistance())).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isJumpFactorInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "jump_factor").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(String.valueOf(block.getJumpFactor())).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isSpeedFactorInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "speed_factor").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(String.valueOf(block.getSpeedFactor())).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isLightLevelInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "light_level").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(String.valueOf(state.getLightEmission())).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isFrictionInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "friction").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(String.valueOf(block.getFriction())).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isSolidInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "solid").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(NameHelper.ConvertBooleanToString(state.isSolid())).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isCorrectToolRequiredInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "requires_correct_tool").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(NameHelper.ConvertBooleanToString(state.requiresCorrectToolForDrops())).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isGravityAffectedInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "is_gravity_affected").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(NameHelper.ConvertBooleanToString(block instanceof FallingBlock)).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isClimbableInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "climbable").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(NameHelper.ConvertBooleanToString(state.is(BlockTags.CLIMBABLE))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isMapColorInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "map_color").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.capitalizeWords(NameHelper.getMapColorName(block.defaultMapColor()))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isInstrumentInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "instrument").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.capitalizeWords(String.valueOf(state.instrument()))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isImpermeableInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "impermeable").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(NameHelper.ConvertBooleanToString(state.is(BlockTags.IMPERMEABLE))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isReplaceableInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "replaceable").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(NameHelper.ConvertBooleanToString(state.is(BlockTags.REPLACEABLE))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isAnimalSpawnableInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "animal_spawnable").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(NameHelper.ConvertBooleanToString(state.is(BlockTags.ANIMALS_SPAWNABLE_ON))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isBeaconBaseInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "beacon_base").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(NameHelper.ConvertBooleanToString(state.is(BlockTags.BEACON_BASE_BLOCKS))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isInfiniburnInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "infiniburn").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(NameHelper.ConvertBooleanToString(state.is(BlockTags.INFINIBURN_END) || state.is(BlockTags.INFINIBURN_NETHER) || state.is(BlockTags.INFINIBURN_OVERWORLD))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isVibrationDampeningInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "dampens_vibrations").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(NameHelper.ConvertBooleanToString(state.is(BlockTags.DAMPENS_VIBRATIONS))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isPathfindableInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "pathfindable").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(NameHelper.ConvertBooleanToString(state.isPathfindable(PathComputationType.LAND))).withStyle(ChatFormatting.WHITE));
        }

        description.append(lineSeperator + lineSeperator);
        description.append(FormattingHelper.setModLangComponent("message", References.MODID, "information").append(lineSeperator).withStyle(ChatFormatting.DARK_GRAY));
        description.append(Component.literal(References.NAME).withStyle(ChatFormatting.YELLOW));

        return description;
    }


    public static Component getPageDescription(Item item) {
        ItemStack stack = new ItemStack(item);

        MutableComponent description = Component.literal(BuiltInRegistries.ITEM.getKey(item).toString()).withStyle(ChatFormatting.YELLOW)
            .append(lineSeperator);

        if (Config.isMaxSizeInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "max_size").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(String.valueOf(item.getMaxStackSize(stack))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isMaxDamageInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "max_damage").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(String.valueOf(item.getMaxDamage(stack))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isDamageInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "damage").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(String.valueOf(item.getDamage(stack))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isStoneMiningSpeedInJeiShown() && item.components().has(DataComponents.TOOL)) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "stone_mining_speed").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(String.valueOf(item.getDestroySpeed(stack, Blocks.STONE.defaultBlockState()))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isDirtMiningSpeedInJeiShown() && item.components().has(DataComponents.TOOL)) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "dirt_mining_speed").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(String.valueOf(item.getDestroySpeed(stack, Blocks.DIRT.defaultBlockState()))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isWoodMiningSpeedInJeiShown() && item.components().has(DataComponents.TOOL)) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "wood_mining_speed").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(String.valueOf(item.getDestroySpeed(stack, Blocks.OAK_LOG.defaultBlockState()))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isEnchantableInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "enchantable").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(NameHelper.ConvertBooleanToString(stack.is(Tags.Items.ENCHANTABLES))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isFoodInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "food").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(NameHelper.ConvertBooleanToString(stack.is(Tags.Items.FOODS))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isDyableInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "dyable").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(NameHelper.ConvertBooleanToString(stack.is(ItemTags.DYEABLE))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isBeaconPaymentInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "beacon_payment").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(NameHelper.ConvertBooleanToString(stack.is(ItemTags.BEACON_PAYMENT_ITEMS))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isTrimMaterialInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "trim_material").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(NameHelper.ConvertBooleanToString(stack.is(ItemTags.TRIM_MATERIALS))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isTrimmableInJeiShown() && item.components().has(DataComponents.EQUIPPABLE)) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "trimmable").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(NameHelper.ConvertBooleanToString(stack.is(ItemTags.TRIMMABLE_ARMOR))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isGrindstoneRepairableInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "grindstone_repair").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(String.valueOf(item.canGrindstoneRepair(stack))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isPiglinCurrencyInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "piglin_currency").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(NameHelper.ConvertBooleanToString(item.isPiglinCurrency(stack))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.isPiglinNeutralityInJeiShown()) {
            description.append(lineSeperator);
            description.append(FormattingHelper.setModLangComponent("message", References.MODID, "piglins_neutral").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(NameHelper.ConvertBooleanToString(item.makesPiglinsNeutral(stack, Objects.requireNonNull(NetworkManagerImpl.getClientPlayer())))).withStyle(ChatFormatting.WHITE));
        }

        description.append(lineSeperator + lineSeperator);
        description.append(FormattingHelper.setModLangComponent("message", References.MODID, "information").append(lineSeperator).withStyle(ChatFormatting.DARK_GRAY));
        description.append(Component.literal(References.NAME).withStyle(ChatFormatting.YELLOW));

        return description;
    }

}
