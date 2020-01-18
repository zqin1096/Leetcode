public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int start,
                                                int end) {
        if (start > end) {
            return null;
        }
        int max = start;
        for (int i = start + 1; i <= end; i++) {
            max = nums[i] > nums[max] ? i : max;
        }
        TreeNode node = new TreeNode(nums[max]);
        node.left = constructMaximumBinaryTree(nums, start, max - 1);
        node.right = constructMaximumBinaryTree(nums, max + 1, end);
        return node;
    }
}
