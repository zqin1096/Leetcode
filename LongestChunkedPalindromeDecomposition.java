public class LongestChunkedPalindromeDecomposition {
    public int longestDecomposition(String text) {
        if (text.length() == 0) {
            return 0;
        }
        for (int i = 1; i * 2 <= text.length(); i++) {
            String front = text.substring(0, i);
            String end = text.substring(text.length() - i);
            if (front.equals(end)) {
                return 2 + longestDecomposition(text.substring(i,
                        text.length() - i));
            }
        }
        return 1;
    }
}
