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
        assignAnd(assignments.split("\n"));
    }

    public void assignVariables(String[] assignments) {
        for (String s: assignments) {
            String[] parts = s.split(" ");
            if (StringUtility.isInteger(parts[0].trim())) {
                variables.put(parts[2], Integer.parseInt(parts[0].trim()));
            }
        }
    }

    public void assignAnd(String[] assignments) {
        for (String s: assignments) {
            String[] parts = s.split("->");
            if (!StringUtility.isInteger(parts[0].trim())) {
                String[] names = parts[0].split(" ");
                variables.put(parts[1].trim(), variables.get(names[0]) & variables.get(names[2]));
            }
        }
    }

    public int getVariable(String variableName) {
        return variables.get(variableName);
    }
}
