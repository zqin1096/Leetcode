/*
Give a string s, count the number of non-empty (contiguous) substrings that
have the same number of 0's and 1's, and all the 0's and all the 1's in these
substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they
occur.
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int pre = 0;
        int curr = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            // Count the number of consecutive 0 or 1.
            if (i == 0 || s.charAt(i) == s.charAt(i - 1)) {
                curr++;
            } else {
                // When the digit changes (0 to 1, 1 to 0), the number of
                // binary substrings are min(pre, curr).
                // e.g: 11000: the number of binary substrings are 2.
                result += Math.min(pre, curr);
                pre = curr;
                curr = 1;
            }
        }
        return result + Math.min(pre, curr);
    }
}
