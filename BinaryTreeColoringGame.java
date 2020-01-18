public class BinaryTreeColoringGame {
    int left = 0;
    int right = 0;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        if (root.left == null && root.right == null) {
            return false;
        }
        int[] numOfChildren = new int[n];
        traverse(root, numOfChildren, x);
        if ((n - (numOfChildren[x - 1])) > (numOfChildren[x - 1])) {
            return true;
        } else {
            if (left != 0 && numOfChildren[left - 1] > n - numOfChildren[left - 1]) {
                return true;
            }
            if (right != 0 && numOfChildren[right - 1] > n - numOfChildren[right - 1]) {
                return true;
            }
        }
        return false;
    }

    private int traverse(TreeNode root, int[] numOfChildren, int x) {
        if (root == null) {
            return 0;
        }
        if (root.val == x) {
            if (root.left != null) {
                left = root.left.val;
            }
            if (root.right != null) {
                right = root.right.val;
            }
        }
        int left = traverse(root.left, numOfChildren, x);
        int right = traverse(root.right, numOfChildren, x);
        numOfChildren[root.val - 1] = left + right + 1;
        return left + right + 1;
    }
}
