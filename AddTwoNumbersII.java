import java.util.List;
import java.util.Stack;

/*
You are given two non-empty linked lists representing two non-negative integers.
The most significant digit comes first and each of their nodes contain a single
digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the
number 0 itself.
 */
public class AddTwoNumbersII {
    // Use stack.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> num1 = new Stack<>();
        Stack<Integer> num2 = new Stack<>();
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        while (curr1 != null) {
            num1.push(curr1.val);
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            num2.push(curr2.val);
            curr2 = curr2.next;
        }
        if (num1.size() >= num2.size()) {
            return add(num1, num2);
        } else {
            return add(num2, num1);
        }
    }

    private ListNode add(Stack<Integer> num1, Stack<Integer> num2) {
        ListNode head = null;
        int carry = 0;
        while (!num1.isEmpty() && !num2.isEmpty()) {
            int sum = num1.pop() + num2.pop() + carry;
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        while (!num1.isEmpty()) {
            int sum = num1.pop() + carry;
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        // Check the carry.
        if (carry == 1) {
            ListNode node = new ListNode(1);
            node.next = head;
            head = node;
        }
        return head;
    }
}
