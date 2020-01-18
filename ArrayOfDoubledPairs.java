import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayOfDoubledPairs {
    public boolean canReorderDoubled(int[] A) {
        // Sort the array.
        Arrays.sort(A);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }
        }
        for (int i = 0; i < A.length; i++) {
            // If the element is negative, find the number of A[i] / 2.
            if (A[i] < 0) {
                if (map.getOrDefault(A[i], 0) != 0) {
                    if (Math.abs(A[i]) % 2 != 0) {
                        return false;
                    } else {
                        if (map.get(A[i]) > map.getOrDefault(A[i] / 2, 0)) {
                            return false;
                        } else {
                            map.put(A[i] / 2, map.get(A[i] / 2) - map.get(A[i]));
                            if (map.get(A[i] / 2) == 0) {
                                map.remove(A[i] / 2);
                            }
                            map.remove(A[i]);
                        }
                    }
                }
            } else if (A[i] > 0) {
                if (map.getOrDefault(A[i], 0) != 0) {
                    if (map.get(A[i]) > map.getOrDefault(A[i] * 2, 0)) {
                        return false;
                    } else {
                        // If the number is positive, find the number of A[i] * 2.
                        map.put(A[i] * 2, map.get(A[i] * 2) - map.get(A[i]));
                        if (map.get(A[i] * 2) == 0) {
                            map.remove(A[i] * 2);
                        }
                        map.remove(A[i]);
                    }
                }
            } else {
                // If the element is zero.
                if (map.getOrDefault(A[i], 0) % 2 != 0) {
                    return false;
                } else {
                    map.remove(A[i]);
                }
            }
        }
        return map.size() == 0;
    }
}
