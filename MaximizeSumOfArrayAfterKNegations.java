import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given an array A of integers, we must modify the array in the following way: we
choose an i and replace A[i] with -A[i], and we repeat this process K times in
total.  (We may choose the same index i multiple times.)

Return the largest possible sum of the array after modifying it in this way.
 */
public class MaximizeSumOfArrayAfterKNegations {
    public static int largestSumAfterKNegations(int[] A, int K) {
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : A) {
            pq.add(i);
        }
        // Take the min element and replace it with -min. Add -min back to
        // priority queue.
        for (int i = 0; i < K; i++) {
            int min = pq.remove();
            sum = sum - min + (-min);
            pq.add(-min);
        }
        return sum;
    }
}
