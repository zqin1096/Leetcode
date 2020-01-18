/*
Given a sorted array nums, remove the duplicates in-place such that duplicates
appeared at most twice and return the new length.

Do not allocate extra space for another array, you must do this by modifying
the input array in-place with O(1) extra memory.

 */
public class RemoveDuplicatesFromSortedArrayII {
    // Two pointers. A little more complicated than 26.
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // curr represents the index to swap to (the array from index 0 ~ curr
        // - 1 is done).
        int curr = 0;
        int num = nums[0];
        int count = 0;
        int remove = 0;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == num) {
                // An element can appear at most twice.
                if (count < 2) {
                    // Swap the element at index i with the element at index
                    // curr (数组从index 0 到 index curr - 1是处理好的).
                    int temp = nums[i];
                    nums[i] = nums[curr];
                    nums[curr] = temp;
                    curr++;
                    count++;
                } else {
                    // If the count >= 2, the curr stays the same. So we can
                    // swap the element at index curr (to get rid of the
                    // element at index curr) with a new element at index i.
                    remove++;
                }
                i++;
            } else {
                int temp = nums[i];
                nums[i] = nums[curr];
                nums[curr] = temp;
                num = nums[curr];
                count = 1;
                curr++;
                i++;
            }
        }
        return nums.length - remove;
    }
}
