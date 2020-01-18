import java.util.LinkedList;
import java.util.List;

/*
Given a binary tree, collect a tree's nodes as if you were doing this: Collect
and remove all leaves, repeat until the tree is empty.
 */
public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        while (root != null) {
            List<Integer> leaves = new LinkedList<>();
            root = findLeaves(root, leaves);
            result.add(leaves);
        }
        return result;
    }

    private TreeNode findLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return null;
        }
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return null;
        }
        node.left = findLeaves(node.left, leaves);
        node.right = findLeaves(node.right, leaves);
        return node;
    }
}
