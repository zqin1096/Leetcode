import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class IntervalListIntersections {
    // Two pointers.
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        int index1 = 0;
        int index2 = 0;
        List<Interval> list = new LinkedList<>();
        while (index1 < A.length && index2 < B.length) {
            // Check if A[index1] intersects B[index2].
            // The starting point of the intersection.
            int start = Math.max(A[index1].start, B[index2].start);
            // The ending point of the intersection.
            int end = Math.min(A[index1].end, B[index2].end);
            if (start <= end) {
                list.add(new Interval(start, end));
            }
            // Compare the ending point.
            if (A[index1].end < B[index2].end) {
                index1++;
            } else {
                index2++;
            }
        }
        return list.toArray(new Interval[list.size()]);
    }
}
