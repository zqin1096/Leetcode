import java.util.HashMap;
import java.util.Map;

/*
Given a string s, partition s such that every substring of the partition is a
palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.
 */
public class PalindromePartitioningII {
    // DFS with memorization. Top down DP.
//    Map<String, Integer> map = new HashMap<>();
//
//    public int minCut(String s) {
//        if (map.containsKey(s)) {
//            return map.get(s);
//        }
//        // If s is an empty string, the function will return -1. So if s
//        // itself is palindrome, the number of cut is 0.
//        int min = s.length() - 1;
//        for (int i = 1; i <= s.length(); i++) {
//            String substring = s.substring(0, i);
//            if (isPalindrome(substring)) {
//                min = Math.min(min, 1 + minCut(s.substring(i)));
//            }
//        }
//        map.put(s, min);
//        return min;
//    }
//
//    private boolean isPalindrome(String s) {
//        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
//            if (s.charAt(i) != s.charAt(j)) {
//                return false;
//            }
//        }
//        return true;
//    }

    // Dynamic programming.
    public int minCut(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        // A single character must be palindrome.
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
            }
        }
        // i represents the length of the substring.
        for (int i = 2; i <= s.length(); i++) {
            for (int j = 0; j + i - 1 < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j + i - 1) && isPalindrome[j + 1][j + i - 2]) {
                    isPalindrome[j][j + i - 1] = true;
                }
            }
        }
        // minCut[i] represents the minimum cuts needed for s[0...i].
        int[] minCut = new int[s.length()];
        // i represents the ending index.
        for (int i = 0; i < s.length(); i++) {
            int min = i;
            // j represents the staring index.
            for (int j = 0; j <= i; j++) {
                if (isPalindrome[j][i]) {
                    if (j == 0) {
                        // If s[0...i] is palindrome, then we do not need to
                        // cut this substring.
                        min = 0;
                    } else {
                        min = Math.min(min, 1 + minCut[j - 1]);
                    }
                }
            }
            minCut[i] = min;
        }
        return minCut[s.length() - 1];
    }
}
