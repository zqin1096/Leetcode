import java.util.HashMap;
import java.util.Map;

// Sum of sub-array. Prefix sum.
public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] A, int K) {
        // Remainder and its corresponding frequencies.
        // If the sum of two sub-arrays mod K have the same remainders, their
        // difference is divisible by K.
        // sum(A[0] ~ A[i]) mod K = sum(A[0] ~ A[j]) mod K, then sum(A[i] ~
        // A[j]) is divisible by K.
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        // Boundary condition.
        // If remainder is 0, then it is divisible by K (there is no element
        // before index 0, so the sum of it is 0, which is divisible by K).
        map.put(0, 1);
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            // -1 mod 5 is -1, we want to set it to 4, so we plus K here.
            int mod = sum % K < 0 ? sum % K + K : sum % K;
            ans += map.getOrDefault(mod, 0);
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return ans;
    }
}
