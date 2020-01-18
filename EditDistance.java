import java.util.HashMap;
import java.util.Map;

/*
Given two words word1 and word2, find the minimum number of operations required
to convert word1 to word2.

You have the following 3 operations permitted on a word:
Insert a character
Delete a character
Replace a character
 */
public class EditDistance {

    // DFS. TLE.
//    public int minDistance(String word1, String word2) {
//        // If word1 is empty, then the only option is to insert all characters
//        // of word2 into word1.
//        if (word1.length() == 0) {
//            return word2.length();
//        }
//        // If word2 is empty, then the only option is to remove all
//        // characters of word1.
//        if (word2.length() == 0) {
//            return word1.length();
//        }
//        if (word1.charAt(0) == word2.charAt(0)) {
//            // If the first character of word1 and word2 are the same,
//            // compare the rest of the strings.
//            return minDistance(word1.substring(1), word2.substring(1));
//        } else {
//            // Insert the first character of word2 at index 0 of word1.
//            // Compare word1 and the rest of the word2.
//            int insert = minDistance(word1, word2.substring(1));
//            int delete = minDistance(word1.substring(1), word2);
//            // Replace the character at index 0 of word1 with the character
//            // at index 0 of word2.
//            int replace = minDistance(word1.substring(1), word2.substring(1));
//            return 1 + Math.min(insert, Math.min(delete, replace));
//        }
//    }

    // DFS with memorization.
//    Map<String, Integer> map = new HashMap<>();
////
////    public int minDistance(String word1, String word2) {
////        if (word1.length() == 0) {
////            return word2.length();
////        }
////        // If word2 is empty, then the only option is to remove all
////        // characters of word1.
////        if (word2.length() == 0) {
////            return word1.length();
////        }
////        // Check if this combination of word1 and word2 has already been
////        // checked.
////        String encode = word1 + " " + word2;
////        if (map.containsKey(encode)) {
////            return map.get(encode);
////        }
////        if (word1.charAt(0) == word2.charAt(0)) {
////            // If the first character of word1 and word2 are the same,
////            // compare the rest of the strings.
////            int min = minDistance(word1.substring(1), word2.substring(1));
////            map.put(encode, min);
////            return min;
////        } else {
////            // Insert the first character of word2 at index 0 of word1.
////            // Compare word1 and the rest of the word2.
////            int insert = minDistance(word1, word2.substring(1));
////            int delete = minDistance(word1.substring(1), word2);
////            // Replace the character at index 0 of word1 with the character
////            // at index 0 of word2.
////            int replace = minDistance(word1.substring(1), word2.substring(1));
////            int min = 1 + Math.min(insert, Math.min(delete, replace));
////            map.put(encode, min);
////            return min;
////        }
////    }

    // Dynamic programming.
    public int minDistance(String word1, String word2) {
        // Convert word1 to word2.
        // word2: row, word1: column (word1 horizontal, word2 vertical).
        // distance[i + 1][j + 1] represents the minimum operations required to
        // convert word1[0..j] to word2[0..i].
        // distance[0][0] represents the minimum operations to convert an empty
        // string to an empty string, which is zero.
        int[][] distance = new int[word2.length() + 1][word1.length() + 1];
        // Minimum operations to convert an empty string to word2[0..i] (keep
        // inserting a character.
        for (int i = 0; i < distance.length; i++) {
            distance[i][0] = i;
        }
        // Minimum operations to convert word1[0..i] to an empty string (keep
        // deleting a character.
        for (int i = 0; i < distance[0].length; i++) {
            distance[0][i] = i;
        }
        for (int i = 1; i < distance.length; i++) {
            for (int j = 1; j < distance[i].length; j++) {
                // If word1[end] = word2[end], the result is equal to the
                // minimum operations required to convert word1[0..end - 1] to
                // word2[0..end - 1].
                if (word1.charAt(j - 1) == word2.charAt(i - 1)) {
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    // if word1[end] != word2[end], there are three potential
                    // ways to convert word1[0..end] to word2[0..end].
                    // 1. Remove word1[end] and convert word1[0..end - 1] to
                    // word2[0..end] (distance[i][j - 1] + 1).
                    // 2. Convert word1[0..end] to word2[0..end - 1] and insert
                    // word2[end] at the end of word1 (distance[i - 1][j] + 1).
                    // 3. Convert word1[0..end - 1] to word2[0..end - 1] and
                    // replace word1[end] to word2[end]
                    // (distance[i - 1][j - 1] + 1).
                    distance[i][j] = Math
                            .min(distance[i - 1][j], Math.min(
                                    distance[i - 1][j - 1], distance[i][j - 1]))
                            + 1;
                }
            }
        }
        return distance[distance.length - 1][distance[0].length - 1];
    }
}
