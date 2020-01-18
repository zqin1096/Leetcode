import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/*
Given an array of meeting time intervals consisting of start and end times
[[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
required.
 */
public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int num = 1;
        // Get the starting points and the ending points.
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        // Sort them in ascending order.
        Arrays.sort(starts);
        Arrays.sort(ends);
        int end = ends[0];
        int j = 1;
        for (int i = 1; i < starts.length; i++) {
            if (starts[i] < end) {
                num++;
            } else {
                end = ends[j];
                j++;
            }
        }
        return num;
    }

    // Another solution.
//    public int minMeetingRooms(int[][] intervals) {
//        // It is necessary to use TreeMap (time sequence).
//        Map<Integer, Integer> m = new TreeMap<>();
//        for (int[] t : intervals) {
//            // At time t[0], a meeting starts, we need a room (+1).
//            m.put(t[0], m.getOrDefault(t[0], 0) + 1);
//            // At time t[1], this meeting ends, we do not need this room (-1).
//            m.put(t[1], m.getOrDefault(t[1], 0) - 1);
//        }
//        int res = 0, cur = 0;
//        for (int v : m.values()) {
//            // cur represents the number of rooms needed at a certain time
//            // point. We need to track its maximum value.
//            res = Math.max(res, cur += v);
//        }
//        return res;
//    }
}
/*
[2, 15], [4, 9], [16, 23], [9, 23], [36, 45]

start   end
2       9
4       15
9       23
16      23
36      45

Start from 4, we already have 2 meetings (2, 4), But they are both before the
 earliest ending time, which is 9. So we need 2 rooms. The starting time of
 the next meeting is 9, which is >= the first ending time (9). It means one
 previous meeting is over and we can reuse that room, so we do not need an
 extra room. And since that meeting is over, we can change "end" to the next
 earliest ending time.

 Compare the starting time with the earliest ending time in every iteration.
 If the starting time is before the earliest ending time, it means we need a
 another room. If the starting time is >= the earliest ending time, it means
 the meetings have no overlap and we can reuse the room. Then we need to
 update the earliest ending time to the next smallest one.
 */
