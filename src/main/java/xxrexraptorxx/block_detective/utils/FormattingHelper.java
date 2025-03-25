package xxrexraptorxx.block_detective.utils;

import dev.architectury.networking.forge.NetworkManagerImpl;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.DiggerItem;
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

import java.lang.reflect.Field;
import java.util.Objects;

public class FormattingHelper {

    /**
     * Converts "true" or "false" boolean values to "yes" or "no".
     */
    public static String ConvertBooleanToString(Boolean value) {
        if (value) {
            return Component.translatable("message.block_detective.yes").getString();
        } else {
            return Component.translatable("message.block_detective.no").getString();
        }
    }


    /**
     * Replaces all '_' chars with a whitespace and sets the first letter of all words to upper case.
     */
    public static String FormatRegistryNames(String name) {
        name = name.replace("_", " ");
        String[] words = name.split(" ");
        StringBuilder formattedName = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                formattedName.append(word.substring(0, 1).toUpperCase());
                formattedName.append(word.substring(1).toLowerCase());
                formattedName.append(" ");
            }
        }

        return formattedName.toString().trim();
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

        if (Config.SHOW_DESTROY_TIME_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.destroy_time").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(String.valueOf(block.defaultDestroyTime())).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_EXPLOSION_RESISTANCE_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.explosion_resistance").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(String.valueOf(block.getExplosionResistance())).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_JUMP_FACTOR_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.jump_factor").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(String.valueOf(block.getJumpFactor())).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_SPEED_FACTOR_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.speed_factor").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(String.valueOf(block.getSpeedFactor())).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_LIGHT_LEVEL_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.light_level").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(String.valueOf(state.getLightEmission())).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_FRICTION_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.friction").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(String.valueOf(block.getFriction())).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_IF_SOLID_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.solid").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.ConvertBooleanToString(state.isSolid())).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_REQUIRES_CORRECT_TOOL_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.requires_correct_tool").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.ConvertBooleanToString(state.requiresCorrectToolForDrops())).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_IS_GRAVITY_AFFECTED_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.is_gravity_affected").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.ConvertBooleanToString(block instanceof FallingBlock)).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_IS_CLIMBABLE_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.climbable").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.ConvertBooleanToString(state.is(BlockTags.CLIMBABLE))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_MAP_COLOR_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.map_color").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.FormatRegistryNames(FormattingHelper.getMapColorName(block.defaultMapColor()))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_INSTRUMENT_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.instrument").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.FormatRegistryNames(String.valueOf(state.instrument()))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_IS_IMPERMEABLE_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.impermeable").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.ConvertBooleanToString(state.is(BlockTags.IMPERMEABLE))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_IS_REPLACEABLE_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.replaceable").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.ConvertBooleanToString(state.is(BlockTags.REPLACEABLE))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_IS_ANIMAL_SPAWNABLE_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.animal_spawnable").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.ConvertBooleanToString(state.is(BlockTags.ANIMALS_SPAWNABLE_ON))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_IS_BEACON_BASE_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.beacon_base").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.ConvertBooleanToString(state.is(BlockTags.BEACON_BASE_BLOCKS))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_IS_INFINIBURN_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.infiniburn").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.ConvertBooleanToString(state.is(BlockTags.INFINIBURN_END) || state.is(BlockTags.INFINIBURN_NETHER) || state.is(BlockTags.INFINIBURN_OVERWORLD))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_DAMPENS_VIBRATIONS_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.dampens_vibrations").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.ConvertBooleanToString(state.is(BlockTags.DAMPENS_VIBRATIONS))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_IS_PATHFINDABLE_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.pathfindable").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.ConvertBooleanToString(state.isPathfindable(PathComputationType.LAND))).withStyle(ChatFormatting.WHITE));
        }

        description.append(lineSeperator + lineSeperator);
        description.append(Component.translatable("message.block_detective.information").append(lineSeperator).withStyle(ChatFormatting.DARK_GRAY));
        description.append(Component.literal(References.NAME).withStyle(ChatFormatting.YELLOW));

        return description;
    }


    public static Component getPageDescription(Item item) {
        ItemStack stack = new ItemStack(item);

        MutableComponent description = Component.literal(BuiltInRegistries.ITEM.getKey(item).toString()).withStyle(ChatFormatting.YELLOW)
            .append(lineSeperator);

        if (Config.SHOW_MAX_SIZE_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.max_size").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(String.valueOf(item.getMaxStackSize(stack))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_MAX_DAMAGE_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.max_damage").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(String.valueOf(item.getMaxDamage(stack))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_DAMAGE_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.damage").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(String.valueOf(item.getDamage(stack))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_STONE_MINING_SPEED_IN_JEI.get() && item instanceof DiggerItem) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.stone_mining_speed").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(String.valueOf(item.getDestroySpeed(stack, Blocks.STONE.defaultBlockState()))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_DIRT_MINING_SPEED_IN_JEI.get() && item instanceof DiggerItem) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.dirt_mining_speed").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(String.valueOf(item.getDestroySpeed(stack, Blocks.DIRT.defaultBlockState()))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_SHOW_WOOD_MINING_SPEED_IN_JEI.get() && item instanceof DiggerItem) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.wood_mining_speed").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(String.valueOf(item.getDestroySpeed(stack, Blocks.OAK_LOG.defaultBlockState()))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_IS_ENCHANTABLE_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.enchantable").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.ConvertBooleanToString(stack.is(Tags.Items.ENCHANTABLES))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_IS_FOOD_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.food").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.ConvertBooleanToString(stack.is(Tags.Items.FOODS))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_IS_DYABLE_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.dyable").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.ConvertBooleanToString(stack.is(ItemTags.DYEABLE))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_IS_BEACON_PAYMENT_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.beacon_payment").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.ConvertBooleanToString(stack.is(ItemTags.BEACON_PAYMENT_ITEMS))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_IS_TRIM_MATERIAL_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.trim_material").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.ConvertBooleanToString(stack.is(ItemTags.TRIM_MATERIALS))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_IS_TRIMMABLE_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.trimmable").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.ConvertBooleanToString(stack.is(ItemTags.TRIMMABLE_ARMOR))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_IS_GRINDSTONE_REPAIRABLE_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.grindstone_repair").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(String.valueOf(item.canGrindstoneRepair(stack))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_IS_PIGLIN_CURRENCY_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.piglin_currency").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.ConvertBooleanToString(item.isPiglinCurrency(stack))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_MAKES_PIGLINS_NEUTRAL_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.piglins_neutral").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.ConvertBooleanToString(item.makesPiglinsNeutral(stack, Objects.requireNonNull(NetworkManagerImpl.getClientPlayer())))).withStyle(ChatFormatting.WHITE));
        }

        description.append(lineSeperator + lineSeperator);
        description.append(Component.translatable("message.block_detective.information").append(lineSeperator).withStyle(ChatFormatting.DARK_GRAY));
        description.append(Component.literal(References.NAME).withStyle(ChatFormatting.YELLOW));

        return description;
    }

}
