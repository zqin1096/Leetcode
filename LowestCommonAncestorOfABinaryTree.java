import java.util.List;

/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
in the tree.
 */
public class LowestCommonAncestorOfABinaryTree {
    // Recursion.
    // Draw a graph.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Find p or q. Return null if not found. Take care of the case when
        // one node is the ancestor of the another node. In this case, the
        // LCA is the ancestor.
        if (root == null || root == p || root == q) {
            return root;
        }
        // Recursively search p and q in left and right subtrees.
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // The root has to be the LCA if p and q are found in both of its
        // subtrees.
        if (left != null && right != null) {
            return root;
        }
        // If either left or right is null, then p and q are in the same
        // subtree.
        // Or it could mean that p or q is found in a subtree. Return it
        // until when a root found both left and right are not null, which
        // means p and q are found in left and right subtrees, respectively.
        if (left != null) {
            return left;
        } else {
            return right;
        }
    }
}
