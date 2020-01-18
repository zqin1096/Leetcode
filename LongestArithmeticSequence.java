import java.util.HashMap;
import java.util.Map;

/*
Given an array A of integers, return the length of the longest arithmetic
subsequence in A.

Recall that a subsequence of A is a list A[i_1], A[i_2], ..., A[i_k] with
0 <= i_1 < i_2 < ... < i_k <= A.length - 1, and that a sequence B is arithmetic
if B[i+1] - B[i] are all the same value (for 0 <= i < B.length - 1).
 */
public class LongestArithmeticSequence {
    // DP.
    public int longestArithSeqLength(int[] A) {
        int length = A.length;
        // dp[i][j] represent the longest length of the subsequence ends with
        // A[j] and A[i].
        int[][] dp = new int[length][length];
        int max = 2;
        for (int i = 0; i < length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            // j starts at index 0 so the previous elements and their
            // positions can be stored in map.
            for (int j = 0; j < i; j++) {
                // At least 2.
                dp[i][j] = 2;
                int difference = A[i] - A[j];
                // Find if search exists.
                int search = A[j] - difference;
                if (map.containsKey(search)) {
                    dp[i][j] = dp[j][map.get(search)] + 1;
                }
                // Store the value and its corresponding position.
                map.put(A[j], j);
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
