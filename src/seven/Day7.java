package seven;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by trevor on 12/29/15.
 */
public class Day7 {
    private Map<String, Integer> variables = new HashMap<>();

    public Day7(String assignment) {
        String[] parts = assignment.split(" ");
        variables.put(parts[2], Integer.parseInt(parts[0]));
    }

    public int getVariable(String variableName) {
        return variables.get(variableName);
    }
}
