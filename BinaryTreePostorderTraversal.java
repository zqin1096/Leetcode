import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode lastNodeVisited = null;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                // Keeping going left until the node has no left child.
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode node = stack.peek();
                if (node.right == null) {
                    // The node does not have left and right child (leaf).
                    lastNodeVisited = stack.pop();
                    list.add(lastNodeVisited.val);
                } else {
                    // This checking is essential to avoid infinite loop.
                    if (lastNodeVisited != node.right) {
                        // Add the right child and then keeping going left.
                        // So we need to check if this right child has been
                        // added before.
                        TreeNode right = node.right;
                        while (right != null) {
                            stack.add(right);
                            right = right.left;
                        }
                    } else {
                        // If this right child has been added before, then we
                        // do not need to traverse it again.
                        lastNodeVisited = stack.pop();
                        list.add(lastNodeVisited.val);
                    }
                }
            }
        }
        return list;
    }
}
