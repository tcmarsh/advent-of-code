package seven;

import utility.StringUtility;

import java.io.IOException;

/**
 * Created by trevor on 1/10/16.
 */
public class RunDay7 {
    private Day7 day7;

    public RunDay7(String filename) {
        try {
            day7 = new Day7(StringUtility.readFileIntoString(filename));
        } catch (IOException e) {
            System.err.println("No file found for file: " + filename);
        }
    }

    public int getVariableFromInput(String variableName) {
        return day7.getVariable(variableName);
    }

    public static void main(String[] args) {
        System.out.println("a is " + new RunDay7(args[0]).getVariableFromInput("a"));
    }
}
