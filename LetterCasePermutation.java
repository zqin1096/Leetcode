import java.util.LinkedList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new LinkedList<>();
        if (S == null) {
            return result;
        }
        letterCasePermutation(S, 0, new StringBuilder(), result);
        return result;
    }

    private void letterCasePermutation(String S, int index, StringBuilder sb,
                                       List<String> list) {
        if (sb.length() == S.length()) {
            list.add(sb.toString());
            return;
        }
        char c = S.charAt(index);
        if (Character.isLetter(c)) {
            // Append the uppercase and lowercase letter to the end,
            // respectively.
            letterCasePermutation(S, index + 1,
                    sb.append(Character.toUpperCase(c)), list);
            sb.deleteCharAt(sb.length() - 1);
            letterCasePermutation(S, index + 1,
                    sb.append(Character.toLowerCase(c)), list);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            // If the character is not letter, append it to the end and
            // continue.
            letterCasePermutation(S, index + 1, sb.append(c), list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
