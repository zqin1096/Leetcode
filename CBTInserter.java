import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class CBTInserter {

    List<TreeNode> tree;
    int size;

    // Array implementation of heap.
    public CBTInserter(TreeNode root) {
        tree = new ArrayList<>();
        tree.add(null);
        tree.add(root);
        size = 1;
        for (int i = 1; i < tree.size(); i++) {
            if (tree.get(i).left != null) {
                tree.add(tree.get(i).left);
                size++;
            }
            if (tree.get(i).right != null) {
                tree.add(tree.get(i).right);
                size++;
            }
        }
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        tree.add(node);
        size++;
        if (size % 2 == 0) {
            tree.get(size / 2).left = node;
        } else {
            tree.get(size / 2).right = node;
        }
        return tree.get(size / 2).val;
    }

    public TreeNode get_root() {
        return tree.get(1);
    }
}
