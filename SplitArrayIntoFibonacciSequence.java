import java.util.ArrayList;
import java.util.List;

public class SplitArrayIntoFibonacciSequence {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans = new ArrayList<>();
        helper(S, ans, 0);
        return ans;
    }

    public boolean helper(String s, List<Integer> ans, int idx) {
        if (idx == s.length() && ans.size() >= 3) {
            return true;
        }
        // i is the starting index.
        for (int i = idx; i < s.length(); i++) {
            // Each piece must not have extra leading zeros, except if the piece is the number 0 itself.
            if (s.charAt(idx) == '0' && i > idx) {
                break;
            }
            // Check if it fits a 32-bit signed integer type.
            long num = Long.parseLong(s.substring(idx, i + 1));
            if (num > Integer.MAX_VALUE) {
                break;
            }
            int size = ans.size();
            if (size >= 2 && num != ans.get(size - 1) + ans.get(size - 2)) {
                continue;
            }
            if (size <= 1 || num == ans.get(size - 1) + ans.get(size - 2)) {
                ans.add((int) num);
                // Branch pruning. If one branch has found fib seq, return true to the upper call.
                if (helper(s, ans, i + 1)) {
                    return true;
                }
                ans.remove(ans.size() - 1);
            }
        }
        return false;
    }
}
