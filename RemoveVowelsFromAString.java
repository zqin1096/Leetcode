/*
Given a string S, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and
return the new string.
 */
public class RemoveVowelsFromAString {
    public String removeVowels(String S) {
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
