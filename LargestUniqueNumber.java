import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers A, return the largest integer that only occurs once.
If no integer occurs once, return -1.
 */
public class LargestUniqueNumber {
    public int largestUniqueNumber(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int largest = -1;
        for (int key : map.keySet()) {
            if (map.get(key) == 1 && key > largest) {
                largest = key;
            }
        }
        return largest;
    }
}
