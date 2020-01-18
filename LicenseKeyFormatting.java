public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        String s = S.toUpperCase();
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != '-') {
                sb.append(c);
            } else {
                continue;
            }
            if (sb.length() % K == 0) {
                result.append(sb);
                result.append('-');
                sb = new StringBuilder();
            }
        }
        result.append(sb);
        // Input: "---".
        if (result.length() == 0) {
            return "";
        }
        // Input: "--a-a-a-a--".
        if (result.charAt(result.length() - 1) == '-') {
            result.deleteCharAt(result.length() - 1);
        }
        return result.reverse().toString();
    }
}
