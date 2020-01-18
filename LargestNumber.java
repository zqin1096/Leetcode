import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
Given a list of non negative integers, arrange them such that they form the
largest number.
 */
public class LargestNumber {

    // DFS. TLE.
//    String max = null;
//
//    public String largestNumber(int[] nums) {
//        List<Integer> list = new LinkedList<>();
//        for (int i : nums) {
//            list.add(i);
//        }
//        dfs(list, "");
//        return max;
//    }
//
//    private void dfs(List<Integer> nums, String s) {
//        if (nums.size() == 0) {
//            if (max == null) {
//                max = s;
//            } else {
//                max = s.compareTo(max) >= 0 ? s : max;
//            }
//        }
//        for (int i = 0; i < nums.size(); i++) {
//            int val = nums.get(i);
//            nums.remove(i);
//            dfs(nums, s + val);
//            nums.add(i, val);
//        }
//    }

    // Sorting.
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] values = new String[nums.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(values, new Comparator<String>() {
            @Override
            // Sort the array in decreasing order.
            // str1 = o1 + o2;
            // str2 = o2 + o1;
            // return str2.compareTo(str1);
            public int compare(String o1, String o2) {
                // Choose 2 values and concatenate them in 2 orders. Compare
                // which one is larger.
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        if (values[0].charAt(0) == '0') {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : values) {
            sb.append(s);
        }
        return sb.toString();
    }
}
