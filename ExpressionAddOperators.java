import java.util.ArrayList;
import java.util.List;

/*
Given a string that contains only digits 0-9 and a target value, return all
possibilities to add binary operators (not unary) +, -, or * between the digits
so they evaluate to the target value.
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        dfs(result, target, 0, 0, 0, "", num);
        return result;
    }

    // currVal: value of current expression.
    // preNum: previous number (including the sign).
    private void dfs(List<String> result, int target, long currVal, int index,
                     long preNum, String exp, String num) {
        if (index >= num.length() && target == currVal) {
            result.add(exp);
            return;
        }
        for (int i = 1; i <= num.length() - index; i++) {
            String s = num.substring(index, index + i);
            if (s.length() != 1 && s.charAt(0) == '0') {
                break;
            }
            long n = Long.parseLong(s);
            // If the starting position is 0, just append the number to exp.
            if (index == 0) {
                dfs(result, target, currVal + n, index + i, n,
                        exp + s, num);
            } else {
                // Append the operator, then the number.
                // Current number (n, -n, preNum * n) becomes the preNum for
                // the next iteration.
                dfs(result, target, currVal + n, index + i, n,
                        exp + "+" + s, num);
                dfs(result, target, currVal - n, index + i, -n, exp +
                        "-" + s, num);
                // If the operator is *, then use the currVal of this
                // iteration, minus preNum, and plus preNum * n.
                dfs(result, target, currVal - preNum + preNum * n,
                        index + i, preNum * n, exp + "*" + s, num);
            }
        }
    }
}
/*
exp     preNum  currVal new_preNum          new_currVal
1+2+3   2       3       +3                  3+3=6
1+2-3   2       3       -3                  3-3=0
1+2*3   2       3       2*3=6 preNum*n      3-2+2*3 currVal-preNum+new_preNum
 */
