/*
Given a number N, return true if and only if it is a confusing number, which
satisfies the following condition:

We can rotate digits by 180 degrees to form new digits. When 0, 1, 6, 8, 9 are
rotated 180 degrees, they become 0, 1, 9, 8, 6 respectively. When 2, 3, 4, 5
and 7 are rotated 180 degrees, they become invalid. A confusing number is a
number that when rotated 180 degrees becomes a different number with each digit
valid.
 */
public class ConfusingNumber {
    // Rotate the entire number as a whole.
    public boolean confusingNumber(int N) {
        if (N == 0) {
            return false;
        }
        int num = N;
        StringBuilder sb = new StringBuilder();
        while (N != 0) {
            int remainder = N % 10;
            if (remainder == 2 || remainder == 3 || remainder == 4 || remainder == 5 || remainder == 7) {
                return false;
            }
            if (remainder == 0) {
                sb.append(0);
            } else if (remainder == 1) {
                sb.append(1);
            } else if (remainder == 6) {
                sb.append(9);
            } else if (remainder == 8) {
                sb.append(8);
            } else {
                sb.append(6);
            }
            N = N / 10;
        }
        return num != Integer.parseInt(sb.toString());
    }
}
