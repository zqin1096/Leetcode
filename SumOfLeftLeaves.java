/*
Find the sum of all left leaves in a given binary tree.
 */
public class SumOfLeftLeaves {

    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        sumOfLeftLeaves(root, false);
        return sum;
    }

    private void sumOfLeftLeaves(TreeNode node, boolean isLeft) {
        if (node.left != null && node.right != null) {
            sumOfLeftLeaves(node.left, true);
            sumOfLeftLeaves(node.right, false);
        } else if (node.left == null && node.right != null) {
            sumOfLeftLeaves(node.right, false);
        } else if (node.left != null && node.right == null) {
            sumOfLeftLeaves(node.left, true);
        } else {
            if (isLeft) {
                sum += node.val;
            }
        }
    }
}
