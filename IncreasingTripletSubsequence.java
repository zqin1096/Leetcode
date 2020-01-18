/*
Given an unsorted array return whether an increasing subsequence of length 3
exists or not in the array.

Your algorithm should run in O(n) time complexity and O(1) space complexity.
 */
public class IncreasingTripletSubsequence {
    // Greedy.
    public boolean increasingTriplet(int[] nums) {
        // Minimum value.
        int min1 = Integer.MAX_VALUE;
        // Second minimum value.
        int min2 = Integer.MAX_VALUE;
        // If we found a value that is larger than both min1 and min2, then
        // return true (an increasing subsequence of length 3 exists).
        for (int num : nums) {
            if (num <= min1) {
                min1 = num;
            } else if (num <= min2) {
                min2 = num;
            } else {
                // We compare num with min1 first, then compare num with
                // min2. As long as we found a value that is larger than min2,
                // it means that it is also larger than min1.
                return true;
            }
        }
        return false;
    }
}
