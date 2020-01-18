import java.util.*;

/*
Given a non-empty string s and a dictionary wordDict containing a list of
non-empty words, add spaces in s to construct a sentence where each word is a
valid dictionary word. Return all such possible sentences.

The same word in the dictionary may be reused multiple times in the
segmentation.

You may assume the dictionary does not contain duplicate words.
 */
public class WordBreakII {
    // DFS. TLE.
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        Set<String> set = new HashSet<>(wordDict);
//        List<String> list = new ArrayList<>();
//        dfs(s, list, set, "");
//        return list;
//    }
//
//    private void dfs(String s, List<String> list, Set<String> set,
//                     String sentence) {
//        if (s.length() == 0) {
//            list.add(sentence);
//            return;
//        }
//        for (int i = 1; i <= s.length(); i++) {
//            String str = s.substring(0, i);
//            if (set.contains(str)) {
//                if (sentence.length() == 0) {
//                    dfs(s.substring(i), list, set, sentence + s.substring(0,
//                            i));
//                } else {
//                    dfs(s.substring(i), list, set,
//                            sentence + " " + s.substring(0,
//                                    i));
//                }
//            }
//        }
//    }

    // DFS with memorization.
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Map<String, List<String>> map = new HashMap<>();
        return wordBreak(s, set, map);
    }

    // Store the string and its possible sentences in the map.
    private List<String> wordBreak(String s, Set<String> wordDict, Map<String
            , List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> list = new ArrayList<>();
        if (s.length() == 0) {
            // Return a list of size 1 containing an empty string to append
            // at the end.
            list.add("");
            return list;
        }
        for (int i = 1; i <= s.length(); i++) {
            // Split the string s into left part and right part.
            // If the left part exists, then recursively find the possible
            // sentences for the right part and append them to the left part.
            String left = s.substring(0, i);
            if (wordDict.contains(left)) {
                String right = s.substring(i);
                // If the right substring cannot be split, then an empty
                // array will be returned.
                List<String> sentences = wordBreak(right, wordDict, map);
                for (int j = 0; j < sentences.size(); j++) {
                    // If the sentence is empty string, then do not append
                    // empty space at the end.
                    list.add(left + (sentences.get(j).length() == 0 ? "" : " ") + sentences.get(j));
                }
            }
        }
        // Store the s and its corresponding possible sentences.
        map.put(s, list);
        return list;
    }
}
