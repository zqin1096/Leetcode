/*
An image is represented by a 2-D array of integers, each integer representing
the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of
the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels
connected 4-directionally to the starting pixel of the same color as the
starting pixel, plus any pixels connected 4-directionally to those pixels (also
with the same color as the starting pixel), and so on. Replace the color of all
of the aforementioned pixels with the newColor.
 */
public class FloodFill {
    // Standard DFS.
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, newColor, image[sr][sc], visited);
        return image;
    }

    private void dfs(int[][] image, int row, int col, int newColor, int start,
                     boolean[][] visited) {
        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        if (image[row][col] != start) {
            return;
        }
        image[row][col] = newColor;
        if (row - 1 >= 0) {
            dfs(image, row - 1, col, newColor, start, visited);
        }
        if (row + 1 < image.length) {
            dfs(image, row + 1, col, newColor, start, visited);
        }
        if (col - 1 >= 0) {
            dfs(image, row, col - 1, newColor, start, visited);
        }
        if (col + 1 < image[row].length) {
            dfs(image, row, col + 1, newColor, start, visited);
        }
    }
}
