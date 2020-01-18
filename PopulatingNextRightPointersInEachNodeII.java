/*
Given a binary tree.
Populate each next pointer to point to its next right node. If there is no next
right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.
 */
public class PopulatingNextRightPointersInEachNodeII {

    private class Node {

        int val;
        Node left;
        Node right;
        Node next;

        private Node() {

        }

        private Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        // Current level is already connected.
        Node curr = root;
        while (curr != null) {
            // Use dummy node since we do not know where is the leftmost node
            // of a level of the tree.
            // dummyChildHead is the leftmost node of the next level.
            Node dummyChildHead = new Node();
            Node temp = dummyChildHead;
            // If curr is null, it means the next level is connected.
            while (curr != null) {
                if (curr.left != null) {
                    temp.next = curr.left;
                    temp = temp.next;
                }
                if (curr.right != null) {
                    temp.next = curr.right;
                    temp = temp.next;
                }
                curr = curr.next;
            }
            // Go the next level, and it is connected, we will use it to
            // connect the next next level.
            curr = dummyChildHead.next;
        }
        return root;
    }
}
