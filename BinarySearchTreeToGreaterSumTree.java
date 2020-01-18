import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary search tree with distinct values, modify it so that
every node has a new value equal to the sum of the values of the original tree
that are greater than or equal to node.val.
 */
public class BinarySearchTreeToGreaterSumTree {
    int sum = 0;

    // Reversed in-order traversal.
    public TreeNode bstToGst(TreeNode root) {
        traversal(root);
        return root;
    }

    private void traversal(TreeNode node) {
        if (node == null) {
            return;
        }
        // Traverse the right tree first.
        traversal(node.right);
        // Accumulate the sum.
        sum += node.val;
        node.val = sum;
        traversal(node.left);
    }
}
