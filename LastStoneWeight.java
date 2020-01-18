import java.util.Comparator;
import java.util.PriorityQueue;

/*
We have a collection of rocks, each rock has a positive integer weight.

Each turn, we choose the two heaviest rocks and smash them together.  Suppose
the stones have weights x and y with x <= y.  The result of this smash is:
If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight
y has new weight y-x.

At the end, there is at most 1 stone left.  Return the weight of this stone
(or 0 if there are no stones left.)
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i : stones) {
            pq.add(i);
        }
        while (pq.size() > 1) {
            int rock1 = pq.remove();
            int rock2 = pq.remove();
            if (rock1 > rock2) {
                pq.add(rock1 - rock2);
            }
        }
        return pq.size() == 0 ? 0 : pq.remove();
    }
}
