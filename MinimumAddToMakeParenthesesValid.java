import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    ans++;
                } else {
                    stack.pop();
                }
            }
        }
        return ans + stack.size();
    }
}
