import java.util.Arrays;
import java.util.Comparator;

/*
Given an array of meeting time intervals consisting of start and end times
[[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all
meetings.
 */
public class MeetingRooms {
    // Similar to 56 (Merge Intervals).
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int end = intervals[0][1];
        // Check if the next start is before the current end (if current
        // start is before the previous end).
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                return false;
            } else {
                end = intervals[i][1];
            }
        }
        return true;
    }
}
