/*
Given a sorted linked list, delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list.
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        // Since we do not know which values are distinct, we use a dummy node.
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode curr = head;
        ListNode next = head.next;
        while (next != null) {
            if (curr.val == next.val) {
                // If the value is not distinct, we keeping searching the
                // next larger value.
                while (next != null && curr.val == next.val) {
                    curr = next;
                    next = next.next;
                }
                curr = next;
                if (next != null) {
                    next = next.next;
                }
            } else {
                // If the value of the current node is different than the
                // value of the next node, it means the value of current node
                // is distinct. We can append it to pre.
                pre.next = curr;
                pre = curr;
                curr = next;
                next = next.next;
            }
        }
        pre.next = curr;
        return dummy.next;
    }
}
