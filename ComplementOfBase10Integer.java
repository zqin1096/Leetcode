/*
Every non-negative integer N has a binary representation.  For example, 5 can
be represented as "101" in binary, 11 as "1011" in binary, and so on.  Note
that except for N = 0, there are no leading zeroes in any binary representation.

The complement of a binary representation is the number in binary you get when
changing every 1 to a 0 and 0 to a 1.  For example, the complement of "101" in
binary is "010" in binary.
 */
public class ComplementOfBase10Integer {
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        int res = 0;
        int power = 1;
        while (N != 0) {
            // Flip the digit and multiply by the power of 2.
            int i = 1 - (N & 1);
            res += power * i;
            power *= 2;
            N = N >> 1;
        }
        return res;
    }
}
