import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        String s = A[0];
        int[] frequencies = new int[26];
        for (char c : s.toCharArray()) {
            frequencies[c - 'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            String str = A[i];
            int[] temp = new int[26];
            for (char c : str.toCharArray()) {
                temp[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                frequencies[j] = Math.min(frequencies[j], temp[j]);
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < frequencies[i]; j++) {
                result.add(String.valueOf((char) ('a' + i)));
            }
        }
        return result;
    }
}
