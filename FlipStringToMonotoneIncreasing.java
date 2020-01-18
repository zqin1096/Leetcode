
public class FlipStringToMonotoneIncreasing {
    // Assume the length of S is n.
    // 000..01...1111
    // Then k 0s are followed by n - k 1s
    public int minFlipsMonoIncr(String S) {
        int length = S.length();
        // l[i] represents the number of flips: s[0] to s[i] are zeros.
        // Calculate from the left.
        int[] l = new int[length];
        // r[i] represents the number of flips: s[i] to s[n - 1] are ones.
        // Calculate from the right.
        int[] r = new int[length];
        l[0] = S.charAt(0) - '0';
        r[length - 1] = '1' - S.charAt(length - 1);

        for (int i = 1; i < length; i++) {
            l[i] = l[i - 1] + S.charAt(i) - '0';
        }

        for (int i = length - 2; i >= 0; i--) {
            r[i] = r[i + 1] + '1' - S.charAt(i);
        }

        int min = Integer.MAX_VALUE;
        // Find the minimum number of flips to form 000..011..11 format.
        for (int i = 0; i < length - 1; i++) {
            min = Math.min(min, l[i] + r[i + 1]);
        }
        // All zeros.
        min = Math.min(min, l[length - 1]);
        // All ones.
        min = Math.min(min, r[0]);
        return min;
    }
}
