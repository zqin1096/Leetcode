import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Given a collection of intervals, merge all overlapping intervals.
 */
public class MergeIntervals {
    // Draw some intervals on the paper.
//    public int[][] merge(int[][] intervals) {
//        if (intervals == null || intervals.length == 0) {
//            return new int[0][];
//        }
//        // Sort the intervals in increasing order based on their starting point.
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });
//        int start = intervals[0][0];
//        int end = intervals[0][1];
//        List<int[]> list = new ArrayList<>();
//        for (int i = 0; i < intervals.length; i++) {
//            int[] interval = intervals[i];
//            // If the starting point of the current interval is before the
//            // latest ending point, it means they overlaps and the ending
//            // point needs to be updated.
//            if (interval[0] <= end) {
//                end = Math.max(end, interval[1]);
//            } else {
//                // Otherwise, they do not overlap and we can create a new
//                // interval.
//                list.add(new int[]{start, end});
//                start = interval[0];
//                end = interval[1];
//            }
//        }
//        list.add(new int[]{start, end});
//        int[][] result = new int[list.size()][2];
//        for (int i = 0; i < list.size(); i++) {
//            result[i][0] = list.get(i)[0];
//            result[i][1] = list.get(i)[1];
//        }
//        return result;
//    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }
        List<int[]> list = new ArrayList<>();
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        // Get the starting points and the ending points.
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        // Sort in ascending order.
        Arrays.sort(starts);
        Arrays.sort(ends);
        int start = starts[0];
        int end = ends[0];
        for (int i = 1; i < intervals.length; i++) {
            if (starts[i] > end) {
                // If the next starting point is behind the current ending
                // points, it means there is no overlap. The starting point
                // and the ending point will be updated.
                list.add(new int[]{start, end});
                start = starts[i];
                end = ends[i];
            } else {
                // If the next starting point is before the current ending
                // point, it means there is an overlap. The starting point
                // stays the same, and the ending point will be updated to
                // the next one.
                end = ends[i];
            }
        }
        list.add(new int[]{start, end});
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }
        return result;
    }
}
