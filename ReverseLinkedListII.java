public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Dummy header.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        ListNode start = null;
        ListNode end = null;
        // Find the node before m.
        for (int i = 1; i < m; i++) {
            curr = curr.next;
        }
        start = curr;
        // m.
        curr = curr.next;
        // Find the final end node.
        end = curr;
        ListNode temp = new ListNode(0);
        for (int i = 1; i <= n - m + 1; i++) {
            ListNode next = curr.next;
            // Reverse the node by using another dummy node.
            curr.next = temp;
            temp = curr;
            curr = next;
        }
        start.next = temp;
        end.next = curr;
        return dummy.next;
    }
}
