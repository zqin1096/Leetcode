public class SumOfRootToLeafBinaryNumbers {
    long ans = 0;
    long limit = 1_000_000_007;

    public int sumRootToLeaf(TreeNode root) {
        traverse(root, 0);
        return (int) (ans % limit);
    }

    // sum represents the current sum.
    private void traverse(TreeNode root, long sum) {
        if (root == null) {
            return;
        }
        // Shift to the left and plus the val of current node.
        sum = (sum << 1) + root.val;
        sum = sum % limit;
        // Reach a leaf node.
        if (root.left == null && root.right == null) {
            ans += sum;
        }
        if (root.left != null) {
            traverse(root.left, sum);
        }
        if (root.right != null) {
            traverse(root.right, sum);
        }
    }
}
