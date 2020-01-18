/*
Given a list of words and two words word1 and word2, return the shortest
distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the
list.
 */
public class ShortestWordDistanceIII {
    // Similar to 243.
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(word2)) {
                // If word1 and word2 are the same, we need to find 2
                // different indices.
                if (words[i].equals(word1)) {
                    index2 = index1;
                    index1 = i;
                }
            } else {
                if (words[i].equals(word1)) {
                    index1 = i;
                }
                if (words[i].equals(word2)) {
                    index2 = i;
                }
            }
            if (index1 != -1 && index2 != -1) {
                min = Math.min(min, Math.abs(index1 - index2));
            }
        }
        return min;
    }
}
