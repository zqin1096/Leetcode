import java.util.Arrays;
import java.util.Comparator;

/*
Given a collection of intervals, find the minimum number of intervals you need
to remove to make the rest of the intervals non-overlapping.
 */
public class NonoverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // Sort the intervals based on their starting point.
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int num = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                // If the starting point of the current interval is before
                // the ending point of previous interval, it means they overlap.
                // We need to choose which one to remove. We choose to remove
                // the one with higher end value so the other one has lower
                // chance of overlapping with the remaining intervals.
                end = Math.min(end, intervals[i][1]);
                num++;
            } else {
                // No overlap. Update the end.
                end = intervals[i][1];
            }
        }
        return num;
    }
}
