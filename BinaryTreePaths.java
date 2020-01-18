import java.util.LinkedList;
import java.util.List;

/*
Given a binary tree, return all root-to-leaf paths.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null) {
            result.add("" + root.val);
            return result;
        }
        if (root.left != null) {
            binaryTreePaths(root.left, result, "" + root.val);
        }
        if (root.right != null) {
            binaryTreePaths(root.right, result, "" + root.val);
        }
        return result;
    }

    private void binaryTreePaths(TreeNode root, List<String> result,
                                 String path) {
        if (root.left == null && root.right == null) {
            result.add(path + "->" + root.val);
            return;
        }
        if (root.left != null) {
            binaryTreePaths(root.left, result, path + "->" + root.val);
        }
        if (root.right != null) {
            binaryTreePaths(root.right, result, path + "->" + root.val);
        }
    }
}
