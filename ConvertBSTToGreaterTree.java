import java.util.LinkedList;
import java.util.List;

public class ConvertBSTToGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<TreeNode> nodes = new LinkedList<>();
        // Inorder traversal gives the nodes in ascending order.
        inOrder(root, nodes);
        int[] sums = new int[nodes.size() + 1];
        sums[0] = 0;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nodes.get(i - 1).val;
        }
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).val =
                    nodes.get(i).val + sums[sums.length - 1] - sums[i + 1];
        }
        return root;
    }

    private void inOrder(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node);
        inOrder(node.right, list);
    }
}
