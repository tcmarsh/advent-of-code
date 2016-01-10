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

            int value = 0;
            if (StringUtility.isInteger(statement)) {
                value = Integer.parseInt(statement);
            }
            else {
                value = parseStatementAndInitialize(statement, assignmentStatements);
            }

            variables.put(key, value);
        }
    }

    private int parseStatementAndInitialize(String statement, Map<String, String> assignmentStatements) {
        int value;
        String[] parts = statement.split(" ");

        if (parts.length == 2) {
            initializeVariable(parts[1], assignmentStatements);
            value = ~variables.get(parts[1]) ^ (0xFFFF << 16);
        }
        else if (parts.length == 1) {
            initializeVariable(parts[0], assignmentStatements);
            value = variables.get(parts[0]);
        }
        else {
            int value1 = initializeVariableAndGetValue(parts[0], assignmentStatements);
            int value2 = initializeVariableAndGetValue(parts[2], assignmentStatements);

            value = executeLogic(parts[1], value1, value2);
        }
        return value;
    }

    private int executeLogic(String operator, int operand1, int operand2) {
        int value = 0;

        switch (operator) {
            case "AND":
            case "and":
                value = operand1 & operand2;
                break;
            case "OR":
            case "or":
                value = operand1 | operand2;
                break;
            case "LSHIFT":
            case "lshift":
                value = operand1 << operand2;
                break;
            case "RSHIFT":
            case "rshift":
                value = operand1 >> operand2;
                break;
            default:
                break;
        }

        return value;
    }

    private int initializeVariableAndGetValue(String statementPart, Map<String, String> assignmentStatements) {
        int value1;

        if (!StringUtility.isInteger(statementPart)) {
            initializeVariable(statementPart, assignmentStatements);
            value1 = variables.get(statementPart);
        }
        else {
            value1 = Integer.parseInt(statementPart);
        }

        return value1;
    }

    public int getVariable(String variableName) {
        return variables.get(variableName);
    }
}
