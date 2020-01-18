public class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int quotient = sum / 3;
        int i = 0;
        int temp = 0;
        for (; i < A.length - 2; ) {
            temp += A[i];
            i++;
            if (temp == quotient) {
                break;
            }
        }
        temp = 0;
        for (; i < A.length - 1; ) {
            temp += A[i];
            i++;
            if (temp == quotient) {
                break;
            }
        }
        temp = 0;
        for (; i < A.length; i++) {
            temp += A[i];
        }
        return temp == quotient;
    }
}
