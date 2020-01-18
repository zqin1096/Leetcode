import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int totalA = 0;
        int totalB = 0;
        for (int i = 0; i < A.length; i++) {
            totalA += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            totalB += B[i];
        }
        // totalA - x + y = totalB - y + x.
        // y = x + (totalB - totalA) / 2.
        // If Alice gives x, she should receive x + (totalB - totalA) / 2.
        Set<Integer> setB = new HashSet<Integer>();
        for (int i = 0; i < B.length; i++) {
            setB.add(B[i]);
        }
        for (int x : A) {
            if (setB.contains(x + (totalB - totalA) / 2)) {
                return new int[]{x, x + (totalB - totalA) / 2};
            }
        }
        throw new IllegalArgumentException();
    }
}
