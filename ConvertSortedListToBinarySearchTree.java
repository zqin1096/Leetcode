import java.util.ArrayList;
import java.util.List;

/*
Given a singly linked list where elements are sorted in ascending order,
convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in
which the depth of the two subtrees of every node never differ by more than 1.
 */
public class ConvertSortedListToBinarySearchTree {
    // Convert to a List.
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return insert(list, 0, list.size() - 1);
    }

    private TreeNode insert(List<Integer> list, int start,
                            int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = insert(list, start, mid - 1);
        node.right = insert(list, mid + 1, end);
        return node;
    }
}
