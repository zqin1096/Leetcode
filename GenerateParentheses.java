import javax.swing.event.ListDataEvent;
import java.util.ArrayList;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of
well-formed parentheses.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, n, n, "");
        return result;
    }

    private void dfs(List<String> list, int left, int right, String s) {
        if (left == 0 && right == 0) {
            if (isValid(s)) {
                list.add(s);
            }
        }
        if (left > 0) {
            dfs(list, left - 1, right, s + "(");
        }
        if (right > 0) {
            dfs(list, left, right - 1, s + ")");
        }
    }

    private boolean isValid(String s) {
        int left = 0;
        int right = 0;
        for (char c : s.toCharArray()) {
            left = c == '(' ? left + 1 : left;
            right = c == ')' ? right + 1 : right;
            if (left < right) {
                return false;
            }
        }
        return left == right;
    }
}
