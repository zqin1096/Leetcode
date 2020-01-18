import java.util.LinkedList;
import java.util.Queue;

/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.

You must use only standard operations of a queue -- which means only push to
back, peek/pop from front, size, and is empty operations are valid.


 */
public class MyStack {

    Queue queue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new LinkedList();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            // Remove the first n - 1 elements and all them to the back of
            // the queue.
            queue.add(queue.remove());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return (int) queue.remove();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return (int) queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
