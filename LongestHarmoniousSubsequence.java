import java.util.HashMap;
import java.util.Map;

/*
We define a harmonious array is an array where the difference between its
maximum value and its minimum value is exactly 1.

Now, given an integer array, you need to find the length of its longest
harmonious subsequence among all its possible subsequences.
 */
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        // Count the frequency of each value.
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int max = 0;
        for (int i : nums) {
            // Since the difference between max value and min value in a
            // harmonious subsequence is 1, find the number of i and
            // the number of adjacent value of i if it exists, and add them
            // together, which is the length of a harmonious subsequence.
            // Only need to check i + 1.
            if (map.containsKey(i + 1)) {
                max = Math.max(max, map.get(i) + map.get(i + 1));
            }
        }
        return max;
    }
}
