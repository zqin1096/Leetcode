import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        for (int i = 0; i < pre.length; i++) {
            preOrder.add(pre[i]);
            postOrder.add(post[i]);
        }
        return constructFromPrePost(preOrder, postOrder);
    }

    // Both the first element in pre and the last element in post are root.
    private TreeNode constructFromPrePost(List<Integer> pre, List<Integer> post) {
        if (pre.size() == 0 && post.size() == 0) {
            return null;
        }
        if (pre.size() == 1 && post.size() == 1) {
            return new TreeNode(pre.get(0));
        }
        TreeNode root = new TreeNode(pre.get(0));
        // The root of the left subtree. Pre-order traversal scans the root first, and then its descendants.
        int leftSubtreeRoot = pre.get(1);
        // The number of nodes of left subtree (including the root of left subtree).
        int leftSubtreeNodes = 0;
        // Post-order traversal scans the descendants first, and then the roots.
        for (int i = 0; i < post.size(); i++) {
            leftSubtreeNodes++;
            if (post.get(i) == leftSubtreeRoot) {
                break;
            }
        }
        List<Integer> leftSubtreePre = pre.subList(1, 1 + leftSubtreeNodes);
        List<Integer> leftSubtreePost = post.subList(0, leftSubtreeNodes);
        List<Integer> rightSubtreePre = pre.subList(1 + leftSubtreeNodes, pre.size());
        List<Integer> rightSubtreePost = post.subList(leftSubtreeNodes, post.size() - 1);
        root.left = constructFromPrePost(leftSubtreePre, leftSubtreePost);
        root.right = constructFromPrePost(rightSubtreePre, rightSubtreePost);
        return root;
    }
}
