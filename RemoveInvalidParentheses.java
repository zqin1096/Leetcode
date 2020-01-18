import java.util.LinkedList;
import java.util.List;

/*
Remove the minimum number of invalid parentheses in order to make the input
string valid. Return all possible results.

The input string may contain letters other than the parentheses ( and ).
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new LinkedList<>();
        // Compute the minimum number of ( and ) to remove.
        int l = 0, r = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                l++;
            } else if (ch[i] == ')') {
                // If l is larger than 0, then one pair of ( and ) can be
                // cancelled out.
                if (l > 0) {
                    l--;
                } else {
                    r++;
                }
            } else {
                continue;
            }
        }
        dfs(result, l, r, 0, s);
        return result;
    }

    // Check if the resulting string is valid (since we are going to check all
    // possible strings).
    private boolean isValid(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') ++count;
            if (ch == ')') --count;
            if (count < 0) return false;
        }
        return count == 0;
    }

    // Search the strings.
    private void dfs(List<String> result, int l, int r, int index,
                     String s) {
        if (l == 0 && r == 0 && isValid(s)) {
            result.add(s);
            return;
        }
        char[] ch = s.toCharArray();
        for (int i = index; i < ch.length; i++) {
            // Avoid duplicates.
            // index represents the starting search index for current s.
            // ((): remove the first or second '(' will give the same result.
            if (i != index && ch[i] == ch[i - 1]) {
                continue;
            }
            if (ch[i] == '(' || ch[i] == ')') {
                if (r > 0 && ch[i] == ')') {
                    dfs(result, l, r - 1, i,
                            new StringBuilder(s).deleteCharAt(i).toString());
                } else if (l > 0 && ch[i] == '(') {
                    dfs(result, l - 1, r, i,
                            new StringBuilder(s).deleteCharAt(i).toString());
                }
            }
        }
    }
}
