/*
Given a string S and a string T, count the number of distinct subsequences of
S which equals T.

A subsequence of a string is a new string which is formed from the original
string by deleting some (can be none) of the characters without disturbing the
relative positions of the remaining characters. (ie, "ACE" is a subsequence of
"ABCDE" while "AEC" is not).
 */
public class DistinctSubsequences {

    // DFS. TLE.
//    int num = 0;
//
//    public int numDistinct(String s, String t) {
//        if (s.length() < t.length()) {
//            return 0;
//        }
//        numDistinct(s, t, 0, 0);
//        return num;
//    }
//
//    private void numDistinct(String s, String t, int index1, int index2) {
//        if (index2 == t.length()) {
//            num++;
//            return;
//        }
//        for (int i = index1; i < s.length(); i++) {
//            if (s.charAt(i) == t.charAt(index2)) {
//                numDistinct(s, t, i + 1, index2 + 1);
//            }
//        }
//    }

    // DFS with memorization.
    Integer[][] nums = null;

    public int numDistinct(String s, String t) {
        nums = new Integer[t.length()][s.length()];
        return dfs(s, t);
    }

    // dfs recursively computes how many t in s.
    // Computes the number of distinct sub-sequences of t[0...i] (continuous)
    // in s[0...j] (not necessarily continuous).
    private int dfs(String s, String t) {
        if (s.length() == 0 && t.length() == 0) {
            return 1;
        }
        // An empty string is a substring of any string.
        if (t.length() == 0) {
            return 1;
        }
        // Non-empty string cannot be a substring of an empty string.
        if (s.length() == 0) {
            // t is an non-empty string.
            return 0;
        }
        int i = t.length() - 1;
        int j = s.length() - 1;
        if (nums[i][j] != null) {
            return nums[i][j];
        }
        // If the last characters match, then we need to sum t[0...i - 1] in
        // s[0...j - 1] and t[0...i] in s[0...j - 1] (既可以从前面找剩下的字符串,
        // 也可以从前面找全部的字符串). They are guaranteed to be distinct. 第一种
        // 情况t的最后一个字符已经找到.第二种情况t的最后一个字符还需要在s的前面找.
        if (s.charAt(s.length() - 1) == t.charAt(t.length() - 1)) {
            int num = dfs(s.substring(0, s.length() - 1), t.substring(0,
                    t.length() - 1)) + dfs(s.substring(0, s.length() - 1), t);
            nums[i][j] = num;
            return num;
        } else {
            // If the last characters do not match, then we need to find
            // t[0...i] in s[0...j - 1].
            int num = dfs(s.substring(0, s.length() - 1), t);
            nums[i][j] = num;
            return num;
        }
    }
}
/*
   (s） r   a   b   b   b   i   t
(t)
r
a
b
b
i
t
The last character of (t) is t, the last character of (s) is also t, so
dfs(rabbbit, rabbit) = dfs(rabbbi, rabbi) + dfs(rabbbi, rabbit). It means
that we can either include or exclude this last t in the sub-sequence.
In another words, we try to find the number of "rabbit" in "rabbbit". We know
 they both have "t" as their last character, then we can find the number of
 "rabbi" in "rabbbi", and we can also find the number of "rabbit" in "rabbbi".
 */
