/*
Given a root node reference of a BST and a key, delete the node with the given
key in the BST. Return the root node reference (possibly updated) of the BST.

 */
public class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, key);
    }

    private TreeNode delete(TreeNode node, int key) {
        if (node == null) {
            return null;
        }
        if (node.val == key) {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null || node.right == null) {
                if (node.left == null) {
                    // Return the node's right child to be the child of
                    // node's parent.
                    return node.right;
                } else {
                    return node.left;
                }
            } else {
                TreeNode right = node.right;
                while (right.left != null) {
                    right = right.left;
                }
                node.val = right.val;
                // Delete the node with value right.val from the right subtree.
                node.right = delete(node.right, node.val);
            }
        } else if (node.val > key) {
            node.left = delete(node.left, key);
        } else {
            node.right = delete(node.right, key);
        }
        return node;
    }
}
