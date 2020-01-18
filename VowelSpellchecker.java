import java.util.*;

public class VowelSpellchecker {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        String[] result = new String[queries.length];
        Set<String> set = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> cap = new HashMap<>();
        Map<String, String> vowel = new HashMap<>();
        for (int i = 0; i < wordlist.length; i++) {
            String lowerCase = wordlist[i].toLowerCase();
            // Replace all vowels with character #.
            String replaceVowels = wordlist[i].toLowerCase().replaceAll("[aeiou]", "#");
            cap.putIfAbsent(lowerCase, wordlist[i]);
            vowel.putIfAbsent(replaceVowels, wordlist[i]);
        }

        for (int i = 0; i < queries.length; i++) {
            if (set.contains(queries[i])) {
                result[i] = queries[i];
            } else if (cap.containsKey(queries[i].toLowerCase())) {
                result[i] = cap.get(queries[i].toLowerCase());
            } else if (vowel.containsKey(queries[i].toLowerCase().replaceAll("[aeiou]", "#"))) {
                result[i] = vowel.get(queries[i].toLowerCase().replaceAll("[aeiou]", "#"));
            } else {
                result[i] = "";
            }
        }
        return result;
    }
}
