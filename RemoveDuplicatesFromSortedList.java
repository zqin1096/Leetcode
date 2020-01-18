/*
Given a sorted linked list, delete all duplicates such that each element appear
only once.

Input: 1->1->2
Output: 1->2

Input: 1->1->2->3->3
Output: 1->2->3
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode curr = head.next;
        while (curr != null) {
            // If the value of the current node is different than the value
            // of the previous node, then pre.next = curr.
            if (curr.val != pre.val) {
                pre.next = curr;
                pre = curr;
                curr = curr.next;
            } else {
                // The pre stays the same until the value of curr is
                // different than the value of pre.
                curr = curr.next;
            }
        }
        pre.next = curr;
        return head;
    }
}
