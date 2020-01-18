import java.util.Stack;

/*
Given an encoded string, return it's decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the
square brackets is being repeated exactly k times. Note that k is guaranteed to
be a positive integer.

You may assume that the input string is always valid; No extra white spaces,
square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits
and that digits are only for those repeat numbers, k. For example, there won't
be input like 3a or 2[4].
 */
public class DecodeString {
    public String decodeString(String s) {
        // There is a [] following a number.
        Stack<Integer> count = new Stack<>();
        // Store different parts. Only one decoded string in the end.
        Stack<String> result = new Stack<>();
        int i = 0;
        // First part (current part). s may start with letters.
        result.push("");
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int start = i;
                // In case the number is not just single digit.
                while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    i++;
                }
                count.push(Integer.parseInt(s.substring(start, i + 1)));
            } else if (c == '[') {
                // A new part (substring). Need to repeated.
                result.push("");
            } else if (c == ']') {
                // The current part ends.
                // Get the number for current part.
                int num = count.pop();
                // Get the current part.
                String str = result.pop();
                StringBuilder sb = new StringBuilder();
                // Repeat str num times.
                for (int j = 0; j < num; j++) {
                    sb.append(str);
                }
                // Append sb to the previous part and push on the stack again.
                result.push(result.pop() + sb.toString());
            } else {
                // Append c to the current part.
                result.push(result.pop() + c);
            }
            i += 1;
        }
        return result.pop();
    }
}
