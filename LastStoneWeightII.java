import java.util.HashSet;
import java.util.Set;

/*
We have a collection of rocks, each rock has a positive integer weight.

Each turn, we choose any two rocks and smash them together.  Suppose the stones
have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight
y has new weight y-x.

At the end, there is at most 1 stone left.  Return the smallest possible weight
of this stone (the weight is 0 if there are no stones left.)
 */
public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        Set<Integer> set = new HashSet<>();
        set.add(-stones[0]);
        set.add(stones[0]);
        for (int i = 1; i < stones.length; i++) {
            // Store all the possible situations in set.
            Set<Integer> temp = new HashSet<>();
            for (int rock : set) {
                // This rock + some other rocks to smash other rocks.
                temp.add(rock + stones[i]);
                // This rock smash some other rocks.
                temp.add(rock - stones[i]);
            }
            set = temp;
        }
        int min = Integer.MAX_VALUE;
        for (int i : set) {
            // Take the absolute value.
            min = Math.min(Math.abs(i), min);
        }
        return min;
    }
}
