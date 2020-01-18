import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length() - 1; i++) {
            if (ch[i] == ch[i + 1]) {
                isPalindrome[i][i + 1] = true;
            }
        }
        for (int i = 3; i <= s.length(); i++) {
            for (int j = 0; j + i - 1 < s.length(); j++) {
                if (ch[j] == ch[j + i - 1] && isPalindrome[j + 1][j + i - 2]) {
                    isPalindrome[j][j + i - 1] = true;
                }
            }
        }
        partition(s, result, isPalindrome, 0, new ArrayList<String>());
        return result;
    }

    private void partition(String s, List<List<String>> result, boolean[][] isPalindrome, int startIndex, List<String> list) {
        if (startIndex >= s.length()) {
            List<String> copy = new ArrayList<>(list);
            result.add(copy);
            return;
        }
        for (int i = 1; i <= s.length() - startIndex; i++) {
            if (isPalindrome[startIndex][startIndex + i - 1]) {
                list.add(s.substring(startIndex, startIndex + i));
                partition(s, result, isPalindrome, startIndex + i, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
