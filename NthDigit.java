/*
Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9,
10, 11, ...

n is positive and will fit within the range of a 32-bit signed integer.
 */
public class NthDigit {
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        long n1 = n;
        long num = 9;
        int length = 1;
        // 9, 90 * 2, 900 * 3, ...
        while (n1 > num * length) {
            n1 = n1 - num * length;
            num *= 10;
            length++;
        }
        // Calculate which number that the nth digit is in.
        long quotient = n1 / length;
        long remainder = n1 % length;
        long result = (long) Math.pow(10, length - 1) + quotient - 1;
        if (remainder > 0) {
            result += 1;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(result));
        if (remainder == 0) {
            return sb.charAt(length - 1) - '0';
        } else {
            return sb.charAt((int) (remainder - 1)) - '0';
        }
    }
}
