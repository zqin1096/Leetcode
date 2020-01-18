import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, find the largest subtree which is a Binary Search Tree
(BST), where largest means subtree with largest number of nodes in it.
 */
public class LargestBSTSubtree {
    // Traverse every node and treat each node as the root.
    int maximum = 1;
    int res = 0;

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traverse(root);
        return res;
    }

    private int largestBSTSubtree(TreeNode node, int min, int max) {
        if (node == null) {
            return 0;
        }
        int l = largestBSTSubtree(node.left, min, node.val);
        int r = largestBSTSubtree(node.right, node.val, max);
        if (l == -1 || r == -1) {
            return -1;
        }
        maximum = Math.max(maximum, 1 + l + r);
        if (node.val > min && node.val < max) {
            return 1 + l + r;
        } else {
            return -1;
        }
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.left);
        int count = count(node);
        res = Math.max(res, count);
        traverse(node.right);
    }

    private int count(TreeNode node) {
        int l = largestBSTSubtree(node.left, Integer.MIN_VALUE, node.val);
        int r = largestBSTSubtree(node.right, node.val, Integer.MAX_VALUE);
        if (l != -1 && r != -1) {
            return l + r + 1;
        } else {
            return maximum;
        }
    }
}
