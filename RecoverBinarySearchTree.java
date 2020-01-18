import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Two elements of a binary search tree (BST) are swapped by mistake.
Recover the tree without changing its structure.
 */
public class RecoverBinarySearchTree {
    // O(n).
    // Store the in-order sequence in a list.
    // Sort the list.
    // Assign the value of the sorted list back to the nodes while doing
    // in-order traversal.
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        List<Integer> inorder = new ArrayList<>();
        inorder(root, inorder);
        Collections.sort(inorder);
        inorderVal(root, inorder);
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    private void inorderVal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorderVal(node.left, list);
        node.val = list.get(0);
        list.remove(0);
        inorderVal(node.right, list);
    }
    /*
    We can use 2 pointers instead of a list. Perform inorder traversal and
    find 2 misplaced values/nodes (check if previous value is larger during
    inorder traversal). Then swap the values in these 2 nodes.
     */
}
