import java.util.Map;

public class ShortestDistanceToACharacter {
    // Find the shortest distance to C from left and the shortest distance to C from right.
    public int[] shortestToChar(String S, char C) {
        int length = S.length();
        int[] ans = new int[length];
        int position = -length;
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == C) {
                position = i;
            }
            ans[i] = i - position;
        }
        for (int i = length - 1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                position = i;
            }
            ans[i] = Math.min(ans[i], Math.abs(i - position));
        }
        return ans;
    }
}
