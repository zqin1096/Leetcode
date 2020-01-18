import java.util.HashMap;
import java.util.Map;

public class TwoSumIVInputIsABST {
    public boolean findTarget(TreeNode root, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        return traverse(root, k, map);
    }

    private boolean traverse(TreeNode node, int k, Map<Integer, Integer> map) {
        if (node == null) {
            return false;
        }
        boolean left = traverse(node.left, k, map);
        if (map.containsKey(node.val)) {
            return true;
        } else {
            map.put(k - node.val, node.val);
        }
        boolean right = traverse(node.right, k, map);
        return left || right;
    }
}
