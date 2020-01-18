import java.util.HashMap;
import java.util.Map;

/*
Given a string which consists of lowercase or uppercase letters, find the length
of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int length = 0;
        int numOfOdd = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                length += entry.getValue();
            } else {
                length += entry.getValue();
                numOfOdd += 1;
            }
        }
        if (numOfOdd == 0) {
            return length;
        }
        if (numOfOdd != 1) {
            length = length - (numOfOdd - 1);
        }
        return length;
    }
}
