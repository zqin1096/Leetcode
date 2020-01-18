public class PeakIndexInAMountainArray {
    // Binary search.
    public int peakIndexInMountainArray(int[] A) {
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] < A[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
