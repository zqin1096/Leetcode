/*
Given a linked list, return the node where the cycle begins. If there is no
cycle, return null.

To represent a cycle in the given linked list, we use an integer pos which
represents the position (0-indexed) in the linked list where tail connects to.
If pos is -1, then there is no cycle in the linked list.

 */
public class LinkedListCycleII {
    // Math.
    // Draw a graph.
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode curr = head;
                while (curr != slow) {
                    curr = curr.next;
                    slow = slow.next;
                }
                return curr;
            }
        }
        return null;
    }
}
/*
Slow: a + b.
Fast: 2 * (a + b).
2 * (a + b) = a + b + n * (c + b).
a + b = n * (c + b).
a = (b + c) * (n - 1) + c.
b + c is a complete cycle.
a = c.
 */