public class SurfaceAreaOf3DShapes {
    public int surfaceArea(int[][] grid) {
        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // Calculate the surface area at this grid.
                if (grid[i][j] != 0) {
                    area += (2 + grid[i][j] * 4);
                    // Should not count the overlapping area.
                    if (i - 1 >= 0 && grid[i - 1][j] != 0) {
                        area -= Math.min(grid[i - 1][j], grid[i][j]) * 2;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] != 0) {
                        area -= Math.min(grid[i][j - 1], grid[i][j]) * 2;
                    }
                }
            }
        }
        return area;
    }
}
