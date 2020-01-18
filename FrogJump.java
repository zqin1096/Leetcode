import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
A frog is crossing a river. The river is divided into x units and at each unit
there may or may not exist a stone. The frog can jump on a stone, but it must
not jump into the water.

Given a list of stones' positions (in units) in sorted ascending order,
determine if the frog is able to cross the river by landing on the last stone.
Initially, the frog is on the first stone and assume the first jump must be 1
unit.

If the frog's last jump was k units, then its next jump must be either k - 1,
k, or k + 1 units. Note that the frog can only jump in the forward direction.
 */
public class FrogJump {
    // DFS. TLE.
//    public boolean canCross(int[] stones) {
//        Set<Integer> set = new HashSet<>();
//        for (int i : stones) {
//            set.add(i);
//        }
//        return dfs(stones[stones.length - 1], 0, set, 0);
//    }
//
//    // jump: number of units to jump.
//    private boolean dfs(int last, int curr, Set<Integer> stones, int jump) {
//        if (curr > last) {
//            return false;
//        }
//        if (curr == last) {
//            return true;
//        }
//        for (int i = -1; i <= 1; i++) {
//            int distance = jump + i;
//            if (distance > 0 && stones.contains(curr + distance)) {
//                if (dfs(last, curr + distance, stones, distance)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    // If the current stone can be reached by multiple paths, we should use
    // dynamic programming/DFS with memorization. We do not need another path
    // to this stone if we already have a path to this stone.

    // DFS with memorization. Same technique with Word Break II.
    public boolean canCross(int[] stones) {
        Set<Integer> set = new HashSet<>();
        for (int i : stones) {
            set.add(i);
        }
        Map<String, Boolean> map = new HashMap<>();
        return dfs(stones[stones.length - 1], 0, set, 0, map);
    }

    // jump: number of units to jump.
    private boolean dfs(int last, int curr, Set<Integer> stones, int jump,
                        Map<String, Boolean> map) {
        // Current stone position and the jump distance forms a pair.
        String encode = curr + " " + jump;
        // If this stone position with this jump distance has been examined,
        // then there is no need to examine it again. There may be several
        // way to reach this stone and has the same jump distance since the
        // frog can jump k - 1, k, or k + 1 at a stone.
        if (map.containsKey(encode)) {
            return map.get(encode);
        }
        if (curr > last) {
            return false;
        }
        if (curr == last) {
            return true;
        }
        for (int i = -1; i <= 1; i++) {
            int distance = jump + i;
            if (distance > 0 && stones.contains(curr + distance)) {
                if (dfs(last, curr + distance, stones, distance, map)) {
                    // This stone position & jump distance can reach
                    // destination.
                    map.put(encode, true);
                    return true;
                }
            }
        }
        map.put(encode, false);
        return false;
    }
}
