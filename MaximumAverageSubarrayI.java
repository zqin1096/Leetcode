/*
Given an array consisting of n integers, find the contiguous subarray of given
length k that has the maximum average value. And you need to output the maximum
average value.
 */
public class MaximumAverageSubarrayI {
    // Sliding window.
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        for (int i = 1; i + k - 1 < nums.length; i++) {
            sum -= nums[i - 1];
            sum += nums[i + k - 1];
            max = Math.max(max, sum);
        }
        return (double) max / k;
    }
}
