/*
Given a sorted array nums, remove the duplicates in-place such that each
element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying
the input array in-place with O(1) extra memory.
 */
public class RemoveDuplicatesFromSortedArray {
    // Two pointers. Similar to 283.
    public int removeDuplicates(int[] nums) {
        int pre = 0;
        int num = 0;
        // Start from index 1.
        for (int curr = 1; curr < nums.length; curr++) {
            // Check if the current element is larger than the element at
            // index pre (no duplicates from index 0 to pre).
            if (nums[curr] > nums[pre]) {
                int temp = nums[curr];
                nums[curr] = nums[pre + 1];
                nums[pre + 1] = temp;
                pre++;
            } else {
                // If the element at curr is not larger than the element at
                // pre, then pre stays the same, and keep increasing curr
                // until the element at curr is larger than the element at pre.
                // Then swap the element at curr with the element at pre + 1.
                num++;
            }
        }
        return nums.length - num;
    }
}
