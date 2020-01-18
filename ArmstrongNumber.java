/*
The k-digit number N is an Armstrong number if and only if the k-th power of
each digit sums to N. Given a positive integer N, return true if and only if
it is an Armstrong number.
 */
public class ArmstrongNumber {
    public boolean isArmstrong(int N) {
        String s = String.valueOf(N);
        int length = s.length();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += Math.pow(s.charAt(i) - '0', length);
        }
        return sum == N;
    }
}
