import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTrees {
    public List<TreeNode> allPossibleFBT(int N) {
        if (N % 2 == 0) {
            return new ArrayList<TreeNode>();
        }
        // Store each root (subtree) of the full binary tree and return it to its parent.
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (N == 1) {
            result.add(new TreeNode(0));
            return result;
        }
        for (int i = 1; i < N - 1; i += 2) {
            // Sub-problem.
            // Give left i nodes, give right N - 1 - i nodes.
            // The left and right sub-tress are built and stored in left and
            // right list.
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - 1 - i);
            // allPossibleFBT(root) = allPossibleFBT(left sub-tree) * allPossibleFBT(right sub-tree);
            // allPossibleFBT returns a list of TreeNode.
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    // Create a new root (subtree).
                    TreeNode node = new TreeNode(0);
                    node.left = l;
                    node.right = r;
                    result.add(node);
                }
            }
        }
        return result;
    }
}
