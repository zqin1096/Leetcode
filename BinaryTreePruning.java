import jdk.nashorn.api.tree.Tree;

/*
We are given the head node root of a binary tree, where additionally every
node's value is either a 0 or a 1.

Return the same tree where every subtree (of the given tree) not containing a 1
has been removed.
 */
public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // If a leaf node is 0, then prune it.
        if (root.val == 0 && (root.left == null && root.right == null)) {
            return null;
        } else {
            // Otherwise, call pruneTree recursively on root's left and right
            // subtrees.
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
            // Check if this node becomes a leaf node with value 0.
            if (root.val == 0 && root.left == null && root.right == null) {
                return null;
            }
        }
        return root;
    }
}
