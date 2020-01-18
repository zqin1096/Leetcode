import java.awt.*;
import java.util.*;
import java.util.List;

public class WordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> result = new ArrayList<>();
        int[] frequencyB = new int[26];
        // Find the maximum number of each letter of the strings from B.
        for (String s : B) {
            int[] temp = new int[26];
            for (char c : s.toCharArray()) {
                temp[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                frequencyB[i] = Math.max(frequencyB[i], temp[i]);
            }
        }
        for (String s : A) {
            int[] frequencyA = new int[26];
            for (char c : s.toCharArray()) {
                frequencyA[c - 'a']++;
            }
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (frequencyA[i] < frequencyB[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(s);
            }
        }
        return result;
    }
}
