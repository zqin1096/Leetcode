import java.util.*;

/*
Given a collection of candidate numbers (candidates) and a target number
(target), find all unique combinations in candidates where the candidate
numbers sums to target.
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates,
                                               int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        dfs(result, list, target, 0, 0, candidates);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list,
                     int target, int sum, int index, int[] candidates) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            if (result.size() == 0) {
                result.add(new LinkedList<>(list));
                return;
            }
            // Check if it is duplicate.
            for (int i = 0; i < result.size(); i++) {
                boolean flag = true;
                int length = Math.min(result.get(i).size(), list.size());
                for (int j = 0; j < length; j++) {
                    flag = result.get(i).get(j) == list.get(j);
                    if (!flag) {
                        break;
                    }
                }
                if (flag) {
                    return;
                }
            }
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(result, list, target, sum + candidates[i], i + 1,
                    candidates);
            list.remove(list.size() - 1);
        }
    }
}
