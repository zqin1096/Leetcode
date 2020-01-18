import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
In the "100 game," two players take turns adding, to a running total, any
integer from 1..10. The player who first causes the running total to reach or
exceed 100 wins.

What if we change the game so that players cannot re-use integers?

For example, two players might take turns drawing from a common pool of numbers
of 1..15 without replacement until they reach a total >= 100.

Given an integer maxChoosableInteger and another integer desiredTotal,
determine if the first player to move can force a win, assuming both players
play optimally.

You can always assume that maxChoosableInteger will not be larger than 20 and
desiredTotal will not be larger than 300.
 */
public class CanIWin {
    // DFS with memorization.
    Map<String, Boolean> map = new HashMap<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0) {
            return true;
        }
        // If the sum from 1 to maxChoosableInteger is less than
        // desiredTotal, then it is impossible to win.
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) {
            return false;
        }
        boolean[] pick = new boolean[maxChoosableInteger];
        return canIWin(maxChoosableInteger, desiredTotal, pick);
    }

    private boolean canIWin(int maxChoosableInteger, int desiredTotal,
                            boolean[] pick) {
        // If the desiredTotal is 0 or less, this player lose the game.
        if (desiredTotal <= 0) {
            return false;
        }
        // Current situation.
        String encode = Arrays.toString(pick);
        if (map.containsKey(encode)) {
            return map.get(encode);
        }
        for (int i = 1; i <= maxChoosableInteger; i++) {
            if (!pick[i - 1]) {
                pick[i - 1] = true;
                if (!canIWin(maxChoosableInteger, desiredTotal - i, pick)) {
                    map.put(encode, true);
                    // Remember to mark it as un-picked before return.
                    pick[i - 1] = false;
                    return true;
                }
                pick[i - 1] = false;
            }
        }
        map.put(encode, false);
        return false;
    }
}
