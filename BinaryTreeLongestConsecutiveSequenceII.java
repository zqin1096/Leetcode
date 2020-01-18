/*
Given a binary tree, you need to find the length of Longest Consecutive Path in
Binary Tree.

Especially, this path can be either increasing or decreasing. For example,
[1,2,3,4] and [4,3,2,1] are both considered valid, but the path [1,2,4,3] is
not valid. On the other hand, the path can be in the child-Parent-child order,
where not necessarily be parent-child order.

 */
public class BinaryTreeLongestConsecutiveSequenceII {
    int max = 1;

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, root);
        return max;
    }

    // int[0] represents the length of longest decreasing path. int[1]
    // represents the length of longest increasing path (from top to bottom).
    private int[] dfs(TreeNode node, TreeNode parent) {
        if (node == null) {
            return new int[]{0, 0};
        }
        // Traverse to the leaves, and find the longest increasing and
        // decreasing path for this node.
        // Since we can increase or decrease 1, we need 2 data both left and
        // right sub-tree.
        int[] left = dfs(node.left, node);
        int[] right = dfs(node.right, node);
        // Add the left path and right path together.
        max = Math.max(max, left[0] + right[1] + 1);
        max = Math.max(max, left[1] + right[0] + 1);
        int inc = 0;
        int dec = 0;
        // Compare node's value to the value of its parent.
        if (node.val == parent.val + 1) {
            // Increasing path.
            inc = 1 + Math.max(left[0], right[0]);
        }
        if (node.val == parent.val - 1) {
            dec = 1 + Math.max(left[1], right[1]);
        }
        // If the values are not consecutive, just return 0.
        return new int[]{inc, dec};
    }
}
