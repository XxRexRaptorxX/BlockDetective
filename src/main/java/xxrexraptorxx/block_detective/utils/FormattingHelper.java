package xxrexraptorxx.block_detective.utils;

import net.minecraft.network.chat.Component;

public class FormattingHelper {

    /**
     * Converts "true" or "false" boolean values to "yes" or "no".
     */
    public static Component ConvertBooleanToString(Boolean value) {
        if (value) {
            return Component.translatable("message.block_detective.yes");
        } else {
            return Component.translatable("message.block_detective.no");
        }
    }

}
