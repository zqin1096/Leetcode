import java.util.Arrays;

/*
Implement next permutation, which rearranges numbers into the lexicographically
next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest
possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.
 */
public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int index = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            // From index i + 1 to the end of nums the values are in
            // decreasing order.
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            Arrays.sort(nums);
            return;
        }
        // Find the index of the value that is next greater than the value at
        // index i.
        int j = index + 1;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] > nums[index]) {
                j = i;
            } else {
                break;
            }
        }
        // Swap the value at index index and j.
        int temp = nums[index];
        nums[index] = nums[j];
        nums[j] = temp;
        // Sort the rest of the array.
        Arrays.sort(nums, index + 1, nums.length);
    }
}
