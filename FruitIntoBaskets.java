import java.util.Map;

public class FruitIntoBaskets {
    // Longest sub-array with at most 2 different elements (types of fruit).
    public int totalFruit(int[] tree) {
        int max = 0;
        int count = 0;
        int first = 0;
        int second = 0;
        for (int i = 0; i < tree.length; i++) {
            count++;
            if (tree[i] == tree[first]) {
                first = i;
            } else if (second == -1 || tree[i] == tree[second]) {
                second = i;
            } else {
                max = Math.max(max, count - 1);
                // Recalculate count. Include the type (first or second) that appears last, plus the new type.
                count = Math.abs(first - second) + 1;
                // The type of previous element is the first type.
                first = i - 1;
                // The current type becomes the second type.
                second = i;
            }
        }
        return Math.max(count, max);
    }
}
