import java.util.*;

/*
Given two words (beginWord and endWord), and a dictionary's word list, find the
length of shortest transformation sequence from beginWord to endWord, such that:
Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a
transformed word.

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
 */
public class WordLadder {

    // TLE.
//    private class Pair {
//        String word;
//        int length;
//
//        Pair(String word, int length) {
//            this.word = word;
//            this.length = length;
//        }
//    }
//
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if (!wordList.contains(endWord)) {
//            return 0;
//        }
////        Set<String> visited = new HashSet<>();
//        Queue<Pair> queue = new LinkedList<>();
//        queue.add(new Pair(beginWord, 1));
//        while (!queue.isEmpty()) {
//            Pair pair = queue.remove();
//            if (pair.word.equals(endWord)) {
//                return pair.length;
//            }
////            visited.add(pair.word);
//            wordList.remove(pair.word);
//            for (int i = 0; i < wordList.size(); i++) {
//                String s = wordList.get(i);
////                if (!visited.contains(s)) {
//                int count = 0;
//                for (int j = 0; j < s.length(); j++) {
//                    if (s.charAt(j) != pair.word.charAt(j)) {
//                        count++;
//                    }
//                }
//                if (count == 1) {
//                    queue.add(new Pair(s, pair.length + 1));
//                }
////                }
//            }
//        }
//        return 0;
//    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        // The length from beginWord to this word.
        // If a string is in the map, it means that the string has already
        // been searched and does not need to explore again.
        Map<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        map.put(beginWord, 1);
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.remove();
            if (word.equals(endWord)) {
                return map.get(word);
            }
            for (int i = 0; i < wordList.size(); i++) {
                String s = wordList.get(i);
                int count = 0;
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) != word.charAt(j)) {
                        count++;
                    }
                }
                if (count == 1) {
                    // If the word has been explored, it means the shortest
                    // distance to this word has been found.
                    if (!map.containsKey(s)) {
                        map.put(s, map.get(word) + 1);
                        queue.add(s);
                    }
                }
            }
        }
        return 0;
    }
}
