package utility;

/**
 * Created by trevor on 12/29/15.
 */
public class StringUtility {
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
