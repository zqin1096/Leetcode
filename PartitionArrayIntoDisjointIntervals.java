import javax.rmi.ssl.SslRMIClientSocketFactory;

public class PartitionArrayIntoDisjointIntervals {
    public static int partitionDisjoint(int[] A) {
        int minIndex = 0;
        // Find the index of the minimum number in A.
        for (int i = 0; i < A.length; i++) {
            minIndex = A[i] < A[minIndex] ? i : minIndex;
        }
        // Find the largest number before index minIndex in A.
        int largestUntilMinIndex = Integer.MIN_VALUE;
        for (int i = 0; i < minIndex; i++) {
            if (A[i] > largestUntilMinIndex) {
                largestUntilMinIndex = A[i];
            }
        }
        // The largest number after minIndex in A.
        int largestAfterMinIndex = A[minIndex + 1];
        // The best case scenario is to partition the array into [0, minIndex] and [minIndex + 1, A.length - 1].
        int partition = minIndex;
        for (int i = minIndex + 1; i < A.length; i++) {
            if (A[i] < largestUntilMinIndex) {
                // If this element is less than largestUntilMinIndex, this element should be included in left.
                partition = i;
                // A may have element that is larger than largestUntilMinIndex and before this element A[i]. Since that
                // element is now included in left, largestUntilMinIndex need to be updated.
                largestUntilMinIndex = Math.max(largestAfterMinIndex, largestUntilMinIndex);
            } else {
                // Every element in right should be larger than or equal to every element in left. It means that every
                // element in right should be larger than the current largestUntilMinIndex.
                // Update the largest number after minIndex in A.
                largestAfterMinIndex = Math.max(largestAfterMinIndex, A[i]);
            }
        }
        return partition + 1;
    }
}
