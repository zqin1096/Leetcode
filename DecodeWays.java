import java.util.HashMap;
import java.util.Map;

/*
A message containing letters from A-Z is being encoded to numbers using the
following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given a non-empty string containing only digits, determine the total number of
ways to decode it.
 */
public class DecodeWays {
    // DFS with memorization.
    Map<String, Integer> map = new HashMap<>();

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        return decode(s);
    }

    private int decode(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return 1;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        int count = 0;
        // Decode a single digit and that single digit cannot be 0.
        if (s.charAt(s.length() - 1) > '0') {
            count += decode(s.substring(0, s.length() - 1));
        }
        // Decode 2 digits. The range is 11 ~ 26.
        if ((s.charAt(s.length() - 2) > '0' && s.charAt(s.length() - 2) < '2')
                || (s.charAt(s.length() - 2) == '2'
                && s.charAt(s.length() - 1) < '7')) {
            count += decode(s.substring(0, s.length() - 2));
        }
        map.put(s, count);
        return count;
    }
}
