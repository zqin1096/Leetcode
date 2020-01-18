import java.util.HashSet;
import java.util.Set;

public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        Set<Character> set = new HashSet<>();
        for (char c : letters) {
            set.add(c);
        }
        // Check the next 25 letters of target one by one.
        for (int i = 1; i <= 25; i++) {
            char c = (char) ((target - 'a' + i) % 26 + 'a');
            if (set.contains(c)) {
                return c;
            }
        }
        throw new IllegalArgumentException();
    }
}
