import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {

    // FIFO
    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        // If the ping was made larger than 3000 milliseconds ago, remove it.
        while (t - queue.peek().intValue() > 3000) {
            queue.remove();
        }
        return queue.size();
    }
}
