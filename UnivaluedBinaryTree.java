public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        int value = root.val;
        return traversal(root, value);
    }

    private boolean traversal(TreeNode node, int val) {
        if (node == null) {
            return true;
        }
        return node.val == val && traversal(node.left, val) && traversal(node.right, val);
    }
}
