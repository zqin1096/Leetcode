import java.util.ArrayList;
import java.util.List;

/*
Given a Binary Search Tree (BST) with root node root, and a target value V,
split the tree into two subtrees where one subtree has nodes that are all
smaller or equal to the target value, while the other subtree has all nodes that
are greater than the target value.  It's not necessarily the case that the tree
contains a node with value V.

Additionally, most of the structure of the original tree should remain.
Formally, for any child C with parent P in the original tree, if they are both
in the same subtree after the split, then node C should still have the parent P.

You should output the root TreeNode of both subtrees after splitting, in any
order.
 */
public class SplitBST {
    public TreeNode[] splitBST(TreeNode root, int V) {
        List<TreeNode> preOrder = new ArrayList<>();
        // Use pre-order traversal.
        preOrder(root, preOrder);
        TreeNode root1 = null;
        TreeNode root2 = null;
        // Insert the node to one of the trees based on their values.
        for (TreeNode node : preOrder) {
            if (node.val <= V) {
                root1 = insert(root1, node.val);
            } else {
                root2 = insert(root2, node.val);
            }
        }
        return new TreeNode[]{root1, root2};
    }

    private void preOrder(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        list.add(node);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }

    private TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }
}

