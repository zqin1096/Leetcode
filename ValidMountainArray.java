public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length == 0 || A.length == 1) {
            return false;
        }
        boolean isClimbing = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i + 1] > A[i]) {
                if (isClimbing) {
                    continue;
                } else {
                    return false;
                }
            } else if (A[i + 1] < A[i]) {
                if (i == 0) {
                    return false;
                }
                if (isClimbing) {
                    isClimbing = false;
                } else {
                    continue;
                }
            } else {
                return false;
            }
        }
        // isClimbing must be false in the end.
        return !isClimbing;
    }
}
