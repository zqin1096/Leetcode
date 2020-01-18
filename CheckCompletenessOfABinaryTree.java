import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CheckCompletenessOfABinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        // If the current node has the right child, it is set to true.
        boolean right = true;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // If the node has right child but does not have left child, returns false.
            if (node.right != null && node.left == null) {
                return false;
            } else if (node.left != null && node.right == null) {
                // If the current node does not have right child, the next node (poll() from next iteration) cannot have
                // any child (must be a leaf).
                if (!right) {
                    return false;
                }
                right = false;
                queue.add(node.left);
            } else if (node.left != null && node.right != null) {
                if (!right) {
                    return false;
                }
                queue.add(node.left);
                queue.add(node.right);
            } else {
                right = false;
                continue;
            }
        }
        return true;
    }
}
