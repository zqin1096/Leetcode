/*
Given an integer array A, you partition the array into (contiguous) subarrays
of length at most K.  After partitioning, each subarray has their values
changed to become the maximum value of that subarray.

Return the largest sum of the given array after partitioning.
 */
public class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] A, int K) {
        // dp[i] represents the largest sum after partitioning from the first
        // element to the i-th element.
        // dp[0]: base case (when all elements are in the same partition,
        // there is no partition for the previous elements, which means the
        // sum for previous elements is 0).
        int[] dp = new int[A.length + 1];
        // i represents the i-th element (1-base) (or the number of elements).
        for (int i = 1; i <= A.length; i++) {
            int max = Integer.MIN_VALUE;
            // j represents the length of the partition (1 - K).
            for (int j = 1; j <= Math.min(i, K); j++) {
                max = Math.max(max, A[i - j]);
                // For j = 1 .. k, dp[i] is the maximum of dp[i-j] + max
                // (A[i-1], ..., A[i-j]) * j .
                dp[i] = Math.max(dp[i], dp[i - j] + max * j);
            }
        }
        return dp[A.length];
    }
}
