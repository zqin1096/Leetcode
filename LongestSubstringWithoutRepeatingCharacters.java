import java.util.HashSet;
import java.util.Set;

/*
Given a string, find the length of the longest substring without repeating
characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    // Sliding window.
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int max = 1;
        Set<Character> set = new HashSet<>();
        while (end < s.length()) {
            char c = s.charAt(end);
            if (!set.contains(c)) {
                set.add(c);
                end++;
            } else {
                while (s.charAt(start) != c) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
                end++;
            }
            max = Math.max(max, end - start);
        }
        return max;
    }
}
