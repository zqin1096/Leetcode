import java.util.ArrayList;
import java.util.List;

/*
Given a binary search tree (BST) with duplicates, find all the mode(s) (the
most frequently occurred element) in the given BST.

 */
public class FindModeInBinarySearchTree {
    List<Integer> list = new ArrayList<>();
    Integer pre = null;
    int max = 0;
    int curr = 0;

    // Inorder traversal gives non-decreasing order.
    // Find the mode of the BST.
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        inorder(root);
        if (curr > max) {
            list.clear();
            list.add(pre);
        } else if (curr == max) {
            list.add(pre);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (pre == null) {
            pre = node.val;
            curr++;
        } else {
            if (pre == node.val) {
                curr++;
            } else {
                if (curr > max) {
                    list.clear();
                    list.add(pre);
                    max = Math.max(curr, max);
                } else if (curr == max) {
                    list.add(pre);
                }
                curr = 1;
                pre = node.val;
            }
        }
        inorder(node.right);
    }
}
