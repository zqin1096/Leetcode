public class RotateString {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.length() == 0 && B.length() == 0) {
            return true;
        }
        StringBuilder sb = new StringBuilder(A);
        for (int i = 0; i < A.length(); i++) {
            if (sb.toString().equals(B)) {
                return true;
            }
            char c = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(c);
        }
        return false;
    }
}
