/*
Given a binary tree, flatten it to a linked list in-place.
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        traverse(root);
    }

    // Recursively flatten the subtrees.
    private TreeNode traverse(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = traverse(node.left);
        TreeNode right = traverse(node.right);
        if (left == null && right == null) {
            return node;
        }
        if (left != null) {
            // Set the left subtree to null. Set the flattened left subtree
            // to be its right child.
            node.left = null;
            node.right = left;
            while (left.right != null) {
                left = left.right;
            }
            left.right = right;
        }
        return node;
    }
}
