public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder s = new StringBuilder();
        int length1 = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (length1 != 0) {
                    s.deleteCharAt(length1 - 1);
                    length1--;
                }
            } else {
                s.append(S.charAt(i));
                length1++;
            }
        }
        String str1 = s.toString();

        StringBuilder t = new StringBuilder();
        int length2 = 0;
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (length2 != 0) {
                    t.deleteCharAt(length2 - 1);
                    length2--;
                }
            } else {
                t.append(T.charAt(i));
                length2++;
            }
        }
        String str2 = t.toString();
        return str1.equals(str2);
    }
}
