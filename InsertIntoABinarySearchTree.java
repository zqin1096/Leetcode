import jdk.nashorn.api.tree.Tree;

public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insert(root, val);
    }

    private TreeNode insert(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val < node.val) {
            // New left subtree.
            node.left = insertIntoBST(node.left, val);
        } else {
            node.right = insertIntoBST(node.right, val);
        }
        return node;
    }
}
