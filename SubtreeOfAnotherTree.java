/*
Given two non-empty binary trees s and t, check whether tree t has exactly the
same structure and node values with a subtree of s. A subtree of s is a tree
consists of a node in s and all of this node's descendants. The tree s could
also be considered as a subtree of itself.
 */
public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traversal(s, t);
    }

    private boolean traversal(TreeNode node, TreeNode t) {
        // Compare the current subtree with t. Traverse the left and right
        // subtrees and compare them as well.
        return node != null && (compare(node, t) || traversal(node.left, t) || traversal(node.right, t));
    }

    private boolean compare(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val &&
                compare(node1.left, node2.left) && compare(node1.right,
                node2.right);

    }
}
