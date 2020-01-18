/*
Given two strings text1 and text2, return the length of their longest common
subsequence.

If there is no common subsequence, return 0.
 */
public class LongestCommonSubsequence {
    // Recursion. TLE.
//    public int longestCommonSubsequence(String text1, String text2) {
//        if (text1.length() == 0 || text2.length() == 0) {
//            return 0;
//        }
//        if (text1.charAt(text1.length() - 1) == text2.charAt(text2.length() - 1)) {
//            return 1 + longestCommonSubsequence(text1.substring(0,
//                    text1.length() - 1), text2.substring(0,
//                    text2.length() - 1));
//        } else {
//            return Math.max(longestCommonSubsequence(text1, text2.substring(0
//                    , text2.length() - 1)),
//                    longestCommonSubsequence(text1.substring(0,
//                            text1.length() - 1), text2));
//        }
//    }

    public int longestCommonSubsequence(String text1, String text2) {
        // length[i][j] represents the length of longest common sub-sequence of
        // text1[0...i] and text2[0...j].
        int[][] length = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    length[i + 1][j + 1] = 1 + length[i][j];
                } else {
                    length[i + 1][j + 1] = Math.max(length[i][j + 1],
                            length[i + 1][j]);
                }
            }
        }
        return length[text1.length()][text2.length()];
    }
}
