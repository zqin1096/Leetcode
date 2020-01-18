/*
Given the root of a binary tree with N nodes, each node in the tree has node.val
coins, and there are N coins total.

In one move, we may choose two adjacent nodes and move one coin from one node
to another.  (The move may be from parent to child, or from child to parent.)

Return the number of moves required to make every node have exactly one coin.
 */
public class DistributeCoinsInBinaryTree {
    int ans = 0;

    public int distributeCoins(TreeNode root) {
        balance(root);
        return ans;
    }

    // Calculate the number of coins needed in a subtree.
    private int balance(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // The absolute value of l + the absolute value of r represents the
        // number of moves necessary to pass the coins in order to "balance"
        // the subtree.
        int l = balance(node.left);
        int r = balance(node.right);
        ans += Math.abs(l) + Math.abs(r);
        // Calculate the total number of coins (balance) needed for this node
        // and its descendants.
        return l + r + node.val - 1;
    }
}
