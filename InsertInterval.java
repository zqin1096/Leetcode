import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Given a set of non-overlapping intervals, insert a new interval into the
intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their
start times.
 */
public class InsertInterval {
    // Add the new interval and other intervals to a list. Sort them according
    // to their start times, and merge them (Leetcode 56).
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        list.add(newInterval);
        for (int i = 0; i < intervals.length; i++) {
            list.add(intervals[i]);
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int start = list.get(0)[0];
        int end = list.get(0)[1];
        List<int[]> merge = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i)[0] <= end) {
                end = Math.max(end, list.get(i)[1]);
            } else {
                merge.add(new int[]{start, end});
                start = list.get(i)[0];
                end = list.get(i)[1];
            }
        }
        merge.add(new int[]{start, end});
        int[][] result = new int[merge.size()][2];
        for (int i = 0; i < merge.size(); i++) {
            result[i][0] = merge.get(i)[0];
            result[i][1] = merge.get(i)[1];
        }
        return result;
    }
}
