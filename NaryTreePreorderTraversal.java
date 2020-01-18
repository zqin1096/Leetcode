import java.util.*;

public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            // Add the children from right to left.
            // The children will be removed from left to right.
            Collections.reverse(node.children);
            for (Node child : node.children) {
                stack.push(child);
            }
        }
        return result;
    }
}
