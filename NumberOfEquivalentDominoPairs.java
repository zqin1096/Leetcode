import java.util.HashMap;
import java.util.Map;

public class NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        for (int[] domino : dominoes) {
            if (domino[1] < domino[0]) {
                int temp = domino[0];
                domino[0] = domino[1];
                domino[1] = temp;
            }
        }
        Map<String, Integer> map = new HashMap<>();
        for (int[] domino : dominoes) {
            String s = domino[0] + " " + domino[1];
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 0);
            }
        }
        int num = 0;
        for (Integer pair : map.values()) {
            num += (1 + pair) * pair / 2;
        }
        return num;
    }
}
