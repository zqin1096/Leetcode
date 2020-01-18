public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        // Find the last bit.
        int last = n & 1;
        // Right shift
        n >>>= 1;
        while (n != 0) {
            if ((n & 1) == last) {
                return false;
            }
            last = n & 1;
            n >>>= 1;
        }
        return true;
    }
}
