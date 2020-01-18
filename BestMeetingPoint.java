import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
A group of two or more people wants to meet and minimize the total travel
distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home
of someone in the group. The distance is calculated using Manhattan Distance,
where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 */
public class BestMeetingPoint {
    // Meeting point can be home.
    public int minTotalDistance(int[][] grid) {
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        return minDistance(row) + minDistance(col);
    }

    private int minDistance(List<Integer> list) {
        Collections.sort(list);
        int low = 0;
        int high = list.size() - 1;
        int res = 0;
        while (low < high) {
            res += list.get(high--) - list.get(low++);
        }
        return res;
    }
}
/*
One dimension:
A   P   B
As long as the meeting point is between A and B, the total travel distance is
the distance between A and B.

C   A   P   B   D
The best meeting point is between A and B. The total travel distance is AB + CD.
We can sort the position, and calculate the distance between 1, n and 2, n -
1 ... and so on, until reach the mid point.

For two dimension, we can solve it by dividing it to 2 one dimensions (row
and col).
 */