import java.util.HashMap;
import java.util.Map;

public class XOfAKindInADeckOfCards {
    public boolean hasGroupsSizeX(int[] deck) {
        // Count the number of each card.
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : deck) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int value : map.values()) {
            min = Math.min(min, value);
        }

        if (min == 1) {
            return false;
        } else {
            for (int i : map.values()) {
                for (int j : map.values()) {
                    // Check if two numbers are relatively prime.
                    if (gcd(i, j) == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private int gcd(int a, int b) {
        if (a == 0 || b == 0)
            return 0;

        if (a == b)
            return a;

        if (a > b)
            return gcd(a - b, b);
        return gcd(a, b - a);
    }
}
