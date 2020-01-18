import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (frequencies.containsKey(c)) {
                frequencies.put(c, frequencies.get(c) + 1);
            } else {
                frequencies.put(c, 1);
            }
        }
        // Number of unique characters.
        int counter = frequencies.size();
        int start = 0;
        int end = 0;
        int length = Integer.MAX_VALUE;
        String ans = "";
        while (end < s.length()) {
            char c = s.charAt(end);
            if (frequencies.containsKey(c)) {
                frequencies.put(c, frequencies.get(c) - 1);
                // Decrement the counter by 1 if the number of one of the
                // characters reaches zero.
                if (frequencies.get(c) == 0) {
                    counter--;
                }
            }
            // Increment end.
            end++;
            // If counter equals 0, a valid answer is produced.
            while (counter == 0) {
                if (end - start < length) {
                    length = end - start;
                    ans = s.substring(start, end);
                }

                // Try to trim the answer down bt removing the unessential
                // characters from the start.
                if (frequencies.containsKey(s.charAt(start))) {
                    // Check if the character at the start position is in the
                    // string t.
                    frequencies.put(s.charAt(start),
                            frequencies.get(s.charAt(start)) + 1);
                    if (frequencies.get(s.charAt(start)) > 0) {
                        counter++;
                    }
                }
                start++;
            }
        }
        return ans;
    }
}
