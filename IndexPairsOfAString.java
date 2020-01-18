import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Given a text string and words (a list of strings), return all index pairs
[i, j] so that the substring text[i]...text[j] is in the list of words.

Return the pairs [i,j] in sorted order (i.e. sort them by their first
coordinate in case of ties sort them by their second coordinate).
 */
public class IndexPairsOfAString {
    // Use indexOf.
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> list = new ArrayList<>();
        for (String word : words) {
            int fromIndex = 0;
            while (text.indexOf(word, fromIndex) != -1) {
                int start = text.indexOf(word, fromIndex);
                list.add(new int[]{start, start + word.length() - 1});
                // + 1 in case there is an overlapping situation.
                fromIndex = start + 1;
            }
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }
        return result;
    }
}
