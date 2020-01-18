import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
In an infinite binary tree where every node has two children, the nodes are
labelled in row order.

In the odd numbered rows (ie., the first, third, fifth,...), the labelling is
left to right, while in the even numbered rows (second, fourth, sixth,...), the
labelling is right to left.

Given the label of a node in this tree, return the labels in the path from the
root of the tree to the node with that label.
 */
public class PathInZigzagLabelledBinaryTree {
    public List<Integer> pathInZigZagTree(int label) {
        int parent = label;
        LinkedList<Integer> result = new LinkedList<>();
        result.addFirst(parent);

        while (parent != 1) {
            // value 1 at depth 0, value 2 & 3 at depth 1, and so on.
            int depth = (int) (Math.log(parent) / Math.log(2));
            int offset = (int) Math.pow(2, depth + 1) - 1 - parent;
            parent = ((int) Math.pow(2, depth) + offset) / 2;
            result.addFirst(parent);
        }
        return result;
    }
}
/*
If we label all the nodes in increasing order from left to right, the tree
would look like this:
                1
            2       3
          4   5   6   7
The value of the left child is 2 * parent.
The value of the right child is 2 * parent + 1.
The values of nodes at depth d (0-based) are from 2^d ~ 2^(d + 1) - 1.
Since the we label the nodes in zigzag format, some values are placed in their
symmetric positions.

                1
        2               3
    4       5       6       7
   8 9    10 11   12 13   14 15

                1
        3               2
    4       5       6       7
  15 14    13 12   11 10    9 8
So given a label, if we want to find its parent, we need to go to its
symmetric position and find the value at that position and divide that value
by 2.
 */
