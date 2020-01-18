import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given a non-empty string s and a dictionary wordDict containing a list of
non-empty words, determine if s can be segmented into a space-separated
sequence of one or more dictionary words.

The same word in the dictionary may be reused multiple times in the
segmentation.

You may assume the dictionary does not contain duplicate words.
 */
public class WordBreak {
    // DFS. TLE.
//    public boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> set = new HashSet<>(wordDict);
//        return dfs(s, set);
//    }
//
//    private boolean dfs(String s, Set<String> wordDict) {
//        if (s.length() == 0) {
//            return true;
//        }
//        for (int i = 1; i <= s.length(); i++) {
//            if (wordDict.contains(s.substring(0, i))) {
//                if (dfs(s.substring(i), wordDict)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        // dp[i] indicates whether s[0, i] can be formed.
        // Check if the substrings of s (start from index 0) can be formed.
        boolean[] dp = new boolean[s.length()];
        // i represents the ending index.
        for (int i = 0; i < s.length(); i++) {
            // j represents the starting index.
            for (int j = 0; j <= i; j++) {
                // Check the longest substring [j, i] first. Then [j + 1, i],
                // [j + 2, i] ...
                String str = s.substring(j, i + 1);
                // If j is 0, it means that s[0, i] can be formed.
                // If j is not 0, it means that s[j, i] can be formed, if
                // s[0, j - 1] can be formed, then s[0, i] can be formed.
                if (set.contains(str) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    // Once we found s[0, i] can be formed, we can break the
                    // inner loop.
                    break;
                }
            }
        }
        return dp[s.length() - 1];
    }
}
