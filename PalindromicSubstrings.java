/*
Given a string, your task is to count how many palindromic substrings in this
string.

The substrings with different start indexes or end indexes are counted as
different substrings even they consist of same characters.
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int num = 0;
        // if isPalindrome[i][j] is true, then s[i...j] is a palindromic
        // substring.
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            num++;
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                num++;
                isPalindrome[i][i + 1] = true;
            }
        }
        for (int i = 3; i <= s.length(); i++) {
            for (int j = 0; j + i - 1 < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j + i - 1) && isPalindrome[j + 1][j + i - 2]) {
                    num++;
                    isPalindrome[j][j + i - 1] = true;
                }
            }
        }
        return num;
    }
}
