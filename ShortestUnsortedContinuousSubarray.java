import java.util.Arrays;

/*
Given an integer array, you need to find one continuous subarray that if you
only sort this subarray in ascending order, then the whole array will be sorted
in ascending order, too.

You need to find the shortest such subarray and output its length.
 */
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        // Check from both ends.
        int start = -1;
        int end = -2;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // If nums[i] is less than max, then it has to be sorted.
            if (nums[i] < max) {
                end = i;
            }
            // Update max every iteration.
            max = Math.max(max, nums[i]);
        }

        int min = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > min) {
                start = i;
            }
            // There is possibly a very small value near the end of the array.
            min = Math.min(min, nums[i]);
        }
        return end - start + 1;
    }
}
