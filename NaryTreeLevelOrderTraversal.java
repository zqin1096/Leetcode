import java.util.LinkedList;
import java.util.List;

public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        levelOrder(root, result, 0);
        return result;
    }

    private void levelOrder(Node node, List<List<Integer>> list, int level) {
        // level represents which list to add.
        if (level >= list.size()) {
            list.add(new LinkedList<>());
        }
        list.get(level).add(node.val);
        if (node.children.size() == 0) {
            return;
        } else {
            for (Node child : node.children) {
                levelOrder(child, list, level + 1);
            }
        }
    }
}
