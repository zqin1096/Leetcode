/*
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting
node to any node in the tree along the parent-child connections. The path must
contain at least one node and does not need to go through the root.
 */
public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }

    private int maxPath(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // Calculate the left sum and the right sum.
        int left = maxPath(node.left);
        int right = maxPath(node.right);
        // Add the root to form a path.
        int sum = node.val + left + right;
        // Take the max sum.
        max = Math.max(max, sum);
        // If the sum of both branches (left + root, right + root) are
        // negative, then return 0 (do not use them).
        if ((left + node.val < 0) && (right + node.val < 0)) {
            return 0;
        } else {
            // return the higher branch.
            return left >= right ? left + node.val : right + node.val;
        }
    }
}
