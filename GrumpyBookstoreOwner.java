/*
Today, the bookstore owner has a store open for customers.length minutes. Every
minute, some number of customers (customers[i]) enter the store, and all those
customers leave after the end of that minute.
 */
public class GrumpyBookstoreOwner {
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        // Sliding window.
        int max = 0;
        for (int i = 0; i < X; i++) {
            max += customers[i];
        }
        for (int i = X; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                max += customers[i];
            }
        }
        int satisfied = max;
        for (int i = 1; i + X - 1 < customers.length; i++) {
            if (grumpy[i - 1] == 1) {
                satisfied -= customers[i - 1];
            }
            if (grumpy[i + X - 1] == 1) {
                satisfied += customers[i + X - 1];
            }
            max = Math.max(max, satisfied);
        }
        return max;
    }
}
