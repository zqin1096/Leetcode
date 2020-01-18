import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers and an integer k, you need to find the total number
of continuous subarrays whose sum equals to k.
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(sum, 1);
        // Keep computing the sum, if sum - k exists, then k must exist.
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        return result;
    }
}
