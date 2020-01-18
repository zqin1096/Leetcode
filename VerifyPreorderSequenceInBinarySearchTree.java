/*
Given an array of numbers, verify whether it is the correct preorder traversal
sequence of a binary search tree.

You may assume each number in the sequence is unique.
 */
public class VerifyPreorderSequenceInBinarySearchTree {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return true;
        }
        return verifyPreorder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE,
                0, preorder.length - 1);
    }

    private boolean verifyPreorder(int[] preorder, int low, int high,
                                   int root, int end) {
        if (preorder[root] < low || preorder[root] > high) {
            return false;
        }
        boolean l = true;
        boolean r = true;
        int right = root + 1;
        while (right <= end && preorder[right] < preorder[root]) {
            right++;
        }
        // If right sub-tree exists, check if it is valid.
        if (right <= end) {
            r = verifyPreorder(preorder, preorder[root], high, right, end);
        }
        // If left sub-tree exists, check if it is valid.
        if (root + 1 <= end) {
            if (preorder[root + 1] < preorder[root]) {
                l = verifyPreorder(preorder, low, preorder[root], root + 1,
                        right - 1);
            }
        }
        return l && r;
    }
}
