/*
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in
the tree along the parent-child connections. The longest consecutive path need
to be from parent to child (cannot be the reverse).

 */
public class BinaryTreeLongestConsecutiveSequence {
    int max = 1;

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        longestConsecutive(root, 1);
        return max;
    }

    private void longestConsecutive(TreeNode node, int length) {
        if (node == null) {
            return;
        }
        max = Math.max(max, length);
        if (node.left != null && node.left.val - 1 == node.val) {
            longestConsecutive(node.left, length + 1);
        } else {
            // Start from 1.
            longestConsecutive(node.left, 1);
        }
        if (node.right != null && node.right.val - 1 == node.val) {
            longestConsecutive(node.right, length + 1);
        } else {
            longestConsecutive(node.right, 1);
        }
    }
}
