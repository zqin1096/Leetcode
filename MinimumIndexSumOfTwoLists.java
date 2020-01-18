import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }
        List<String> restaurants = new LinkedList<>();
        int leastSum = list1.length + list2.length;
        for (String s : list1) {
            if (map2.containsKey(s)) {
                if (map1.get(s) + map2.get(s) < leastSum) {
                    restaurants.clear();
                    restaurants.add(s);
                    leastSum = map1.get(s) + map2.get(s);
                } else if (map1.get(s) + map2.get(s) == leastSum) {
                    restaurants.add(s);
                }
            }
        }
        return restaurants.toArray(new String[restaurants.size()]);
    }
}
