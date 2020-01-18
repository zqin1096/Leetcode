/*
Write a program to find the node at which the intersection of two singly linked
lists begins.
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr1 = headA;
        ListNode curr2 = headB;
        // Both curr1 and curr2 moves forward one step at a time.
        // curr1 starts at headA and curr2 starts at headB.
        // When curr1 == curr2, both pointers traverse the same amount of nodes.
        while (curr1 != curr2) {
            if (curr1 == null) {
                curr1 = headB;
            } else {
                curr1 = curr1.next;
            }

            if (curr2 == null) {
                curr2 = headA;
            } else {
                curr2 = curr2.next;
            }
        }
        return curr1;
    }
}
/*
c is the common nodes.
A: a + c.
B: b + c.
a + c + b + c = b + c + a + c.
a + b = b + a.
 */
