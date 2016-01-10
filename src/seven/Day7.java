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
        Map<String, String> assignmentStatements = parseAssignmentStatements(assignments);

        for (String key: assignmentStatements.keySet()) {
            if (!variables.containsKey(key)) {
                initializeVariable(key, assignmentStatements);
            }
        }
    }

    private Map<String, String> parseAssignmentStatements(String assignments) {
        Map<String, String> assignmentStatements = new HashMap<>();
        for (String assignment: assignments.split("\n")) {
            String[] parts = assignment.split("->");
            String key = parts[1].trim();
            String statement = parts[0].trim();

            assignmentStatements.put(key, statement);
        }
        return assignmentStatements;
    }

    public void initializeVariable(String key, Map<String, String> assignmentStatements) {
        if (!variables.containsKey(key)) {
            String statement = assignmentStatements.get(key);
            if (StringUtility.isInteger(statement)) {
                variables.put(key, Integer.parseInt(statement));
            }
            else {
                String[] parts = statement.split(" ");

                int value = 0;
                if (parts.length == 2) {
                    initializeVariable(parts[1], assignmentStatements);
                    value = ~variables.get(parts[1]) ^ (0xFFFF << 16);
                }
                else {
                    initializeVariable(parts[0], assignmentStatements);
                    if (!StringUtility.isInteger(parts[2])) {
                        initializeVariable(parts[2], assignmentStatements);
                    }

                    switch (parts[1]) {
                        case "AND":
                        case "and":
                            value = variables.get(parts[0]) & variables.get(parts[2]);
                            break;
                        case "OR":
                        case "or":
                            value = variables.get(parts[0]) | variables.get(parts[2]);
                            break;
                        case "LSHIFT":
                        case "lshift":
                            value = variables.get(parts[0]) << Integer.parseInt(parts[2]);
                            break;
                        case "RSHIFT":
                        case "rshift":
                            value = variables.get(parts[0]) >> Integer.parseInt(parts[2]);
                            break;
                        default:
                            break;
                    }
                }
                variables.put(key, value);
            }
        }
    }

    public int getVariable(String variableName) {
        return variables.get(variableName);
    }
}
