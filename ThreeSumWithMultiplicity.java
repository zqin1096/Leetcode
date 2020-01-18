import java.util.HashMap;
import java.util.Map;

public class ThreeSumWithMultiplicity {
    public int threeSumMulti(int[] A, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int mod = 1000000007;
        for (int i = 0; i < A.length; i++) {
            // From the start to the end of the array, the answer is guaranteed to be correct.
            // Prevent overflow.
            ans = (ans + map.getOrDefault(target - A[i], 0)) % mod;
            for (int j = 0; j < i; j++) {
                int twoSum = A[i] + A[j];
                // Store the frequencies of the sum (first two numbers).
                map.put(twoSum, map.getOrDefault(twoSum, 0) + 1);
            }
        }
        return ans;
    }
}
