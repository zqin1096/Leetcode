import java.util.HashSet;
import java.util.Set;

/*
From any string, we can form a subsequence of that string by deleting some
number of characters (possibly no deletions).

Given two strings source and target, return the minimum number of subsequences
of source such that their concatenation equals target. If the task is
impossible, return -1.
 */
public class ShortestWayToFormString {
    public int shortestWay(String source, String target) {
        Set<Character> set = new HashSet<>();
        for (char c : source.toCharArray()) {
            set.add(c);
        }
        int count = 0;
        int i = 0;
        while (i < target.length()) {
            // Use source again and again to match the character of target.
            for (int j = 0; j < source.length(); j++) {
                // If all the characters of target are consumed, break.
                if (i >= target.length()) {
                    break;
                }
                // If target contains a character that does not in source,
                // return -1.
                if (!set.contains(target.charAt(i))) {
                    return -1;
                }
                // If the current character of source matches the current
                // character of target, increment i.
                if (source.charAt(j) == target.charAt(i)) {
                    i++;
                }
            }
            count++;
        }
        return count;
    }
}
