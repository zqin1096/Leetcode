import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<String>();
        for (String s : words) {
            if (pattern.length() != s.length()) {
                continue;
            }
            Map<Character, Character> map = new HashMap<Character, Character>();
            boolean flag = true;
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(pattern.charAt(i))) {
                    if (map.get(pattern.charAt(i)) != s.charAt(i)) {
                        flag = false;
                        break;
                    }
                } else {
                    if (map.containsValue(s.charAt(i))) {
                        // No two letters map to the same letter.
                        flag = false;
                        break;
                    }
                    map.put(pattern.charAt(i), s.charAt(i));
                }
            }
            if (flag) {
                result.add(s);
            }
        }
        return result;
    }
}
