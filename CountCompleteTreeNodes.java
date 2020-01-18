/*
Given a complete binary tree, count the number of nodes.
 */
public class CountCompleteTreeNodes {
    // Complexity O(n).
//    public int countNodes(TreeNode root) {/**/
//        if (root == null) {
//            return 0;
//        }
//        return 1 + countNodes(root.left) + countNodes(root.right);
//    }
    public int countNodes(TreeNode root) {
        int left = left(root);
        int right = right(root);
        // If they have the same depth, it means this is a full tree. The
        // total number of nodes is 2^n - 1, where n is the depth of the
        // subtree. No need to traverse the entire tree.
        if (left == right) {
            return (1 << left) - 1;
        } else {
            // Recursively compute the subtrees (left and right). Then add
            // the root node itself (+1).
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    // Calculate the depth of left subtree.
    private int left(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.left;
            depth++;
        }
        return depth;
    }

    // Calculate the depth of right subtree.
    private int right(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.right;
            depth++;
        }
        return depth;
    }
}
