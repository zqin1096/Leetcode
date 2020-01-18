import java.util.Arrays;
import java.util.Map;

/*
Given an array A of integers and integer K, return the maximum S such that
there exists i < j with A[i] + A[j] = S and S < K. If no i, j exist satisfying
this equation, return -1.
 */
public class TwoSumLessThanK {
    public int twoSumLessThanK(int[] A, int K) {
        // Sort the array and search from 2 ends.
        Arrays.sort(A);
        int i = 0;
        int j = A.length - 1;
        int max = -1;
        while (i < j) {
            // i < j simply means that we need 2 different numbers (i and j
            // represents the indices).
            if (A[i] + A[j] < K) {
                max = Math.max(max, A[i] + A[j]);
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
