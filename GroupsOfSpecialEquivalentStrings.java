import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GroupsOfSpecialEquivalentStrings {
    // Permutation.
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<String>();
        for (String s : A) {
            // Count the number of each alphabet at even and odd indexes.
            int[] count = new int[52];
            for (int i = 0; i < s.length(); i++) {
                // The frequencies of each alphabet at even indexes are stored from index 0 to 25 in count array.
                count[s.charAt(i) - 'a' + (i % 2) * 26]++;
            }
            set.add(Arrays.toString(count));
        }
        return set.size();
    }
}
