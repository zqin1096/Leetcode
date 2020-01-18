import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int start = 0;
        int end = s.length() - 1;
        char[] ch = s.toCharArray();
        while (start < end) {
            if (vowels.contains(Character.toLowerCase(ch[start])) && vowels.contains(Character.toLowerCase(ch[end]))) {
                char c = ch[start];
                ch[start] = ch[end];
                ch[end] = c;
                start++;
                end--;
            } else if (vowels.contains(Character.toLowerCase(ch[start])) && !vowels.contains(Character.toLowerCase(ch[end]))) {
                end--;
            } else if (!vowels.contains(Character.toLowerCase(ch[start])) && vowels.contains(Character.toLowerCase(ch[end]))) {
                start++;
            } else {
                start++;
                end--;
            }
        }
        return new String(ch);
    }
}
