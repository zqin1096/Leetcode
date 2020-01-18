public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        // Use a slow pointer and a fast pointer. The slow pointer moves one
        // step at a time. The fast pointer moves 2 steps at a time. If a
        // cycle exists, they will meet eventually.
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
