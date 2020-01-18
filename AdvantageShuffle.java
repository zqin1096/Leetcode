import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AdvantageShuffle {
    // First satisfy the biggest element of B since they are the hardest to satisfy.
    // If the biggest value of A cannot satisfy current value of B, then nothing can satisfy.
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int[] ans = new int[A.length];
        // The first element is the value, and the second element is the index of the value in B.
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < B.length; i++) {
            pq.add(new int[]{B[i], i});
        }
        int low = 0;
        int high = B.length - 1;
        while (!pq.isEmpty()) {
            // Current biggest element in B.
            int[] b = pq.remove();
            if (A[high] > b[0]) {
                ans[b[1]] = A[high--];
            } else {
                ans[b[1]] = A[low++];
            }
        }
        return ans;
    }
}
