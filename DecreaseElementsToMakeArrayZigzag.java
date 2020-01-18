import java.util.Arrays;

public class DecreaseElementsToMakeArrayZigzag {
    public int movesToMakeZigzag(int[] nums) {
        int move1 = 0;
        int move2 = 0;
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }
        for (int i = 0; i < nums.length; i += 2) {
            if (i - 1 >= 0 && nums[i] <= nums[i - 1]) {
                int move = Math.abs(nums[i] - nums[i - 1]) + 1;
                move1 += move;
                nums[i - 1] -= move;
            }
            if (i + 1 < nums.length && nums[i] <= nums[i + 1]) {
                int move = Math.abs(nums[i] - nums[i + 1]) + 1;
                move1 += move;
                nums[i + 1] -= move;
            }
        }
        nums = copy;
        for (int i = 1; i < nums.length; i += 2) {
            if (i - 1 >= 0 && nums[i] <= nums[i - 1]) {
                int move = Math.abs(nums[i] - nums[i - 1]) + 1;
                move2 += move;
                nums[i - 1] -= move;
            }
            if (i + 1 < nums.length && nums[i] <= nums[i + 1]) {
                int move = Math.abs(nums[i] - nums[i + 1]) + 1;
                move2 += move;
                nums[i + 1] -= move;
            }
        }
        return Math.min(move1, move2);
    }
}
