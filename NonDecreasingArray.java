/*
Given an array with n integers, your task is to check if it could become
non-decreasing by modifying at most 1 element.
 */
public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
                // If the element at i - 2 is larger than the element at i,
                // then make the element at i larger.
                if (i >= 2 && nums[i - 2] > nums[i]) {
                    nums[i] = nums[i - 1];
                } else {
                    // Make the previous element smaller since it is safer.
                    nums[i - 1] = nums[i];
                }
            }
        }
        return count <= 1;
    }
}
