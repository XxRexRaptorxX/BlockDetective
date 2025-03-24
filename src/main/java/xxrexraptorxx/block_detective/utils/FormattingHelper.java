package xxrexraptorxx.block_detective.utils;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.material.MapColor;
import xxrexraptorxx.block_detective.main.References;

import java.lang.reflect.Field;

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


    public static Component getPageDescription(Block block) {
        String textSeparator = ": ";
        String lineSeperator = "\n";

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
            description.append(Component.literal(String.valueOf(block.defaultBlockState().getLightEmission())).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_FRICTION_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.friction").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(String.valueOf(block.getFriction())).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_IF_SOLID_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.solid").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.ConvertBooleanToString(block.defaultBlockState().isSolid())).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_REQUIRES_CORRECT_TOOL_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.requires_correct_tool").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.ConvertBooleanToString(block.defaultBlockState().requiresCorrectToolForDrops())).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_IS_GRAVITY_AFFECTED_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.is_gravity_affected").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.ConvertBooleanToString(block instanceof FallingBlock)).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_MAP_COLOR_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.map_color").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.FormatRegistryNames(FormattingHelper.getMapColorName(block.defaultMapColor()))).withStyle(ChatFormatting.WHITE));
        }
        if (Config.SHOW_INSTRUMENT_IN_JEI.get()) {
            description.append(lineSeperator);
            description.append(Component.translatable("message.block_detective.instrument").append(textSeparator).withStyle(ChatFormatting.DARK_GRAY));
            description.append(Component.literal(FormattingHelper.FormatRegistryNames(String.valueOf(block.defaultBlockState().instrument()))).withStyle(ChatFormatting.WHITE));
        }

        description.append(lineSeperator + lineSeperator);
        description.append(Component.translatable("message.block_detective.information").append(lineSeperator).withStyle(ChatFormatting.DARK_GRAY));
        description.append(Component.literal(References.NAME).withStyle(ChatFormatting.YELLOW));

        return description;
    }

}
