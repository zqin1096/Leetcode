public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        return traversal(root, L, R);
    }

    private int traversal(TreeNode node, int L, int R) {
        if (node == null) {
            return 0;
        }
        if (node.val < L) {
            return traversal(node.right, L, R);
        } else if (node.val > R) {
            return traversal(node.left, L, R);
        } else {
            return node.val + traversal(node.left, L, R) + traversal(node.right, L, R);
        }
    }
}
