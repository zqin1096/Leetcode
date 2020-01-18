import java.util.HashMap;
import java.util.Map;

/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"

Output: true
 */
public class InterleavingString {
    // DFS. TLE.
//    public boolean isInterleave(String s1, String s2, String s3) {
//        if (s1.length() + s2.length() != s3.length()) {
//            return false;
//        }
//        return dfs(s1, s2, s3);
//    }
//
//    private boolean dfs(String s1, String s2, String s3) {
//        if (s3.length() == 0 && s1.length() == 0 && s2.length() == 0) {
//            return true;
//        }
//        for (int i = 1; i <= s3.length(); i++) {
//            String s = s3.substring(0, i);
//            if (s1.startsWith(s)) {
//                if (dfs(s1.substring(i), s2, s3.substring(i))) {
//                    return true;
//                }
//            }
//            if (s2.startsWith(s)) {
//                if (dfs(s1, s2.substring(i), s3.substring(i))) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }


    // DFS with memorization.
    Map<String, Boolean> map = new HashMap<>();

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return dfs(s1, s2, s3);
    }

    private boolean dfs(String s1, String s2, String s3) {
        if (s3.length() == 0 && s1.length() == 0 && s2.length() == 0) {
            return true;
        }
        for (int i = 1; i <= s3.length(); i++) {
            // Get a substring from s3.
            String s = s3.substring(0, i);
            // Check if s1 has this substring (from index 0).
            // Check if the remaining s3 can be formed by the interleaving of
            // current s1 and s2.
            // We can search from s1 or s2.
            if (s1.startsWith(s)) {
                // We can store the result (if s3 can be formed by the
                // interleaving of s1 and s2). In this case, we search from s1.
                String encode = s1.substring(i) + " " + s2 + " " + s3;
                if (map.containsKey(encode)) {
                    return map.get(encode);
                }
                if (dfs(s1.substring(i), s2, s3.substring(i))) {
                    map.put(encode, true);
                    return true;
                } else {
                    map.put(encode, false);
                }
            }
            if (s2.startsWith(s)) {
                // In this case, we search from s2. So the encoding should be
                // different from the encoding when we search from s1.
                String encode = s1 + " " + s2.substring(i) + " " + s3;
                if (map.containsKey(encode)) {
                    return map.get(encode);
                }
                if (dfs(s1, s2.substring(i), s3.substring(i))) {
                    map.put(encode, true);
                    return true;
                } else {
                    map.put(encode, false);
                }
            }
        }
        return false;
    }
}
