/*
Given an array A of distinct integers sorted in ascending order, return the
smallest index i that satisfies A[i] == i.  Return -1 if no such i exists.
 */
public class FixedPoint {
    public int fixedPoint(int[] A) {
        int low = 0;
        int high = A.length - 1;
        // low and high may have the same value.
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == mid) {
                return mid;
            } else if (mid < A[mid]) {
                // If index is smaller than its corresponding value, then i
                // must be at the first half of the array. The values will
                // always be larger than their corresponding indexes in the
                // second half of the array.
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
