import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.equals(B)) {
            // Need to swap 2 same characters.
            Set<Character> set = new HashSet<>();
            for (char c : A.toCharArray()) {
                set.add(c);
            }
            // The size of the set should be smaller if there are same characters.
            return set.size() < A.length();
        }

        // Otherwise, there should be only 2 differences.
        List<Integer> difference = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                difference.add(i);
            }
        }
        if (difference.size() != 2) {
            return false;
        } else {
            return A.charAt(difference.get(0)) == B.charAt(difference.get(1)) && A.charAt(difference.get(1)) == B.charAt(difference.get(0));
        }
    }
}
