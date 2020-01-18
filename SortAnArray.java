import java.util.Arrays;

public class SortAnArray {
//    public int[] sortArray(int[] nums) {
//        // Insertion sort.
//        // One element from the input elements is consumed in each iteration
//        // to find its correct position.
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] > nums[i - 1]) {
//                continue;
//            }
//            for (int j = 0; j < i; j++) {
//                if (nums[i] < nums[j]) {
//                    swap(nums, i, j);
//                }
//            }
//        }
//        return nums;
//    }

//    public int[] sortArray(int[] nums) {
//        // Selection sort.
//        // The selection sort algorithm sorts an array by repeatedly finding
//        // the minimum element from unsorted part and putting it at the
//        // beginning.
//        for (int i = 0; i < nums.length; i++) {
//            int min = i;
//            for (int j = i; j < nums.length; j++) {
//                if (nums[j] < nums[min]) {
//                    min = j;
//                }
//            }
//            swap(nums, i, min);
//        }
//        return nums;
//    }

    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
