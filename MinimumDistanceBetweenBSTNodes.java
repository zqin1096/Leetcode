import java.util.LinkedList;
import java.util.List;

public class MinimumDistanceBetweenBSTNodes {

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> list = new LinkedList<>();
        inOrder(root, list);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        return min;
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
}
