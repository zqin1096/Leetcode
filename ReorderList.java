import java.util.List;

/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // Find the mid of the linked list.
        // Reverse the second half of the linked list.
        // Rebuild the list in-place.
        // slow is the mid node.
        ListNode slow = head;
        ListNode fast = head;
        // The node before the mid node.
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode node = reverse(slow);
        merge(head, node);
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            // Store the next node first.
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    private void merge(ListNode l1, ListNode l2) {
        // l1 is always shorter or has the same length as l2.
        while (l1 != null) {
            ListNode l1next = l1.next;
            ListNode l2next = l2.next;
            l1.next = l2;
            // The rest nodes are in the expected order.
            if (l1next == null) {
                break;
            }
            l2.next = l1next;
            l1 = l1next;
            l2 = l2next;
        }
    }
}
