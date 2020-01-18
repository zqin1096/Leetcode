import java.util.HashMap;
import java.util.Map;

/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter
in pattern and a non-empty word in str.

You may assume pattern contains only lowercase letters, and str contains
lowercase letters that may be separated by a single space.

 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] tokens = str.split(" ");
        if (pattern.length() != tokens.length) {
            return false;
        }
        Map<Character, String> map1 = new HashMap<>();
        // Map has containsValue() method.
        Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map1.containsKey(c)) {
                if (!map1.get(c).equals(tokens[i])) {
                    return false;
                }
                if (map2.containsKey(tokens[i]) && map2.get(tokens[i]) != c) {
                    return false;
                }
            } else {
                if (map2.containsKey(tokens[i]) && map2.get(tokens[i]) != c) {
                    return false;
                }
                map1.put(c, tokens[i]);
                map2.put(tokens[i], c);
            }
        }
        return true;
    }
}
