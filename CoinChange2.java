/*
You are given coins of different denominations and a total amount of money.
Write a function to compute the number of combinations that make up that amount.
You may assume that you have infinite number of each kind of coin.
 */
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int combinations = 0;
        int[] dp = new int[amount + 1];
        // If the amount is 0, the number of ways to make up 0 is 1 (no coin).
        dp[0] = 1;
        // The amount is the inner loop to avoid duplicate combinations.
        // Calculate the number of combinations for each amount in the inner
        // loop first. Then update as we have new coins. In this way,
        // duplicate combinations will not be counted.
        for (int i = 0; i < coins.length; i++) {
            // For amount j, if there is coins[i] now, find the number of
            // combinations.
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}
