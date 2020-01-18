import java.util.Arrays;

/*
Students are asked to stand in non-decreasing order of heights for an annual
photo.

Return the minimum number of students not standing in the right positions.
(This is the number of students that must move in order for all students to be
standing in non-decreasing order of height.)
 */
public class HeightChecker {
    // Number of students that are out of positions.
    public int heightChecker(int[] heights) {
        int[] nums = new int[heights.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = heights[i];
        }
        Arrays.sort(heights);
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != heights[i]) {
                num++;
            }
        }
        return num;
    }
}
