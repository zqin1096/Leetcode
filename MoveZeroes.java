/*
Given an array nums, write a function to move all 0's to the end of it while
maintaining the relative order of the non-zero elements.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int indexOfZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[indexOfZero];
                nums[indexOfZero] = temp;
                indexOfZero++;
            }
            // If nums[i] == 0, indexOfZero stays unchanged. Once we found an
            // element that is not zero, we swap that element with the zero
            // at index indexOfZero.
        }
    }
}
