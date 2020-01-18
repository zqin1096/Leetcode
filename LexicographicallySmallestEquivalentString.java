import java.util.ArrayList;
import java.util.List;

/*
Given strings A and B of the same length, we say A[i] and B[i] are equivalent
characters. For example, if A = "abc" and B = "cde", then we have 'a' == 'c',
'b' == 'd', 'c' == 'e'.

Equivalent characters follow the usual rules of any equivalence relation:
Reflexivity: 'a' == 'a'
Symmetry: 'a' == 'b' implies 'b' == 'a'
Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'

For example, given the equivalency information from A and B above, S = "eed",
"acd", and "aab" are equivalent strings, and "aab" is the lexicographically
smallest equivalent string of S.

Return the lexicographically smallest equivalent string of S by using the
equivalency information from A and B.

 */
public class LexicographicallySmallestEquivalentString {
    // DFS.
    public String smallestEquivalentString(String A, String B, String S) {
        List<List<Character>> map = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < A.length(); i++) {
            char a = A.charAt(i);
            char b = B.charAt(i);
            // Each letter has a list of equivalent characters, including
            // itself.
            map.get(a - 'a').add(a);
            map.get(a - 'a').add(b);

            map.get(b - 'a').add(b);
            map.get(b - 'a').add(a);
        }
        // equivalence[i] is the smallest equivalent letter for ('a' + i).
        Character[] equivalence = new Character[26];
        for (int i = 0; i < equivalence.length; i++) {
            if (map.get(i).size() != 0 && equivalence[i] == null) {
                dfs(map, equivalence, (char) ('a' + i), (char) ('a' + i),
                        new boolean[26]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (equivalence[c - 'a'] != null) {
                sb.append(equivalence[c - 'a']);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private void dfs(List<List<Character>> map, Character[] equivalence,
                     char c, char s, boolean[] visited) {
        if (visited[c - 'a']) {
            return;
        }
        visited[c - 'a'] = true;
        for (int i = 0; i < map.get(c - 'a').size(); i++) {
            equivalence[map.get(c - 'a').get(i) - 'a'] = s;
        }
        for (int i = 0; i < map.get(c - 'a').size(); i++) {
            dfs(map, equivalence, map.get(c - 'a').get(i), s, visited);
        }
    }
}
