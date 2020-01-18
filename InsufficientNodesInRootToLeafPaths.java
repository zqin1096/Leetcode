/*
Given the root of a binary tree, consider all root to leaf paths: paths from
the root to any leaf.  (A leaf is a node with no children.)

A node is insufficient if every such root to leaf path intersecting this node
has sum strictly less than limit.

Delete all insufficient nodes simultaneously, and return the root of the
resulting binary tree.
 */
public class InsufficientNodesInRootToLeafPaths {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return sufficientSubset(root, limit, root.val);
    }

    private TreeNode sufficientSubset(TreeNode node, int limit, int sum) {
        // Traverse to the leaf, if the sum is less than the limit, then
        // delete the leaf.
        if (node.left == null && node.right == null) {
            if (sum < limit) {
                return null;
            } else {
                return node;
            }
        }
        if (node.left != null) {
            node.left = sufficientSubset(node.left, limit, sum + node.left.val);
        }
        if (node.right != null) {
            node.right = sufficientSubset(node.right, limit,
                    sum + node.right.val);
        }
        // If a node becomes a leaf, then it means the node is on the
        // insufficient path, and it needs to be deleted.
        if (node.left == null && node.right == null) {
            return null;
        }
        return node;
    }
}
