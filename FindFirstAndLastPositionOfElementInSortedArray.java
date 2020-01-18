/*
Given an array of integers nums sorted in ascending order, find the starting
and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    // Binary search.
    int[] res = new int[2];

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        res[0] = -1;
        res[1] = -1;
        searchRange(nums, target, left, right);
        return res;
    }

    private void searchRange(int[] nums, int target, int left, int right) {
        if (left > right) {
            return;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            // If the element that is left to the nums[mid] is not target, it
            // means that mid is the starting position of the given target
            // value.
            if (mid == 0 || nums[mid - 1] != target) {
                res[0] = mid;
            } else {
                searchRange(nums, target, left, mid - 1);
            }
            if (mid == nums.length - 1 || nums[mid + 1] != target) {
                res[1] = mid;
            } else {
                searchRange(nums, target, mid + 1, right);
            }

        } else if (nums[mid] > target) {
            right = mid - 1;
            searchRange(nums, target, left, right);
        } else {
            left = mid + 1;
            searchRange(nums, target, left, right);
        }
    }
}
