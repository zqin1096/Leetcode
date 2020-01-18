public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] A) {
        int result = 0;
        // i represents the ith index.
        for (int i = 0; i < A[0].length(); i++) {
            char c = 'a';
            // j represents the jth string.
            for (int j = 0; j < A.length; j++) {
                if (A[j].charAt(i) >= c) {
                    c = A[j].charAt(i);
                } else {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
