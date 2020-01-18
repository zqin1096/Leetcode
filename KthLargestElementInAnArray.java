import java.util.Comparator;
import java.util.PriorityQueue;

/*
Find the kth largest element in an unsorted array. Note that it is the kth
largest element in the sorted order, not the kth distinct element.
 */
public class KthLargestElementInAnArray {
    // Another solution: sort.
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i : nums) {
            pq.add(i);
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = pq.remove();
        }
        return res;
    }
}
