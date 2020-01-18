/*
Given n non-negative integers a1, a2, ..., an , where each represents a point
at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
forms a container, such that the container contains the most water.
 */
public class ContainerWithMostWater {
    // Two points.
    public int maxArea(int[] height) {
        // The area formed between the lines will always be limited by the
        // height of the shorter line. Further, the wider the width, the
        // larger the area.
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left],
                    height[right]));
            if (height[left] < height[right]) {
                // The left height is lower, and since we want to obtain a
                // larger area, we need to change left in the hope of finding
                // a longer line.
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
