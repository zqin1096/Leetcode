import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given a binary tree, return the zigzag level order traversal of its nodes'
values. (ie, from left to right, then right to left for the next level and
alternate between).
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        zigzagLevelOrder(root, 0, true, list);
        return list;
    }

    // Add a left parameter to determine which end of the array to add the
    // value.
    private void zigzagLevelOrder(TreeNode node, int level, boolean left,
                                  List<List<Integer>> list) {
        if (node == null) {
            return;
        }
        if (list.size() <= level) {
            list.add(new ArrayList<>());
        }
        if (left) {
            list.get(level).add(node.val);
        } else {
            list.get(level).add(0, node.val);
        }
        zigzagLevelOrder(node.left, level + 1, !left, list);
        zigzagLevelOrder(node.right, level + 1, !left, list);
    }
}
