import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, imagine yourself standing on the right side of it, return
the values of the nodes you can see ordered from top to bottom.
 */
public class BinaryTreeRightSideView {
    // Similar to level order traversal. Traverse right subtree first, then
    // left subtree.
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(list, root, 0);
        return list;
    }

    private void dfs(List<Integer> list, TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level >= list.size()) {
            list.add(node.val);
        }
        dfs(list, node.right, level + 1);
        dfs(list, node.left, level + 1);
    }
}
