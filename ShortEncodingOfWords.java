import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShortEncodingOfWords {
    // If a word X is a suffix of Y, then X does not need to be considered.
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                // Remove its suffix if exists.
                set.remove(word.substring(i));
            }
        }
        int ans = 0;
        for (String word : set) {
            ans += word.length() + 1;
        }
        return ans;
    }
}
