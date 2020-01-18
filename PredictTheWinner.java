/*
Given an array of scores that are non-negative integers. Player 1 picks one of
the numbers from either end of the array followed by the player 2 and then
player 1 and so on. Each time a player picks a number, that number will not be
available for the next player. This continues until all the scores have been
chosen. The player with the maximum score wins.

Given an array of scores, predict whether player 1 is the winner. You can
assume each player plays to maximize his score.
 */
public class PredictTheWinner {
    // Minimax.
//    public boolean PredictTheWinner(int[] nums) {
//        return score(nums, 0, nums.length - 1) >= 0;
//    }
//
//    private int score(int[] nums, int i, int j) {
//        if (i > j) {
//            return 0;
//        }
//        // Return the max difference between 2 players.
//        // Check all possible situation.
//        // Player 1 choose a number from either ends. Then player 2 choose a
//        // number from either ends of the remaining numbers, and so on.
//        return Math.max(nums[i] - score(nums, i + 1, j), nums[j] - score(nums
//                , i, j - 1));
//    }

    // DFS.
    public boolean PredictTheWinner(int[] nums) {
        return canWin(nums, 0, nums.length - 1, 0, 0, true);
    }

    private boolean canWin(int[] nums, int i, int j, int sum1, int sum2,
                           boolean player1) {
        if (i == j) {
            if (player1) {
                // If the score of player1 is more than or equal to the score
                // of player2, then player1 wins.
                return sum1 + nums[i] >= sum2;
            } else {
                // Player2 has to have more scores to win.
                return sum2 + nums[i] > sum1;
            }
        }
        if (player1) {
            // If the opponent cannot win in both situations (the current
            // player chooses the number from either ends), then the current
            // player wins.
            if (!canWin(nums, i + 1, j, sum1 + nums[i], sum2, !player1) || !canWin(nums, i, j + 1, sum1 + nums[j], sum2, !player1)) {
                return true;
            } else {
                return false;
            }
        } else {
            if (!canWin(nums, i + 1, j, sum1, sum2 + nums[i], !player1) || !canWin(nums, i, j + 1, sum1, sum2 + nums[j], !player1)) {
                return true;
            } else {
                return false;
            }
        }
    }
}
