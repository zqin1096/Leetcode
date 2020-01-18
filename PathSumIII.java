import java.util.HashSet;
import java.util.Set;

/*
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go
downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range
-1,000,000 to 1,000,000.
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        // The path can start from root, left child, or right child.
        return dfs(root, sum, 0) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    // Scan all the way down to the leaves. Check every node along the way
    // (the starting node is the same).
    private int dfs(TreeNode root, int sum, int cur) {
        if (root == null)
            return 0;
        cur += root.val;
        return (cur == sum ? 1 : 0) + dfs(root.left, sum, cur) + dfs(root.right, sum, cur);
    }
}
