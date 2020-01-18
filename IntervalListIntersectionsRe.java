import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Given two lists of closed intervals, each list of intervals is pairwise
disjoint and in sorted order.

Return the intersection of these two interval lists.
 */
public class IntervalListIntersectionsRe {
    // Problem revisited.
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A.length == 0 && B.length == 0) {
            return new int[0][];
        }
        List<int[]> list = new ArrayList<>();
        for (int[] interval : A) {
            list.add(interval);
        }
        for (int[] interval : B) {
            list.add(interval);
        }
        // Sort all intervals from A and B.
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> intersections = new ArrayList<>();
        int end = list.get(0)[1];
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i)[0] <= end) {
                intersections.add(new int[]{list.get(i)[0], Math.min(end,
                        list.get(i)[1])});
                end = Math.max(end, list.get(i)[1]);
            } else {
                end = list.get(i)[1];
            }
        }
        int[][] result = new int[intersections.size()][2];
        for (int i = 0; i < intersections.size(); i++) {
            result[i][0] = intersections.get(i)[0];
            result[i][1] = intersections.get(i)[1];
        }
        return result;
    }
}
