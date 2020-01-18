/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to
you beforehand.

Find the minimum element.
You may assume no duplicate exists in the array.
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return nums[start];
    }
}
/*
index: 0 1 2 3 4 5 6
       4 5 6 7 0 1 2
       5 6 7 0 1 2 4
       6 7 0 1 2 4 5
       7 0 1 2 4 5 6
       0 1 2 4 5 6 7
       1 2 4 5 6 7 0
       2 4 5 6 7 0 1
We find the mid element ((start + end) / 2), then compare it with the element
at index end. If the element at index end is larger, it means that the right
half of the array is sorted and the minimum element has to be in the left half
 of the array (including the mid element). If the element at index end is
 smaller, it means the right half of the array is not sorted and the minimum
 element has to be in the right half of the array (not including the mid
 element).
 */
