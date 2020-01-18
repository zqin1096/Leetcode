/*
Given a sorted array A of unique numbers, find the K-th missing number starting
from the leftmost number of the array.
 */
public class MissingElementInSortedArray {
    public int missingElement(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        // Check if the missing number is beyond high.
        if (nums[high] - nums[low] + 1 - nums.length < k) {
            return nums[high] + k - (nums[high] - nums[low] + 1 - nums.length);
        }
        // Now the missing number has to be in [low, high].
        // low need to smaller than high - 1.
        // (0 + 1) / 2 = 0.
        while (low < high - 1) {
            int mid = (low + high) / 2;
            int num = nums[mid] - nums[low] + 1;
            int actual = mid - low + 1;
            // If the number of missing numbers is larger than or equal to k,
            // then the k-th missing number has to be in the first half of
            // the array.
            if (num - actual >= k) {
                high = mid;
            } else {
                low = mid;
                k -= (num - actual);
            }
        }
        return nums[low] + k;
    }
}
