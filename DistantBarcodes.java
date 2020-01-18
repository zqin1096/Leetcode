import java.util.*;

/*
In a warehouse, there is a row of barcodes, where the i-th barcode is
barcodes[i].

Rearrange the barcodes so that no two adjacent barcodes are equal.  You may
return any answer, and it is guaranteed an answer exists.

 */
public class DistantBarcodes {
    // Similar to task schedule with n = 1.
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : barcodes) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        return o2.getValue() - o1.getValue();
                    }
                });
        pq.addAll(map.entrySet());
        int[] result = new int[barcodes.length];
        int i = 0;
        while (!pq.isEmpty()) {
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
            for (int j = 0; j <= 1; j++) {
                // If all barcodes are assigned, end the loop.
                if (i >= barcodes.length) {
                    break;
                }
                Map.Entry<Integer, Integer> entry = pq.remove();
                result[i] = entry.getKey();
                i++;
                entry.setValue(entry.getValue() - 1);
                if (entry.getValue() != 0) {
                    list.add(entry);
                }
            }
            for (Map.Entry<Integer, Integer> pair : list) {
                pq.add(pair);
            }
        }
        return result;
    }
}
