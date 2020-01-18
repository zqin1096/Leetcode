public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] information1 = new int[2];
        int[] information2 = new int[2];
        search(root, 0, 0, information1, x);
        search(root, 0, 0, information2, y);
        if ((information1[0] != information2[0]) && (information1[1] == information2[1])) {
            return true;
        } else {
            return false;
        }
    }

    // Store the information in the array.
    private void search(TreeNode node, int parent, int depth,
                        int[] information, int key) {
        if (node == null) {
            return;
        }
        if (node.val == key) {
            information[0] = parent;
            information[1] = depth;
            return;
        }
        search(node.left, node.val, depth + 1, information, key);
        search(node.right, node.val, depth + 1, information, key);
    }
}
