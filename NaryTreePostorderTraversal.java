import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
Given an n-ary tree, return the postorder traversal of its nodes' values.
 */
public class NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            // Add to the head of the list.
            // No need to reverse the result.
            result.addFirst(node.val);
            // Add the children from left to right.
            // The children will be removed from right to left.
            for (Node child : node.children) {
                stack.push(child);
            }
        }
        return result;
    }
}
