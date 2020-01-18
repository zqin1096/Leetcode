import java.util.Stack;

/*
You need to construct a binary tree from a string consisting of parenthesis and
integers.

The whole input represents a binary tree. It contains an integer followed by
zero, one or two pairs of parenthesis. The integer represents the root's value
and a pair of parenthesis contains a child binary tree with the same structure.

You always start to construct the left child node of the parent first if it
exists.
 */
public class ConstructBinaryTreeFromString {
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        // The node on the top of the stack is the newest parent node.
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = null;
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            // Build a new node when a number is encountered.
            if (c == '-' || (c >= '0' && c <= '9')) {
                String val = "" + c;
                while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    val += s.charAt(i + 1);
                    i++;
                }
                TreeNode node = new TreeNode(Integer.parseInt(val));
                // Assign the new node to either left or right depending on
                // the situation.
                if (root != null) {
                    if (root.left == null) {
                        root.left = node;
                    } else {
                        root.right = node;
                    }
                }
                stack.push(node);
            } else if (c == '(') {
                // A number (node/child) must be followed this '(',  so we need
                // its parent.
                root = stack.peek();
            } else {
                // The node on the top of the stack is done.
                stack.pop();
            }
            i++;
        }
        return stack.pop();
    }
}
