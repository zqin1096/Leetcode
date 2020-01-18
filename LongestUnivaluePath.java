/*
Given a binary tree, find the length of the longest path where each node in the
path has the same value. This path may or may not pass through the root.
 */
public class LongestUnivaluePath {
    // The length of longest path.
    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        univaluePath(root);
        return max;
    }

    // The length of longest path of left/right subtree.
    public int univaluePath(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // The longest length of left path.
        int l = 0;
        // The longest length of right path.
        int r = 0;
        if (node.left != null && node.val == node.left.val) {
            l = 1 + univaluePath(node.left);
        } else {
            univaluePath(node.left);
        }
        if (node.right != null && node.val == node.right.val) {
            r = 1 + univaluePath(node.right);
        } else {
            univaluePath(node.right);
        }
        // Calculate the max.
        max = Math.max(max, l + r);
        // Only return the longer path to its parent which can be used by its
        // grandparent.
        return Math.max(l, r);
    }
}
