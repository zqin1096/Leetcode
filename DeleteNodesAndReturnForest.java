import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest
(a disjoint union of trees).

Return the roots of the trees in the remaining forest.  You may return the
result in any order.

Each node has a distinct value between 1 and 1000.
to_delete contains distinct values between 1 and 1000.
 */
public class DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        delNodes(root, set, result, true);
        return result;
    }

    // When newRoot is false, the root of the subtree has been added.
    private TreeNode delNodes(TreeNode node, Set<Integer> set,
                              List<TreeNode> result, boolean newRoot) {
        if (node == null) {
            return null;
        }
        if (!set.contains(node.val)) {
            // Keep this node.
            if (newRoot) {
                // If this node is the root, add it to the result.
                result.add(node);
            }
            node.left = delNodes(node.left, set, result, false);
            node.right = delNodes(node.right, set, result, false);
            return node;
        } else {
            // Delete the node.
            set.remove(node.val);
            delNodes(node.left, set, result, true);
            delNodes(node.right, set, result, true);
            return null;
        }
    }
}
