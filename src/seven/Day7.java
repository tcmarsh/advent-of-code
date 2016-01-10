package seven;

import java.util.HashMap;
import java.util.Map;

import utility.StringUtility;

/**
 * Created by trevor on 12/29/15.
 */
public class Day7 {
    private Map<String, Integer> variables = new HashMap<>();

    public Day7(String assignments) {
        assignVariables(assignments.split("\n"));
        assignLogic(assignments.split("\n"));
    }

    public void assignVariables(String[] assignments) {
        for (String s: assignments) {
            String[] parts = s.split(" ");
            if (StringUtility.isInteger(parts[0].trim())) {
                variables.put(parts[2], Integer.parseInt(parts[0].trim()));
            }
        }
    }

    public void assignLogic(String[] assignments) {
        for (String s: assignments) {
            String[] parts = s.split("->");
            if (!StringUtility.isInteger(parts[0].trim())) {
                String[] names = parts[0].split(" ");
                int combined;
                if (names.length == 2) {
                    combined = parseUnaryOperation(names);
                }
                else {
                    combined = parseDyadicOperation(names);
                }
                variables.put(parts[1].trim(), combined);
            }
        }
    }

    private int parseUnaryOperation(String[] names) {
        // The left shifted number and 0xFFFF are to mask off the ones
        // (because Java doesn't believe in unsigned ints)
        return ~variables.get(names[1]) ^ (0xFFFF << 16);
    }

    private int parseDyadicOperation(String[] names) {
        int combined = variables.get(names[0]);

        switch(names[1]) {
            case "AND":
            case "and":
                combined &= variables.get(names[2]);
                break;
            case "OR":
            case "or":
                combined |= variables.get(names[2]);
                break;
            case "LSHIFT":
            case "lshift":
                combined <<= Integer.parseInt(names[2]);
                break;
            case "RSHIFT":
            case "rshift":
                combined >>= Integer.parseInt(names[2]);
                break;
            default:
                break;
        }

        return combined;
    }

    public int getVariable(String variableName) {
        return variables.get(variableName);
    }
}
