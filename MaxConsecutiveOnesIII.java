/*
Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

Return the length of the longest (contiguous) subarray that contains only 1s.
 */
public class MaxConsecutiveOnesIII {
    // Two pointers.
    public int longestOnes(int[] A, int K) {
        int start = 0;
        int flip = 0;
        int end = 0;
        int max = 0;
        // Move end if flip is less than K or A[end] = 1.
        while (end < A.length) {
            if (A[end] == 1) {
                end++;
            } else {
                if (flip < K) {
                    flip++;
                    end++;
                } else {
                    max = Math.max(max, end - start);
                    // Move start to the position after first zero.
                    if (A[start] == 0) {
                        flip--;
                    }
                    start++;
                }
            }
        }
        max = Math.max(max, end - start);
        return max;
    }
}
