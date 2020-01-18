import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
You are given a perfect binary tree where all leaves are on the same level, and
every parent has two children.

Populate each next pointer to point to its next right node. If there is no next
right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
 */
public class PopulatingNextRightPointersInEachNode {

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


    // O(n) space.
//    public Node connect(Node root) {
//        if (root == null) {
//            return root;
//        }
//        List<List<Node>> lists = new LinkedList<>();
//        levelOrder(root, lists, 0);
//        for (int i = 0; i < lists.size(); i++) {
//            for (int j = 0; j < lists.get(i).size() - 1; j++) {
//                lists.get(i).get(j).next = lists.get(i).get(j + 1);
//            }
//        }
//        return root;
//    }
//
//    private void levelOrder(Node node, List<List<Node>> lists, int level) {
//        if (node == null) {
//            return;
//        }
//        if (level >= lists.size()) {
//            lists.add(new ArrayList<>());
//        }
//        lists.get(level).add(node);
//        levelOrder(node.left, lists, level + 1);
//        levelOrder(node.right, lists, level + 1);
//    }
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        // current level is already connected.
        Node curr = root;
        Node nextLeftmost = null;
        while (curr.left != null) {
            // So we know there is a next level.
            nextLeftmost = curr.left;
            // If curr is null, it means we have connected all the nodes from
            // the next level.
            while (curr != null) {
                curr.left.next = curr.right;
                // We need to check if curr has a next node in order to the
                // connect the right child of curr to the left child of
                // curr.next.
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            // Go the starting node of next level.
            curr = nextLeftmost;
        }
        return root;
    }
}
