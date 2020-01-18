public class DIStringMatch {
    public int[] diStringMatch(String S) {
        // Two pointers.
        int left = 0;
        int right = S.length();
        int[] result = new int[S.length() + 1];
        for (int i = 0; i < S.length(); i++) {
            // If the character is I, choose the current minimum number and increase it by 1. If the character is D,
            // choose the current maximum number and decrease it by 1.
            result[i] = S.charAt(i) == 'I' ? left++ : right--;
        }
        // Or result[S.length()] = left.
        result[S.length()] = right;
        return result;
    }
}
