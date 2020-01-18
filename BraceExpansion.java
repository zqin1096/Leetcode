import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
A string S represents a list of words.

Each letter in the word has 1 or more options.  If there is one option, the
letter is represented as is.  If there is more than one option, then curly
braces delimit the options.  For example, "{a,b,c}" represents options
["a", "b", "c"].

For example, "{a,b,c}d{e,f}" represents the list
["ade", "adf", "bde", "bdf", "cde", "cdf"].

Return all words that can be formed in this manner, in lexicographical order.
 */
public class BraceExpansion {
    // DFS.
    public String[] expand(String S) {
        List<List<Character>> options = new ArrayList<>();
        List<Character> list = null;
        for (char c : S.toCharArray()) {
            if (c == '{') {
                list = new ArrayList<>();
                options.add(list);
            } else if (c == '}') {
                Collections.sort(list);
                list = null;
            } else if (c == ',') {
                continue;
            } else {
                if (list == null) {
                    List<Character> option = new ArrayList<>();
                    option.add(c);
                    options.add(option);
                } else {
                    list.add(c);
                }
            }
        }
        List<String> result = new ArrayList<>();
        dfs(result, options, 0, "");
        String[] res = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    private void dfs(List<String> result, List<List<Character>> options,
                     int index, String s) {
        if (index == options.size()) {
            result.add(s);
            return;
        }
        for (int i = 0; i < options.get(index).size(); i++) {
            dfs(result, options, index + 1, s + options.get(index).get(i));
        }
    }
}
