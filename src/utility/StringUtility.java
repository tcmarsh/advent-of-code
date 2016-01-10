package utility;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    public static String readFileIntoString(String filename) throws IOException {
        return readFileIntoString(filename, Charset.defaultCharset());
    }
    public static String readFileIntoString(String filename, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(filename));
        return new String(encoded, encoding);
    }
}
