package seven;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by trevor on 12/29/15.
 */
public class Day7Test {
    @Test
    public void testArrowAssignsNumber() {
        Day7 test = new Day7("123 -> x");
        Assert.assertEquals(123, test.getVariable("x"));

        test = new Day7("456 -> y");
        Assert.assertEquals(456, test.getVariable("y"));
    }

    @Test
    public void testMultipleLineNumberAssignment() {
        Day7 test = new Day7("123 -> x\n456 -> y");
        Assert.assertEquals(123, test.getVariable("x"));
        Assert.assertEquals(456, test.getVariable("y"));
    }

    @Test
    public void testArrowAssignsAnd() {
        Day7 test = new Day7(
                "123 -> x\n" +
                "456 -> y\n" +
                "x AND y -> d");
        Assert.assertEquals(72, test.getVariable("d"));
    }

    @Test
    public void testArrowAssignsOr() {
        Day7 test = new Day7(
                "123 -> x\n" +
                "456 -> y\n" +
                "x OR y -> d\n");
        Assert.assertEquals(507, test.getVariable("d"));
    }
}
