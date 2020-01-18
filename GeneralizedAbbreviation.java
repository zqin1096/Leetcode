import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {
    // Important idea: use count to keep track of the number of characters
    // that will be abbreviated, instead of actually abbreviating the
    // characters in each dfs() call.
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        dfs(result, word, "", 0, 0);
        return result;
    }

    // count represents the number of letters that will be abbreviated.
    private void dfs(List<String> result, String word, String s, int pos,
                     int count) {
        if (pos == word.length()) {
            // Append the count if it is more than 0, meaning some letters are
            // abbreviated but the the count has not appended.
            if (count > 0) {
                s = s + count;
            }
            result.add(s);
            return;
        }
        // Abbreviate the current letter.
        // s stays the same. Increment both pos and count.
        dfs(result, word, s, pos + 1, count + 1);

        // Keep the current letter.
        // Append the count before appending the current letter, in case some
        // letters before are abbreviated.
        if (count > 0) {
            s += count;
        }
        s += word.charAt(pos);
        // count is 0.
        dfs(result, word, s, pos + 1, 0);
    }
}
