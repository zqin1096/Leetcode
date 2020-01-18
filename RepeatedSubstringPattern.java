public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = s.length() / 2; i >= 1; i--) {
            // The length of the substring must be a divisor of the length of s.
            if (s.length() % i == 0) {
                int repeat = s.length() / i;
                String substring = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < repeat; j++) {
                    sb.append(substring);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
