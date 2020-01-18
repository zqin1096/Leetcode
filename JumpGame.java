/*
Given an array of non-negative integers, you are initially positioned at the
first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        // Need to get to this position.
        int destination = nums.length - 1;
        // Current largest index that we can jump to.
        int maxJump = nums[0];
        // Keep going until we cannot jump further.
        for (int i = 0; i <= maxJump; i++) {
            // At the index (position) i, we can go to i + nums[i]. If i +
            // nums[i] is larger than maxJump, update maxJump.
            maxJump = Math.max(maxJump, i + nums[i]);
            if (maxJump >= destination) {
                return true;
            }
        }
        return false;
    }
}
