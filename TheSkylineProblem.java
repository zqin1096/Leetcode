import java.util.*;

/*
A city's skyline is the outer contour of the silhouette formed by all the
buildings in that city when viewed from a distance. Now suppose you are given
the locations and height of all the buildings as shown on a cityscape photo
(Figure A), write a program to output the skyline formed by these buildings
collectively (Figure B).

The geometric information of each building is represented by a triplet of
integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left
and\right edge of the ith building, respectively, and Hi is its height. It
is\guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You
may assume all buildings are perfect rectangles grounded on an absolutely flat
surface at height 0.

The output is a list of "key points" (red dots in Figure B) in the format of
[ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key
point is the left endpoint of a horizontal line segment. Note that the last key
point, where the rightmost building ends, is merely used to mark the
termination of the skyline, and always has zero height. Also, the ground in
between any two adjacent buildings should be considered part of the skyline
contour.

 */
public class TheSkylineProblem {
    // The key points are at either the starts or the ends of the buildings.
    // So we get all the starting and ending coordinates and their
    // corresponding heights. Sort them in increasing order by their x
    // coordinates (left to right) and traverse them from left to right. If
    // we encounter a starting point and its corresponding height is larger
    // than the current maximum height, then it has to be a key point (If <=,
    // then do nothing). If we encounter a ending point and it has the
    // maximum height, then the x coordinate that has the second maximum
    // height is a key point. And we need to update the maximum height since
    // the building that has the maximum height is gone.
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> coordinates = new ArrayList<>();
        for (int[] building : buildings) {
            // x coordinate of the left edge of the building and its height.
            // 0 indicates this is the left (starting) edge.
            int[] start = new int[]{building[0], building[2], 1};
            // x coordinate of the right edge of the building and its height.
            // 1 indicates this is the right edge.
            int[] end = new int[]{building[1], building[2], 0};
            coordinates.add(start);
            coordinates.add(end);
        }
        Collections.sort(coordinates, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    // Corner cases. Avoid adding redundant key points (draw
                    // some graphs if do not understand).
                    if (o1[2] == 1 && o2[2] == 1) {
                        // If two starting points have the same x
                        // coordinates, put the one with larger height before
                        // the one with lower height.
                        return o2[1] - o1[1];
                    } else if (o1[2] == 0 && o2[2] == 0) {
                        // If two ending points have the same x
                        // coordinates, put the one with lower height before
                        // the one with higher height.
                        return o1[1] - o2[1];
                    } else {
                        // If a starting point and an ending point have the
                        // same x coordinate, then put the starting point
                        // before the ending point.
                        return -(o1[2] - o2[2]);
                    }
                } else {
                    // Sort the coordinates by their x coordinate.
                    return o1[0] - o2[0];
                }
            }
        });
        for (int i = 0; i < coordinates.size(); i++) {
            System.out.println(coordinates.get(i)[0] + " " + coordinates.get(i)[1] + " " + coordinates.get(i)[2]);
        }
        // Store the heights of the buildings. Sort them in decreasing order.
        PriorityQueue<Integer> heights = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int max = 0;
        heights.add(0);
        List<List<Integer>> result = new ArrayList<>();
        for (int[] coordinate : coordinates) {
            if (coordinate[2] == 1) {
                if (coordinate[1] > max) {
                    List<Integer> key = new ArrayList<>();
                    key.add(coordinate[0]);
                    key.add(coordinate[1]);
                    result.add(key);
                    max = coordinate[1];
                }
                heights.add(coordinate[1]);
            } else {
                // Remove the height first, then check if the maximum height
                // changes.
                heights.remove(coordinate[1]);
                if (max != heights.peek()) {
                    List<Integer> key = new ArrayList<>();
                    key.add(coordinate[0]);
                    key.add(heights.peek());
                    result.add(key);
                    max = heights.peek();
                }
            }
        }
        return result;
    }
}
