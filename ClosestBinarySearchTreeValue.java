public class ClosestBinarySearchTreeValue {

    double difference = Double.MAX_VALUE;
    int val;

    public int closestValue(TreeNode root, double target) {
        inOrder(root, target);
        return val;
    }

    private void inOrder(TreeNode node, double target) {
        if (node == null) {
            return;
        }
        inOrder(node.left, target);
        if (Math.abs(node.val - target) < difference) {
            difference = Math.abs(node.val - target);
            val = node.val;
        }
        inOrder(node.right, target);
    }

}
