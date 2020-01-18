public class SumOfEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] result = new int[queries.length];
        int evenSum = 0;
        for (int i = 0; i < A.length; i++) {
            evenSum += (A[i] % 2 == 0) ? A[i] : 0;
        }
        for (int i = 0; i < A.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            if (A[index] % 2 == 0 && val % 2 == 0) {
                evenSum += val;
            } else if (A[index] % 2 == 0 && val % 2 != 0) {
                evenSum -= A[index];
            } else if (A[index] % 2 != 0 && val % 2 == 0) {
                // If A[index] is odd, then it was not added to evenSum.
            } else {
                evenSum += (A[index] + val);
            }
            A[index] += val;
            result[i] = evenSum;
        }
        return result;
    }
}
