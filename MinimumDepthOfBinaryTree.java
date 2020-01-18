public class MinimumDepthOfBinaryTree {
    int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        minDepth(root, 1);
        return min;
    }

    private void minDepth(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            min = Math.min(depth, min);
        } else if (node.left != null && node.right == null) {
            minDepth(node.left, depth + 1);
        } else if (node.left == null && node.right != null) {
            minDepth(node.right, depth + 1);
        } else {
            minDepth(node.left, depth + 1);
            minDepth(node.right, depth + 1);
        }
    }
}
