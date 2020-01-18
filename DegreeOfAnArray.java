import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int[] range = map.get(nums[i]);
                map.put(nums[i], new int[]{range[0], i, range[2] + 1});
            } else {
                map.put(nums[i], new int[]{i, i, 1});
            }
        }
        int largestFrequency = 0;
        int smallestLength = Integer.MAX_VALUE;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] range = entry.getValue();
            if (range[2] > largestFrequency) {
                largestFrequency = range[2];
                smallestLength = range[1] - range[0] + 1;
            } else if (range[2] == largestFrequency) {
                smallestLength = Math.min(smallestLength,
                        range[1] - range[0] + 1);
            }
        }
        return smallestLength;
    }
}
