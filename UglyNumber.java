/*
Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        // Keep dividing 2, 3, and 5.
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        // If num is 1 in the end, it means num only contains factor 2, 3,
        // and 5.
        return num == 1;
    }
}
