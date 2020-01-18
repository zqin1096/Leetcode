import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Given preorder and inorder traversal of a tree, construct the binary tree.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Convert array to list.
        List<Integer> pre = Arrays.stream(preorder).boxed().collect(Collectors.toList());
        List<Integer> in = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        return buildTree(pre, in);
    }

    private TreeNode buildTree(List<Integer> preorder, List<Integer> inorder) {
        if (preorder.size() == 0) {
            return null;
        }
        // Build the root node for the subtree.
        int val = preorder.get(0);
        TreeNode node = new TreeNode(val);
        List<Integer> leftPre = new ArrayList<>();
        List<Integer> rightPre = new ArrayList<>();
        List<Integer> leftIn = new ArrayList<>();
        List<Integer> rightIn = new ArrayList<>();
        int index = 0;
        // Find the index that separate the nodes from left subtree and right
        // subtree (preorder).
        // 3 9 | 20 15 7
        // 9 3 | 15 20 7
        // preorder traverses node, left, right.
        // inorder traverses left, node, right.
        // The index (boundary) has to be the same for preorder and inorder.
        // Find the nodes that belongs to the left and right subtrees,
        // respectively.
        while (inorder.get(index) != val) {
            index++;
        }
        for (int i = 1; i <= index; i++) {
            leftPre.add(preorder.get(i));
        }
        for (int i = index + 1; i < preorder.size(); i++) {
            rightPre.add(preorder.get(i));
        }
        for (int i = 0; i < index; i++) {
            leftIn.add(inorder.get(i));
        }
        for (int i = index + 1; i < inorder.size(); i++) {
            rightIn.add(inorder.get(i));
        }
        node.left = buildTree(leftPre, leftIn);
        node.right = buildTree(rightPre, rightIn);
        return node;
    }
}
