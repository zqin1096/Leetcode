import jdk.nashorn.api.tree.Tree;

public class SerializeAndDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // Pre-order traversal.
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val).append(" ");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] vals = data.split(" ");
        // Pass the value of index as a reference (not value) so that it's consistent between both the left and right
        // trees. Advance to the next index when the current index is built as a TreeNode. Since left-subtree is built
        // first, right sub-tree needs the correct index.
        return deserialize(vals, Integer.MIN_VALUE, Integer.MAX_VALUE, new int[]{0});
    }

    // Pre-order traversal traverses root first, then the left and right subtrees. The value of the root can be used as
    // a bound. Use the bound to determine if the val in vals belongs to the left or right subtree.
    private TreeNode deserialize(String[] vals, int min, int max, int[] index) {
        // Finish going through the data.
        if (index[0] >= vals.length) {
            return null;
        }
        int val = Integer.valueOf(vals[index[0]]);
        if (val < min || val > max) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(vals[index[0]++]));
        root.left = deserialize(vals, min, val, index);
        root.right = deserialize(vals, val, max, index);
        return root;
    }
}
