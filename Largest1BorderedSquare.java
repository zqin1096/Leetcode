/*
Given a 2D grid of 0s and 1s, return the number of elements in the largest
square subgrid that has all 1s on its border, or 0 if such a subgrid doesn't
exist in the grid.
 */
public class Largest1BorderedSquare {
    public int largest1BorderedSquare(int[][] grid) {
        int max = 0;
        int row = grid.length;
        int col = grid[0].length;
        // The value stored in hor[i][j] is the number of horizontal
        // continuous 1s till grid[i][j] in grid.
        int[][] horizontal = new int[row][col];
        int[][] vertical = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0) {
                        vertical[i][j] = 1;
                    } else {
                        vertical[i][j] = 1 + vertical[i - 1][j];
                    }

                    if (j == 0) {
                        horizontal[i][j] = 1;
                    } else {
                        horizontal[i][j] = 1 + horizontal[i][j - 1];
                    }
                }
            }
        }
        // Start from the bottom right corner.
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                // Get the minimum length of the bottom edge and right edge.
                int min = Math.min(horizontal[i][j], vertical[i][j]);
                // Now we need to check if top edge and left edge have length
                // min.
                while (min > max) {
                    // Either left or top does not have an edge of length min.
                    if (horizontal[i - min + 1][j] < min || vertical[i][j - min + 1] < min) {
                        min--;
                    } else {
                        // Found a square.
                        max = min;
                        break;
                    }
                }
            }
        }
        return max * max;
    }
}
