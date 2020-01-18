import java.util.Arrays;

/*
You are given coins of different denominations and a total amount of money
amount. Write a function to compute the fewest number of coins that you need to
make up that amount. If that amount of money cannot be made up by any
combination of the coins, return -1.
 */
public class CoinChange {
//    public static int coinChange(int[] coins, int amount) {
//        if (amount < 1) {
//            return 0;
//        }
//        return numOfCoins(amount, coins);
//    }
//
//    private static int numOfCoins(int remaining, int[] coins) {
//        if (remaining < 0) {
//            return -1;
//        }
//        if (remaining == 0) {
//            return 0;
//        }
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < coins.length; i++) {
//            // Take one coin c, and calculate the number of least coins that
//            // can make up amount (remaining - c).
//            int rv = numOfCoins(remaining - coins[i], coins);
//            if (rv >= 0) {
//                min = Math.min(min, 1 + rv);
//            }
//        }
//        return min == Integer.MAX_VALUE ? -1 : min;
//    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        // The number of coins to make up 0 amount is 0.
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        // For each amount, try all possible coins.
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
