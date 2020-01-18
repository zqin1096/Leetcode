public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {
        int low = 0;
        int high = A.length - 1;
        // Assign the result at the current index of the result.
        int current = A.length - 1;
        int[] result = new int[A.length];
        while (low <= high) {
            // Compare the numbers at index low and index high.
            if (Math.abs(A[low]) >= Math.abs(A[high])) {
                result[current] = A[low] * A[low];
                low++;
                current--;
            } else {
                result[current] = A[high] * A[high];
                high--;
                current--;
            }
        }
        return result;
    }
}
