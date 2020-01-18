import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given a binary tree, return the bottom-up level order traversal of its nodes'
values. (ie, from left to right, level by level from leaf to root).
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        levelOrderBottom(root, list, 0);
        return list;
    }

    private void levelOrderBottom(TreeNode node, List<List<Integer>> list,
                                  int level) {
        if (node == null) {
            return;
        }
        if (level == list.size()) {
            // Add new level at the beginning of the list.
            list.add(0, new ArrayList<>());
        }
        list.get(list.size() - 1 - level).add(node.val);
        levelOrderBottom(node.left, list, level + 1);
        levelOrderBottom(node.right, list, level + 1);
    }
}
