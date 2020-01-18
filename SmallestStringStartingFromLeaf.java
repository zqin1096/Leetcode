import jdk.nashorn.api.tree.Tree;

/*
Given the root of a binary tree, each node has a value from 0 to 25
representing the letters 'a' to 'z': a value of 0 represents 'a', a value of 1
represents 'b', and so on.

Find the lexicographically smallest string that starts at a leaf of this tree
and ends at the root.
 */
public class SmallestStringStartingFromLeaf {

    String result = null;

    // DFS.
    public String smallestFromLeaf(TreeNode root) {
        smallestFromLeaf(root, "");
        return result;
    }

    private void smallestFromLeaf(TreeNode node, String s) {
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder(s);
            sb.insert(0, (char) (node.val + 'a'));
            if (result == null) {
                result = sb.toString();
                return;
            } else {
                result = sb.toString().compareTo(result) < 0 ? sb.toString() : result;
                return;
            }
        }
        if (node.left != null) {
            StringBuilder sb = new StringBuilder(s);
            smallestFromLeaf(node.left,
                    sb.insert(0, (char) (node.val + 'a')).toString());
        }
        if (node.right != null) {
            StringBuilder sb = new StringBuilder(s);
            smallestFromLeaf(node.right,
                    sb.insert(0, (char) (node.val + 'a')).toString());
        }
    }
}
