/*
Given a rooted binary tree, return the lowest common ancestor of its deepest
leaves.
 */
public class LowestCommonAncestorOfDeepestLeaves {
    // Similar to 236.
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int depth = depth(root);
        return lca(root, depth);
    }

    private TreeNode lca(TreeNode root, int depth) {
        // No deepest leaf is found.
        if (root == null) {
            return null;
        }
        // If depth is 1, it means a deepest node is found.
        if (depth == 1) {
            return root;
        }
        TreeNode left = lca(root.left, depth - 1);
        TreeNode right = lca(root.right, depth - 1);
        // If both left and right are not null, it means there are deepest
        // leaves in both left and right subtrees.
        if (left != null && right != null) {
            return root;
        }
        // Otherwise, return the reference of the subtree that contains
        // deepest leaves.
        if (left != null) {
            return left;
        } else {
            return right;
        }
    }

    // Find the deepest depth of the tree. Use this depth to find the deepest
    // leaves.
    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(depth(node.left), depth(node.right));
    }
}
