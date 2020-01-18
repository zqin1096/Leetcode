import java.util.ArrayList;
import java.util.List;

/*
A query word matches a given pattern if we can insert lowercase letters to the
pattern word so that it equals the query. (We may insert each character at any
position, and may insert 0 characters.)

Given a list of queries, and a pattern, return an answer list of booleans,
where answer[i] is true if and only if queries[i] matches the pattern.
 */
public class CamelcaseMatching {
    // Brute-force.
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            boolean flag = true;
            StringBuilder query = new StringBuilder(queries[i]);
            int pos = -1;
            for (char c : pattern.toCharArray()) {
                // pos has to be larger each time.
                if (query.toString().indexOf(c, pos) > pos) {
                    pos = query.toString().indexOf(c);
                    query.setCharAt(pos, ' ');
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                boolean hasUppercase =
                        !query.toString().equals(query.toString().toLowerCase());
                result.add(!hasUppercase);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}
