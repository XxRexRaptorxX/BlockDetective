package xxrexraptorxx.block_detective.utils;

public class FormattingHelper {

    /**
     * Converts "true" or "false" boolean values to "yes" or "no".
     */
    public static String ConvertBooleanToString(Boolean value) {
        if (value) {
            return "Yes";
        } else {
            return "No";
        }
    }

}
