import java.util.Stack;

/*
Given a string S of lowercase letters, a duplicate removal consists of choosing
two adjacent and equal letters, and removing them.

We repeatedly make duplicate removals on S until we no longer can.

Return the final string after all such duplicate removals have been made.  It
is guaranteed the answer is unique.
 */
public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        char[] ch = S.toCharArray();
        stack.push(ch[0]);
        for (int i = 1; i < ch.length; i++) {
            // If the current character is the same as the top element of the
            // stack, remove the top element of the stack.
            if (!stack.isEmpty() && ch[i] == stack.peek()) {
                stack.pop();
            } else {
                stack.push(ch[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
