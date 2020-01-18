import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char c : p.toCharArray()) {
            if (frequencies.containsKey(c)) {
                frequencies.put(c, frequencies.get(c) + 1);
            } else {
                frequencies.put(c, 1);
            }
        }
        List<Integer> list = new LinkedList<>();
        int start = 0;
        int end = 0;
        // Number of unique characters.
        int counter = frequencies.size();
        while (end < s.length()) {
            char c = s.charAt(end);
            if (frequencies.containsKey(c)) {
                frequencies.put(c, frequencies.get(c) - 1);
                if (frequencies.get(c) == 0) {
                    counter--;
                }
            }
            end++;
            // The substring contains all the characters in p. Remove the
            // redundant characters.
            while (counter == 0) {
                // Add to the list when the length of the substring is the same
                // as the length of p.
                if (end - start == p.length()) {
                    list.add(start);
                }
                if (frequencies.containsKey(s.charAt(start))) {
                    frequencies.put(s.charAt(start),
                            frequencies.get(s.charAt(start)) + 1);
                    if (frequencies.get(s.charAt(start)) > 0) {
                        counter++;
                    }
                }
                start++;
            }
        }
        return list;
    }
}
