import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
    // Build a graph and use depth-first search.
    // Use map to store the equations and values.
    // Multi-value map.
    Map<String, HashMap<String, Double>> map = new HashMap<>();

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        for (int i = 0; i < values.length; i++) {
            String x = equations[i][0];
            String y = equations[i][1];
            double k = values[i];
            // computeIfAbsent returns the new value associated with the specified key, which is a
            // HashMap<String, Double>.
            map.computeIfAbsent(x, key -> new HashMap<String, Double>()).put(y, k);
            map.computeIfAbsent(y, key -> new HashMap<String, Double>()).put(x, 1.0 / k);
        }

        double[] ans = new double[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String x = queries[i][0];
            String y = queries[i][1];
            if (!map.containsKey(x) || !map.containsKey(y)) {
                ans[i] = -1.0;
            } else {
                ans[i] = divide(x, y, new HashSet<String>());
            }
        }
        return ans;
    }

    // x is the current variable, y is the final variable.
    private double divide(String x, String y, Set<String> visited) {
        // Find the destination.
        if (x.equals(y)) {
            return 1.0;
        }
        visited.add(x);
        if (!map.containsKey(x)) {
            return -1.0;
        }
        for (String s : map.get(x).keySet()) {
            if (visited.contains(s)) {
                continue;
            }
            visited.add(s);
            // Keep searching one path until reach either destination or dead end.
            double value = divide(s, y, visited);
            // Return the value if destination is found.
            if (value > 0) {
                return value * map.get(x).get(s);
            }
        }
        // Return -1.0 if reach dead end.
        return -1.0;
    }
}
