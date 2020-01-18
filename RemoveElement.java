/*
Given an array nums and a value val, remove all instances of that value
in-place and return the new length.

Do not allocate extra space for another array, you must do this by modifying
the input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond
the new length.


 */
public class RemoveElement {
    // Similar to 283.
    public int removeElement(int[] nums, int val) {
        int indexOfVal = 0;
        int num = 0;
        // We swap the position of val and non-val elements. If val is not
        // found, we just swap the element with itself, which does not change
        // the array.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                int temp = nums[i];
                nums[indexOfVal] = nums[i];
                nums[i] = temp;
                indexOfVal++;
            } else {
                num++;
            }
            // If the nums[i] == val, indexOfVal stays unchanged. It means we
            // found the index of val, and we want to swap it with a non-val
            // element.
        }
        return nums.length - num;
    }
}
