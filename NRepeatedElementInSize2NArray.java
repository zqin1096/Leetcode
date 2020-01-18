import java.util.HashMap;
import java.util.Map;

public class NRepeatedElementInSize2NArray {
    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                return A[i];
            } else {
                map.put(A[i], 1);
            }
        }
        throw new IllegalArgumentException();
    }
}
