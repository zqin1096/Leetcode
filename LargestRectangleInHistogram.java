import java.util.Stack;

/*
Given n non-negative integers representing the histogram's bar height where the
width of each bar is 1, find the area of largest rectangle in the histogram.
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int max = 0;
        // Store the index of the height.
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; ) {
            // Special case: i == heights.length.
            int height = (i == heights.length) ? 0 : heights[i];
            if (stack.isEmpty() || height >= heights[stack.peek()]) {
                // If the current height is higher than or equal to the
                // previous height, it means that the width for the rectangle
                // with previous height can be extended by 1.
                stack.push(i);
                i++;
            } else {
                // If the current height is lower than the previous height,
                // it means that the width for the rectangle with previous
                // height cannot be extended anymore. We need to calculate
                // the area for the rectangle with previous height (or the
                // height/index that on the top of the stack). Keep
                // calculating until the height/index on top of the stack is
                // lower than the current height, then we can add the current
                // height/index to the stack.
                // Get the height that on top of the stack.
                int h = heights[stack.pop()];
                // The right index of the rectangle. The height at i - i is
                // the local maximum. So the width of the rectangle can be
                // extended to this index.
                int right = i - 1;
                // If the stack is empty, it means the previous heights are
                // higher and have already popped out. So the width of the
                // rectangle can be extended back to index 0.
                int left = stack.isEmpty() ? 0 : stack.peek() + 1;
                max = Math.max(max, h * (right - left + 1));
            }
        }
        return max;
    }
}
