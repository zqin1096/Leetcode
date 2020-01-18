import java.util.HashMap;
import java.util.Map;

/*
Given several boxes with different colors represented by different positive
numbers.

You may experience several rounds to remove boxes until there is no box left.
Each time you can choose some continuous boxes with the same color (composed of
k boxes, k >= 1), remove them and get k*k points.

Find the maximum points you can get.

 */
public class RemoveBoxes {
    // Leetcode most votes post.
    // DFS with memorization. Only works on numbers that only have 1 digit.

//    Map<String, Integer> map = new HashMap<>();
//
//    public int removeBoxes(int[] boxes) {
//        StringBuilder sb = new StringBuilder();
//        for (int i : boxes) {
//            sb.append(i);
//        }
//        String s = sb.toString();
//        // Initially, there is no box behind the last box.
//        return dfs(s, 0);
//    }
//
//    // k represents the number of boxes that are right to the box at the last
//    // index and have the same color with the box at the last index (of
//    // current s).
//    private int dfs(String s, int k) {
//        if (s.length() == 0) {
//            return 0;
//        }
//        String encode = s + " " + k;
//        if (map.containsKey(encode)) {
//            return map.get(encode);
//        }
//        // We can remove the last k + 1 boxes that have the same color
//        // (remove the last character of s, the last box of current s has k
//        // boxes with the same color behind it) .
//        int max = dfs(s.substring(0, s.length() - 1), 0) + (k + 1) * (k + 1);
//        // We can also keep the boxes that have the same color, remove other
//        // boxes before them, and look for the boxes that have the same color
//        // so we can get more points by removing them together.
//        for (int i = s.length() - 2; i >= 0; i--) {
//            if (s.charAt(i) == s.charAt(s.length() - 1)) {
//                max = Math.max(max, dfs(s.substring(0, i + 1), k + 1) +
//                        dfs(s.substring(i + 1, s.length() - 1), 0));
//            }
//        }
//        map.put(encode, max);
//        return max;
//    }

    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        // dp[i][j][k] represents the maximum points that we can get when there
        // is k boxes behind boxes[i...j].
        int[][][] dp = new int[n][n][n];
        return removeBoxes(boxes, dp, 0, n - 1, 0);
    }

    private int removeBoxes(int[] boxes, int[][][] dp, int i, int j, int k) {
        // No box, no point.
        if (i > j) {
            return 0;
        }
        if (dp[i][j][k] != 0) {
            return dp[i][j][k];
        }
        // A little different from the String approach: we cannot assume i is
        // always 0.
        int max = removeBoxes(boxes, dp, i, j - 1, 0) + (k + 1) * (k + 1);
        for (int a = j - 1; a >= i; a--) {
            if (boxes[a] == boxes[j]) {
                max = Math.max(max,
                        removeBoxes(boxes, dp, i, a, k + 1) + removeBoxes(boxes, dp, a + 1, j - 1, 0));
            }
        }
        dp[i][j][k] = max;
        return max;
    }
}
/*
ABACA: each letter represents different color.
1: we can remove the last A first. There is no other A behind it, so we can
get 1 * 1 = 1 point. Then we recursively calculate the maximum points we can
get for ABAC.
2: we can keep the last A to make it next to its previous A so that we can
get more points by removing continuous A together. In order to do that, we
need to remove C. It means the max(ABACA) = max(ABA|A) + max(C). ABA|A
represents that C is now removed and there is an A behind ABA.
3: Keep finding the A before the last A. We need to search max(ABACA) = max
(A|A) + max(BAC). It means we remove the substring BAC first, and we remove
the first A and the last A together.
 */
