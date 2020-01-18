import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number
on it represented by array nums. You are asked to burst all the balloons. If
the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
Here left and right are adjacent indices of i. After the burst, the left and
right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.
 */
public class BurstBalloons {
    // DFS. TLE.
//    public int maxCoins(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        List<Integer> list = new LinkedList<>();
//        for (int i : nums) {
//            list.add(i);
//        }
//        list.add(0, 1);
//        list.add(list.size(), 1);
//        return dfs(list);
//    }
//
//    private int dfs(List<Integer> nums) {
//        if (nums.size() == 0) {
//            return 0;
//        }
//        int max = 0;
//        for (int i = 1; i < nums.size() - 1; i++) {
//            int num = nums.get(i);
//            int coins = nums.get(i - 1) * nums.get(i) * nums.get(i + 1);
//            nums.remove(i);
//            max = Math.max(max, coins + dfs(nums));
//            nums.add(i, num);
//        }
//        return max;
//    }

    // DFS with memorization.
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        // maxCoins[i][j] represents the maximum coins that can be collected
        // by bursting all the balloons from arr(i, j) (excluding the balloons
        // at index i and j.
        int[][] maxCoins = new int[n][n];
        int[] arr = new int[n];
        // Pre-processing the array. Add 1 at the front and the end of the nums.
        for (int i = 1; i < n - 1; i++) {
            arr[i] = nums[i - 1];
        }
        arr[0] = 1;
        arr[n - 1] = 1;
        return maxCoins(arr, maxCoins, 0, n - 1);
    }

    private int maxCoins(int[] nums, int[][] maxCoins, int left, int right) {
        if (maxCoins[left][right] != 0) {
            return maxCoins[left][right];
        }
        int max = 0;
        // Pick the balloon from left + 1 to right - 1.
        for (int i = left + 1; i <= right - 1; i++) {
            // The balloon at index i is the last balloon to be burst.
            int coins = nums[i] * nums[left] * nums[right] + maxCoins(nums,
                    maxCoins, left, i) + maxCoins(nums, maxCoins, i, right);
            max = Math.max(max, coins);
        }
        maxCoins[left][right] = max;
        // When there is no balloon to be burst, return 0 (loop is not entered).
        return max;
    }

    /*
    Left        Burst           Right
    2   3   4   5   6   7   8   9

    Try to collect maximum number of coins by bursting the balloons between 2
     and 9 (excluding 2 and 9). If 5 is the last balloon to be burst, it means
     that 3, 4, 6, 7, 8 have already been burst. The max coins = 2 * 9 * 5 +
     maxCoins[2][5] + maxCoins[5][9]. maxCoins[2][5] and maxCoins[5][9] are
     sub-problems, which have been calculated so we can use it directly.

     It is really important to think 5 (or any other balloons between 2 and
     9) is the last balloon to be burst.
     */
}