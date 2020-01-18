/*
Given a binary search tree and a node in it, find the in-order successor of
that node in the BST.

The successor of a node p is the node with the smallest key greater than p.val.

You will have direct access to the node but not to the root of the tree. Each
node will have a reference to its parent node.
 */
public class InorderSuccessorInBSTII {

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    // In Binary Search Tree, Inorder Successor of an input node can also be
    // defined as the node with the smallest key greater than the key of input
    // node. So, it is sometimes important to find next node in sorted order.
    public Node inorderSuccessor(Node x) {
        Node right = x.right;
        if (right == null) {
            Node parent = x.parent;
            // Keep searching up the tree.
            //   15
            //  /
            // 8
            //  \
            //   9
            while (parent != null && parent.val < x.val) {
                parent = parent.parent;
            }
            return parent;
        } else {
            while (right.left != null) {
                right = right.left;
            }
            return right;
        }
    }
}
