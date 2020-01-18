import java.util.HashMap;
import java.util.Map;

/*
Given a string s , find the length of the longest substring t  that contains at
most 2 distinct characters.
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // Store the characters and their corresponding frequencies.
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        int end = 0;
        int num = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (!map.containsKey(c)) {
                if (num == 2) {
                    max = Math.max(max, end - start);
                    // We keep decreasing the frequency of the character at
                    // index start until the the number of distinct
                    // characters is 1.
                    while (num == 2) {
                        char remove = s.charAt(start);
                        map.put(remove, map.get(remove) - 1);
                        if (map.get(remove) == 0) {
                            num--;
                            map.remove(remove);
                        }
                        start++;
                    }
                } else {
                    map.put(c, 1);
                    num++;
                    end++;
                }
            } else {
                map.put(c, map.get(c) + 1);
                end++;
            }
        }
        max = Math.max(max, end - start);
        return max;
    }
}
