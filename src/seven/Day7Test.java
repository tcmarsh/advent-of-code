package seven;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by trevor on 12/29/15.
 */
public class Day7Test {
    @Test
    public void arrowAssignsNumber() {
        Day7 test = new Day7("123 -> x");
        Assert.assertEquals(123, test.getVariable("x"));

        test = new Day7("456 -> y");
        Assert.assertEquals(456, test.getVariable("y"));
    }

    @Test
    public void multipleLineNumberAssignment() {
        Day7 test = new Day7("123 -> x\n456 -> y");
        Assert.assertEquals(123, test.getVariable("x"));
        Assert.assertEquals(456, test.getVariable("y"));
    }

    @Test
    public void arrowAssignsAnd() {
        Day7 test = new Day7(
                "123 -> x\n" +
                "456 -> y\n" +
                "x AND y -> d");
        Assert.assertEquals(72, test.getVariable("d"));
    }

    @Test
    public void arrowAssignsOr() {
        Day7 test = new Day7(
                "123 -> x\n" +
                "456 -> y\n" +
                "x OR y -> d\n");
        Assert.assertEquals(507, test.getVariable("d"));
    }

    @Test
    public void arrowAssignsLeftShift() {
        Day7 test = new Day7("123 -> x\nx LSHIFT 2 -> d");
        Assert.assertEquals(492, test.getVariable("d"));
    }

    @Test
    public void arrowAssignsRightShift() {
        Day7 test = new Day7("456 -> y\ny RSHIFT 2 -> d");
        Assert.assertEquals(114, test.getVariable("d"));
    }

    @Test
    public void arrowAssignsNot() {
        Day7 test = new Day7(
                "123 -> x\n" +
                "456 -> y\n" +
                "NOT x -> d\n" +
                "NOT y -> e\n");
        Assert.assertEquals(65412, test.getVariable("d"));
        Assert.assertEquals(65079, test.getVariable("e"));
    }

    @Test
    public void adventTestCase() {
        Day7 test = new Day7(
                "123 -> x\n" +
                "456 -> y\n" +
                "x AND y -> d\n" +
                "x OR y -> e\n" +
                "x LSHIFT 2 -> f\n" +
                "y RSHIFT 2 -> g\n" +
                "NOT x -> h\n" +
                "NOT y -> i");
        Assert.assertEquals(72, test.getVariable("d"));
        Assert.assertEquals(507, test.getVariable("e"));
        Assert.assertEquals(492, test.getVariable("f"));
        Assert.assertEquals(114, test.getVariable("g"));
        Assert.assertEquals(65412, test.getVariable("h"));
        Assert.assertEquals(65079, test.getVariable("i"));
        Assert.assertEquals(123, test.getVariable("x"));
        Assert.assertEquals(456, test.getVariable("y"));
    }
}
