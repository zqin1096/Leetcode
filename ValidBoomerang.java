/*
A boomerang is a set of 3 points that are all distinct and not in a straight
line.
 */
public class ValidBoomerang {
    public boolean isBoomerang(int[][] points) {
        // Calculate the slope.
        return (points[0][1] - points[1][1]) * (points[0][0] - points[2][0]) != (points[0][1] - points[2][1]) * (points[0][0] - points[1][0]);
    }
}
