import java.util.Arrays;
import java.util.Comparator;

/*
There are a number of spherical balloons spread in two-dimensional space. For
each balloon, provided input is the start and end coordinates of the horizontal
diameter. Since it's horizontal, y-coordinates don't matter and hence the
x-coordinates of start and end of the diameter suffice. Start is always smaller
than end. There will be at most 104 balloons.

An arrow can be shot up exactly vertically from different points along the
x-axis. A balloon with xstart and xend bursts by an arrow shot at x if
xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot.
An arrow once shot keeps travelling up infinitely. The problem is to find the
minimum number of arrows that must be shot to burst all balloons.
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    // Similar to Meeting Room 2.
    // If several intervals overlap, then we can use 1 arrow to burst them
    // together.
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        // Sort the intervals based on their starting locations.
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int num = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            // If the starting point of the current interval is <= the ending
            // point of the previous interval, it means they overlap. Keep
            // the smaller ending point so we can know if the next interval
            // overlap with it as well.
            // e.g
            // [1, 3]
            //    [2, 5]
            //       [4, 7]
            // The second interval overlaps with the first interval. We need
            // to keep the minimum ending point of 3 and 5, which is 3.
            // Because we want to know if the third overlap with both of them
            // as well. In this case, [4, 7] overlaps with [2, 5], but not with
            // [1, 3]. So we need 2 arrows.
            if (points[i][0] <= end) {
                end = Math.min(end, points[i][1]);
            } else {
                num++;
                end = points[i][1];
            }
        }
        return num;
    }
}
