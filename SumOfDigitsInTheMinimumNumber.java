/*
Given an array A of positive integers, let S be the sum of the digits of the
minimal element of A.

Return 0 if S is odd, otherwise return 1.
 */
public class SumOfDigitsInTheMinimumNumber {
    public int sumOfDigits(int[] A) {
        int min = Integer.MAX_VALUE;
        for (int i : A) {
            min = Math.min(min, i);
        }
        int sum = 0;
        while (min != 0) {
            sum += min % 10;
            min = min / 10;
        }
        return 1 - sum % 2;
    }
}
