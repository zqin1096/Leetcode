/*
Given the root of a binary tree, find the maximum value V for which there exists
different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.
 */
public class MaximumDifferenceBetweenNodeAndAncestor {
    public int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiff(root, root.val, root.val);
    }

    // Since V is the max absolute value, it does not matter where A and B are.
    // Just find max and min.
    private int maxAncestorDiff(TreeNode node, int max, int min) {
        // Return the max value for this path (from root to this leaf).
        if (node == null) {
            return Math.abs(max - min);
        }
        int maximum = Math.max(max, node.val);
        int minimum = Math.min(min, node.val);
        // Take the larger value from 2 paths.
        return Math.max(maxAncestorDiff(node.left, maximum, minimum),
                maxAncestorDiff(node.right, maximum, minimum));
    }
}
