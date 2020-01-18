/*
Given a string S, return the number of substrings of length K with no repeated
characters.

All characters of S are lowercase English letters.
 */
public class FindKLengthSubstringsWithNoRepeatedCharacters {
    public int numKLenSubstrNoRepeats(String S, int K) {
        // Sliding window.
        if (K > S.length()) {
            return 0;
        }
        boolean[] ch = new boolean[26];
        int num = 0;
        int start = 0;
        int end = 0;
        while (end < S.length()) {
            char c = S.charAt(end);
            if (!ch[c - 'a']) {
                // Mark the current character as visited.
                ch[c - 'a'] = true;
                end++;
                // If the length is K, increment num.
                if (end - start == K) {
                    num++;
                    // Mark the character at index start as unvisited.
                    ch[S.charAt(start) - 'a'] = false;
                    start++;
                }
            } else {
                // If a duplicate character c is found, then keeping
                // incrementing start until it passes the index of the
                // previous c.
                while (S.charAt(start) != c) {
                    ch[S.charAt(start) - 'a'] = false;
                    start++;
                }
                start++;
                end++;
            }
        }
        return num;
    }
}
