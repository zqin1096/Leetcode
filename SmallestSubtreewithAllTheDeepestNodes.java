public class SmallestSubtreewithAllTheDeepestNodes {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }
        return subtreeWithAllDeepest(root, 0).node;
    }

    private Pair subtreeWithAllDeepest(TreeNode node, int depth) {
        // If this node is a leaf node, return its depth and itself as a Pair.
        if (node.left == null && node.right == null) {
            return new Pair(depth, node);
        } else if (node.left != null && node.right == null) {
            return subtreeWithAllDeepest(node.left, depth + 1);
        } else if (node.left == null && node.right != null) {
            return subtreeWithAllDeepest(node.right, depth + 1);
        } else {
            // Find the depths of the node's left subtree and right subtree.
            Pair left = subtreeWithAllDeepest(node.left, depth + 1);
            Pair right = subtreeWithAllDeepest(node.right, depth + 1);
            if (left.depth == right.depth) {
                // If the depths of the node's left subtree and right subtree are the same, return the depth of the
                // subtree and the node itself.
                return new Pair(left.depth, node);
            } else if (left.depth > right.depth) {
                // Keep the larger depth and the node with the largest depth that contains all the deepest nodes.
                // The depth indicates the largest depth of this subtree.
                return new Pair(left.depth, left.node);
            } else {
                return new Pair(right.depth, right.node);
            }
        }

    }

    //
    private class Pair {
        int depth;
        TreeNode node;

        Pair(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }
}
