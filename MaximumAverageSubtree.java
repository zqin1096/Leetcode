/*
Given the root of a binary tree, find the maximum average value of any subtree
of that tree.
 */
public class MaximumAverageSubtree {
    double max = 0;

    public double maximumAverageSubtree(TreeNode root) {
        sumOfSubtree(root);
        return max;
    }

    // Value at index 0 is the sum of the subtree and the value at index 1 is
    // the number of nodes in the subtree.
    private int[] sumOfSubtree(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        // Recursively computes the sum and number of nodes in the left and
        // right subtrees.
        int[] left = sumOfSubtree(node.left);
        int[] right = sumOfSubtree(node.right);
        int[] sum = new int[]{node.val + left[0] + right[0],
                1 + left[1] + right[1]};
        max = Math.max(max, (double) sum[0] / sum[1]);
        return sum;
    }
}
