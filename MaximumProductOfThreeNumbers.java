/*
Given an integer array, find three numbers whose product is maximum and output
the maximum product.
 */
public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i < min1 || i < min2) {
                if (min1 <= min2) {
                    min2 = i;
                } else {
                    min1 = i;
                }
            }
            if (i > max1 || i > max2 || i > max3) {
                if (max1 <= max2) {
                    if (max1 <= max3) {
                        max1 = i;
                    } else {
                        max3 = i;
                    }
                } else {
                    if (max2 <= max3) {
                        max2 = i;
                    } else {
                        max3 = i;
                    }
                }
            }
        }
        return Math.max(max1 * max2 * max3, Math.max(Math.max(max1, max2),
                max3) * min1 * min2);
    }

}
