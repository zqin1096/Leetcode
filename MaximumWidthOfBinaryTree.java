import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, write a function to get the maximum width of the given
tree. The width of a tree is the maximum width among all levels. The binary
tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the
leftmost and right most non-null nodes in the level, where the null nodes
between the end-nodes are also counted into the length calculation.
 */
public class MaximumWidthOfBinaryTree {
    int max = 0;

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, new ArrayList<>(), 0, 1);
        return max;
    }

    // A full binary tree has 2^n - 1 nodes,  where n is the level (depth) of
    // the tree. Each node can be labeled from 1 to 2^n - 1.
    // leftmost: store the label of the leftmost node of each level.
    private void dfs(TreeNode node, List<Integer> leftmost, int level,
                     int label) {
        if (node == null) {
            return;
        }
        if (level >= leftmost.size()) {
            leftmost.add(label);
        }
        max = Math.max(max, label - leftmost.get(level) + 1);
        // The label of left child is 2 * label.
        // The label of right child is 2 * label + 1.
        dfs(node.left, leftmost, level + 1, label * 2);
        dfs(node.right, leftmost, level + 1, label * 2 + 1);
    }
}
