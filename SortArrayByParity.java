/*
Given an array A of non-negative integers, return an array consisting of all
the even elements of A, followed by all the odd elements of A.
You may return any answer array that satisfies this condition.
 */
public class SortArrayByParity {
    // Similar to Move Zeros.
    public int[] sortArrayByParity(int[] A) {
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                j++;
            }
        }
        return A;
    }
}
