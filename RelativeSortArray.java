import java.util.*;
import java.util.stream.Collectors;

/*
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all
elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are
the same as in arr2.  Elements that don't appear in arr2 should be placed at
the end of arr1 in ascending order.
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Elements and their corresponding indices in arr2.
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        // list1 contains the elements that are in arr2.
        List<Integer> list1 = new ArrayList<>();
        // list2 contains the elements that are not in arr2.
        List<Integer> list2 = new ArrayList<>();
        for (int i : arr1) {
            if (map.containsKey(i)) {
                list1.add(i);
            } else {
                list2.add(i);
            }
        }
        // Sort both lists.
        Collections.sort(list1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        Collections.sort(list2);
        int index = 0;
        for (int i = 0; i < list1.size(); i++) {
            arr1[index++] = list1.get(i);
        }
        for (int i = 0; i < list2.size(); i++) {
            arr1[index++] = list2.get(i);
        }
        return arr1;
    }
}
