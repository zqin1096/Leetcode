public class ProjectionAreaOf3DShapes {
    public int projectionArea(int[][] grid) {
        int N = grid.length;
        int xy = 0;
        int[] xz = new int[N];
        int[] yz = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != 0) {
                    xy++;
                }
                xz[j] = Math.max(xz[j], grid[i][j]);
                yz[i] = Math.max(yz[i], grid[i][j]);
            }
        }
        int area = 0;
        for (int i = 0; i < N; i++) {
            area += xz[i] + yz[i];
        }
        return area + xy;
    }
}
