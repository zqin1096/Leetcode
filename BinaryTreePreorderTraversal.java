import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;
        // Keep adding left children.
        while (curr != null) {
            stack.push(curr);
            result.add(curr.val);
            curr = curr.left;
        }
        while (!stack.isEmpty()) {
            curr = stack.pop();
            // Get the right child and keep adding left children.
            TreeNode right = curr.right;
            while (right != null) {
                stack.push(right);
                result.add(right.val);
                right = right.left;
            }
        }
        return result;
    }
}
