/*
Given a binary tree, count the number of uni-value subtrees.
A Uni-value subtree means all nodes of the subtree have the same value.
 */
public class CountUnivalueSubtrees {
    int res = 0;

    public int countUnivalSubtrees(TreeNode root) {
        isUnivalSubtrees(root);
        return res;
    }

    private boolean isUnivalSubtrees(TreeNode node) {
        if (node == null) {
            return true;
        }

        // Recursively check if the subtrees are uni-value.
        boolean left = isUnivalSubtrees(node.left);
        boolean right = isUnivalSubtrees(node.right);
        // If the subtrees are uni-value, check if this node has the same value
        // with two children.
        if (left && right) {
            if (node.left != null && node.right != null) {
                if (node.val == node.left.val && node.val == node.right.val) {
                    res++;
                    return true;
                } else {
                    return false;
                }
            } else if (node.left != null && node.right == null) {
                if (node.val == node.left.val) {
                    res++;
                    return true;
                } else {
                    return false;
                }
            } else if (node.left == null && node.right != null) {
                if (node.val == node.right.val) {
                    res++;
                    return true;
                } else {
                    return false;
                }
            } else {
                res++;
                return true;
            }
        } else {
            return false;
        }
    }
}
