import java.util.*;

/*
Given a collection of numbers that might contain duplicates, return all
possible unique permutations.
 */
public class PermutationsII {
    // Backtracking.
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }
        dfs(0, nums, lists);
        return lists;
    }

    // Find the permutation by swapping elements.
    private void dfs(int index, int[] nums, List<List<Integer>> lists) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            lists.add(list);
            return;
        }
        // If an element is already in the set, meaning it has been the first
        // element, then skip it.
        Set<Integer> set = new HashSet<>();
        // At the current level of the recursion, swap the first element with
        // every elements (including itself).
        for (int i = index; i < nums.length; i++) {
            if (set.add(nums[i])) {
                swap(nums, index, i);
                // The first element in the next level of recursion is at
                // position index + 1.
                dfs(index + 1, nums, lists);
                swap(nums, index, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
