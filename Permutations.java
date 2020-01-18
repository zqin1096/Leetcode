import java.util.LinkedList;
import java.util.List;

/*
Given a collection of distinct integers, return all possible permutations.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        for (int i : nums) {
            list.add(i);
        }
        List<Integer> permutation = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            permutation.add(list.get(i));
            int num = list.remove(i);
            permute(result, permutation, list);
            list.add(i, num);
            permutation.remove(permutation.size() - 1);
        }
        return result;
    }

    private void permute(List<List<Integer>> result,
                         List<Integer> permutation, List<Integer> list) {
        if (list.size() == 0) {
            List<Integer> copy = new LinkedList<>(permutation);
            result.add(copy);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            permutation.add(list.get(i));
            int num = list.remove(i);
            permute(result, permutation, list);
            list.add(i, num);
            permutation.remove(permutation.size() - 1);
        }
    }
}
