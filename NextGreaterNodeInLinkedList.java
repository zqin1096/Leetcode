import java.util.*;

public class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        // Next greater element.
        List<Integer> list = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next) {
            list.add(node.val);
        }
        // Store the position of the node.
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[list.size()];
        // If head is null, the loop will not be executed.
        for (int i = 0; i < list.size(); i++) {
            // The stack is empty during the first iteration. Just push the
            // first element (position) on the stack.
            while (!stack.isEmpty() && list.get(i) > list.get(stack.peek())) {
                // Compare the ith element with the element on the top of the
                // stack. If the ith element is larger, we know the next
                // greater element for the element on the top of the stack.
                result[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        return result;
    }
}
