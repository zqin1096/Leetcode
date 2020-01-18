/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to
you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index,
otherwise return -1.

You may assume no duplicate exists in the array.


 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[right]) {
                // The right half is sorted.
                if (nums[mid] < target && target <= nums[right]) {
                    // Check if target is in the sorted half of the array.
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
/*
[0,1,2,4,5,6,7]
[7,0,1,2,4,5,6]
[6,7,0,1,2,4,5]
[5,6,7,0,1,2,4]
[4,5,6,7,0,1,2]
[2,4,5,6,7,0,1]
[1,2,4,5,6,7,0]
Since we want to use binary search, we need to determine which half of the
array (left/right) to search after we get the mid element. We can see from
the above examples that if the mid element is smaller than the last element,
then the right half of the array is sorted (including the mid element). If
the mid element is larger than the last element, then the left half of the
array is sorted (including the mid element).

After we know which half of the array is sorted, we know the smallest and the
 biggest element of that half of the array, and we can use this information
 to determine whether the target element is in this (sorted) half of the array.

 We can also compare nums[mid] with nums[left]: if nums[mid] > nums[left],
 the left half of the array is sorted. But there is a little complication:
 mid is computed by (left + right) / 2, so there is a chance that left ==
 mid, and in turn nums[left] == nums[mid]. So we need to modify the if
 statement to: if nums[mid] >= nums[left].

 e.g: [3, 1], target = 1.
 left = 0, right = 1, mid = 0.
 nums[mid] = nums[left] = 3 != target.
 In this situation, we want to let the algorithm to search the right half of
 the array (since nums[mid] == nums[left], and we know there is no duplicate
 numbers, so the target is in the right half of the array).
 */
