import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary {
    public String longestWord(String[] words) {
        // Brutal force.
        Set<String> set = new HashSet<>();
        for (String s : words) {
            set.add(s);
        }
        String ans = "";
        boolean flag = false;
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            for (int j = 1; j <= s.length(); j++) {
                if (!set.contains(s.substring(0, j))) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }
            if (flag) {
                if (s.length() > ans.length()) {
                    ans = s;
                }
                if (s.length() == ans.length()) {
                    if (s.compareTo(ans) < 0) {
                        ans = s;
                    }
                }
            }
        }
        return ans;
    }
}
