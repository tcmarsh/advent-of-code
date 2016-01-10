package utility;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by trevor on 1/10/16.
 */
public class StringUtilityTest {
    @Test
    public void testInteger() {
        Assert.assertTrue(StringUtility.isInteger("123"));
        Assert.assertFalse(StringUtility.isInteger("12a"));
    }

    @Test
    public void openValidFile() {
        try {
            Assert.assertEquals("hello", StringUtility.readFileIntoString("test.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void openInvalidFile() {
        try {
            StringUtility.readFileIntoString("invalid.txt");
        } catch (IOException e) {
            Assert.assertEquals("NoSuchFileException: invalid.txt", e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}
