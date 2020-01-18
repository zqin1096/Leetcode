import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
You have a set of tiles, where each tile has one letter tiles[i] printed on
it. Return the number of possible non-empty sequences of letters you can make.

tiles consists of uppercase English letters.
 */
public class LetterTilePossibilities {
    //    public int numTilePossibilities(String tiles) {
//        if (tiles == null || tiles.length() == 0) {
//            return 0;
//        }
//        int[] count = new int[26];
//        for (char c : tiles.toCharArray()) {
//            count[c - 'A']++;
//        }
//        return dfs(count);
//    }
//
//    private int dfs(int[] count) {
//        int sum = 0;
//        for (int i = 0; i < count.length; i++) {
//            if (count[i] == 0) {
//                // Cannot pick this letter since there is none.
//                continue;
//            }
//            // Pick this letter and form a new sequence.
//            sum++;
//            // Decrease the count for this letter.
//            count[i]--;
//            // Add the number of sequences formed by the remaining letters
//            // (built on the previous built one).
//            sum += dfs(count);
//            count[i]++;
//        }
//        return sum;
//    }

    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        List<Character> list = new LinkedList<>();
        for (char c : tiles.toCharArray()) {
            list.add(c);
        }
        dfs(set, tiles.length(), "", list);
        return set.size();
    }

    private void dfs(Set<String> set, int length, String s,
                     List<Character> list) {
        if (s.length() > 0 && s.length() <= length) {
            set.add(s);
        }
        for (int i = 0; i < list.size(); i++) {
            char c = list.get(i);
            list.remove(i);
            dfs(set, length, s + c, list);
            list.add(i, c);
        }
    }
}
