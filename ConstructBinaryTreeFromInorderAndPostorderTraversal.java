import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Given inorder and postorder traversal of a tree, construct the binary tree.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> in = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        List<Integer> post = Arrays.stream(postorder).boxed().collect(Collectors.toList());
        return buildTree(in, post);
    }

    // Almost same idea as 105. Find the nodes for left and right subtrees.
    private TreeNode buildTree(List<Integer> inorder, List<Integer> postorder) {
        int size = postorder.size();
        if (size == 0) {
            return null;
        }
        int val = postorder.get(size - 1);
        TreeNode node = new TreeNode(val);
        int index = 0;
        List<Integer> leftin = new ArrayList<>();
        List<Integer> leftpost = new ArrayList<>();
        List<Integer> rightin = new ArrayList<>();
        List<Integer> rightpost = new ArrayList<>();
        while (inorder.get(index) != val) {
            index++;
        }
        for (int i = 0; i < index; i++) {
            leftin.add(inorder.get(i));
        }
        for (int i = 0; i < index; i++) {
            leftpost.add(postorder.get(i));
        }
        for (int i = index + 1; i < inorder.size(); i++) {
            rightin.add(inorder.get(i));
        }
        for (int i = index; i < postorder.size() - 1; i++) {
            rightpost.add(postorder.get(i));
        }
        node.left = buildTree(leftin, leftpost);
        node.right = buildTree(rightin, rightpost);
        return node;
    }
}
