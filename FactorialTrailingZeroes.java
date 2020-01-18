/*
Given an integer n, return the number of trailing zeroes in n!.
Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        // Count the number of factor 5.
        int result = 0;
        while (n != 0) {
            // Count the number of numbers have factor 5 from 1 to n.
            result += n / 5;
            // Some numbers have more than 1 factor 5.
            // Continue counting after dividing n by 5.
            n = n / 5;
        }
        return result;
    }
}
