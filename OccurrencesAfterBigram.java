import java.util.ArrayList;
import java.util.List;

/*
Given words first and second, consider occurrences in some text of the form
"first second third", where second comes immediately after first, and third
comes immediately after second.
 */
public class OccurrencesAfterBigram {
    public static String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList<>();
        String[] tokens = text.split(" ");
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i].equals(second) && tokens[i - 1].equals(first)) {
                if (i + 1 < tokens.length) {
                    list.add(tokens[i + 1]);
                }
            }
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
