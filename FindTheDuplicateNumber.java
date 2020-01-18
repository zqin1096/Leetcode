/*
Given an array nums containing n + 1 integers where each integer is between 1
and n (inclusive), prove that at least one duplicate number must exist. Assume
that there is only one duplicate number, find the duplicate one.

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n^2).
There is only one duplicate number in the array, but it could be repeated more
than once.
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        // lowest number (value instead of index).
        int low = 1;
        // highest number.
        int high = nums.length - 1;
        while (low <= high) {
            // Mid value.
            int count = 0;
            int mid = low + (high - low) / 2;
            // Scan the entire array and count the number of elements that
            // are lower than or equal to mid.
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            // (If there is no duplicate, the number of elements that are
            // lower or equal to mid is mid).
            // [1, 2, 3]: 2 == 2 (count == mid).
            // [1, 2, 3, 4]: 2 == 2.
            if (count <= mid) {
                // It means that there more elements are higher values
                // (the duplicate number is larger than mid).
                low = mid + 1;
            } else {
                // It means the more elements are lower values.
                high = mid - 1;
            }
        }
        return low;
    }
}
