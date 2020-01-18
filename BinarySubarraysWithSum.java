import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {
    // Prefix sum.
    public int numSubarraysWithSum(int[] A, int S) {
        // Set the length to A.length + 1: boundary condition. The first element of sums is zero.
        // During the first iteration: 0 + S, then the value is stored in the map.
        int[] sums = new int[A.length + 1];
        // sums[i + 1] represents the sum from A[0] to A[i].
        for (int i = 0; i < A.length; i++) {
            sums[i + 1] = sums[i] + A[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int sum : sums) {
            // The first element is 0. 0 is not in the map yet. 0 + 0 = 0.
            ans += map.getOrDefault(sum, 0);
            // S is the sum of sub-array.
            // If sum is in sums, it means some sub-arrays have the sum S.
            map.put(sum + S, map.getOrDefault(sum + S, 0) + 1);
        }
        return ans;
    }
}
