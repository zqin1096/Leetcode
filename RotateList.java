import java.util.List;
import java.util.Stack;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        // Store all nodes.
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        // Calculate k.
        k = k % stack.size();
        if (k == 0) {
            return head;
        }
        // Pop k nodes and link to the head.
        while (k != 0) {
            ListNode node = stack.pop();
            node.next = head;
            head = node;
            k--;
        }
        ListNode node = stack.pop();
        node.next = null;
        return head;
    }
}
