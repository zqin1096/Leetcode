import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given an integer array, your task is to find all the different possible
increasing subsequences of the given array, and the length of an increasing
subsequence should be at least 2.
 */
public class IncreasingSubsequences {
    Set<String> set = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findSubsequences(nums, new ArrayList<>(), result, "", 0);
        return result;
    }

    private void findSubsequences(int[] nums, List<Integer> list,
                                  List<List<Integer>> result, String s,
                                  int index) {
        if (list.size() > 1 && !set.contains(s)) {
            set.add(s);
            result.add(new ArrayList<>(list));
        }
        for (int i = index; i < nums.length; i++) {
            if (list.size() == 0 || nums[i] >= list.get(list.size() - 1)) {
                list.add(nums[i]);
                findSubsequences(nums, list, result, s + " " + nums[i], i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
