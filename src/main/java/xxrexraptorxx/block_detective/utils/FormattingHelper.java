package xxrexraptorxx.block_detective.utils;

import net.minecraft.network.chat.Component;
import net.minecraft.world.level.material.MapColor;

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
}
