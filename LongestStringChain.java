import java.io.StringReader;
import java.util.*;

/*
Given a list of words, each word consists of English lowercase letters.

Let's say word1 is a predecessor of word2 if and only if we can add exactly one
letter anywhere in word1 to make it equal to word2.  For example, "abc" is a
predecessor of "abac".

A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1,
where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and
so on.

Return the longest possible length of a word chain with words chosen from the
given list of words.
 */
public class LongestStringChain {
    //    public int longestStrChain(String[] words) {
//        // Store the string and its corresponding longest length of word chain.
//        Map<String, Integer> map = new HashMap<>();
//        // Sort the string based on their length.
//        Arrays.sort(words, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        });
//        // Any string can be the starting point. The default value is 1.
//        for (String s : words) {
//            map.put(s, 1);
//        }
//        int max = 1;
//        // For each string, delete each letter at every index and check if the
//        // resulting string s1 exists. If it exists, the longest length of the
//        // word chain to this word s is max(map.get(s1) + 1, map.get(s)).
//        for (String s : words) {
//            for (int i = 0; i < s.length(); i++) {
//                String s1 = new StringBuilder(s).deleteCharAt(i).toString();
//                if (map.containsKey(s1)) {
//                    map.put(s, Math.max(map.get(s1) + 1, map.get(s)));
//                }
//                max = Math.max(max, map.get(s));
//            }
//        }
//        return max;
//    }
    int max = 1;
    Set<String> set = new HashSet<>();

    public int longestStrChain(String[] words) {
        for (String s : words) {
            set.add(s);
        }
        for (int i = 0; i < words.length; i++) {
            max = Math.max(longestStrChain(words[i]), max);
        }
        return max;
    }

    private int longestStrChain(String word) {
        if (word.length() == 0) {
            return 0;
        }
        if (!set.contains(word)) {
            return 0;
        } else {
            int maxChain = 1;
            for (int i = 0; i < word.length(); i++) {
                int length =
                        longestStrChain(new StringBuilder(word).deleteCharAt(i).toString()) + 1;
                maxChain = Math.max(length, maxChain);
            }
            return maxChain;
        }
    }
}
