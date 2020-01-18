/*
Given a list of words and two words word1 and word2, return the shortest
distance between these two words in the list.

You may assume that word1 does not equal to word2, and word1 and word2 are both
in the list.
 */
public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        // Do not over-think the problem.
        int index1 = -1;
        int index2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            // Find the indices of word1 and word2.
            if (words[i].equals(word1)) {
                index1 = i;
            }
            if (words[i].equals(word2)) {
                index2 = i;
            }
            // If we find both words, then we calculate the minimum distance.
            if (index1 != -1 && index2 != -1) {
                min = Math.min(min, Math.abs(index1 - index2));
            }
        }
        return min;
    }
}
