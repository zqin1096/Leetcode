import java.util.Arrays;

/*
You are a professional robber planning to rob houses along a street. Each house
has a certain amount of money stashed. All houses at this place are arranged in
a circle. That means the first house is the neighbor of the last one. Meanwhile,
adjacent houses have security system connected and it will automatically
contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each
house, determine the maximum amount of money you can rob tonight without
alerting the police.
 */
public class HouseRobberII {
    // Break it into 2 sub-problems.
    // 1 -> n - 1 or 2 -> n.
    // If the first house is robbed, the last house cannot be robbed, the
    // problem becomes how to rob house [1, n - 1]. If the first house is not
    // robbed, then the problem becomes how to rob house [2, n].
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(helper(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                helper(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int helper(int[] nums) {
        int[] dp = new int[nums.length + 2];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 2] + dp[i - 2]);
        }
        return dp[dp.length - 1];
    }
}
