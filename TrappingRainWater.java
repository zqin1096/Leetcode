/*
42.
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        // left[i] represents the highest height that is left to position i.
        int[] left = new int[height.length];
        // right[i] represents the highest height that is right to position i.
        int[] right = new int[height.length];
        left[0] = 0;
        right[height.length - 1] = 0;
        int maxLeft = height[0];
        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > maxLeft) {
                maxLeft = height[i - 1];
            }
            left[i] = maxLeft;
        }
        int maxRight = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i + 1] > maxRight) {
                maxRight = height[i + 1];
            }
            right[i] = maxRight;
        }
        int[] water = new int[height.length];
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            // The amount of water for each position is determined by the
            // minimum height of left and right.
            int amount = Math.min(left[i], right[i]) - height[i];
            water[i] = amount > 0 ? amount : 0;
            sum += water[i];
        }
        return sum;
    }
}
