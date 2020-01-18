public class MaximumDepthOfNaryTree {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        // Leaf node.
        if (root.children.size() == 0) {
            return 1;
        }
        int max = 0;
        for (int i = 0; i < root.children.size(); i++) {
            max = Math.max(max, 1 + maxDepth(root.children.get(i)));
        }
        return max;
    }
}
