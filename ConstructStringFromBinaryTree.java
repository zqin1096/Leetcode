public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        return preOrder(t);
    }

    private String preOrder(TreeNode node) {
        String s = "";
        s += node.val;
        if (node.left != null && node.right != null) {
            s += "(";
            s += preOrder(node.left);
            s += ")";
            s += "(";
            s += preOrder(node.right);
            s += ")";
        } else if (node.left != null && node.right == null) {
            s += "(";
            s += preOrder(node.left);
            s += ")";
        } else if (node.left == null && node.right != null) {
            s += "()";
            s += "(";
            s += preOrder(node.right);
            s += ")";
        }
        return s;
    }
}
