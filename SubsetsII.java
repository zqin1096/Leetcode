import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Given a collection of integers that might contain duplicates, nums, return all
possible subsets (the power set).
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new LinkedList<>();
        subsetsWithDup(nums, result, subset, 0);
        return result;
    }

    private void subsetsWithDup(int[] nums, List<List<Integer>> result,
                                List<Integer> subset, int start) {
        result.add(new LinkedList<>(subset));
        // 先往广了搜索.
        // 0, 01, 012, 0123, ..., 1, 12, 123, ... eg. If the number at index
        // 1 is the same as the number at index 0, search skip it since it has
        // been added.
        for (int i = start; i < nums.length; i++) {
            // Skip if current element is the same as the previous element. The
            // subset has been added.
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            subsetsWithDup(nums, result, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
