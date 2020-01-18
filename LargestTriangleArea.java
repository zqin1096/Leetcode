public class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        // Brute force.
        double max = 0;
        for (int[] i : points) {
            for (int[] j : points) {
                for (int[] k : points) {
                    double area =
                            // Divide into 3 sub-triangles which are easier
                            // to compute the area.
                            0.5 * ((i[0] - j[0]) * (i[1] - j[1]) + (i[0] - j[0]) * (j[1] - k[1]) + (i[1] - j[1]) * (k[0] - i[0]));
                    max = Math.max(area, max);
                }
            }
        }
        return max;
    }
}
