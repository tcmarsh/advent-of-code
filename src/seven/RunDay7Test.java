package seven;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by trevor on 1/10/16.
 */
public class RunDay7Test {
    @Test
    public void getVariableFromFileText() {
        RunDay7 run = new RunDay7("src/seven/testday7.txt");
        Assert.assertEquals(123, run.getVariableFromInput("x"));
    }
}
