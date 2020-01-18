/*
Given an array where elements are sorted in ascending order, convert it to a
height balanced BST.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return insert(nums, 0, nums.length - 1);
    }

    private TreeNode insert(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        // Insert the mid element.
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = insert(nums, start, mid - 1);
        node.right = insert(nums, mid + 1, end);
        return node;
    }
}
