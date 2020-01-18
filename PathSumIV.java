import java.util.*;

/*
If the depth of a tree is smaller than 5, then this tree can be represented by
a list of three-digits integers.

For each integer in this list:
1. The hundreds digit represents the depth D of this node, 1 <= D <= 4.
2. The tens digit represents the position P of this node in the level it belongs
to, 1 <= P <= 8. The position is the same as that in a full binary tree.
3. The units digit represents the value V of this node, 0 <= V <= 9.
 */
public class PathSumIV {

    class Pair {
        int pathSum;
        int index;

        Pair(int pathSum, int index) {
            this.pathSum = pathSum;
            this.index = index;
        }
    }

    public int pathSum(int[] nums) {
        int[] nodes = new int[16];
        Arrays.fill(nodes, -1);
        for (int num : nums) {
            int units = num % 10;
            int tens = num / 10 % 10;
            int hundreds = num / 100 % 10;
            int index = (int) Math.pow(2, hundreds - 1) + (tens - 1);
            nodes[index] = units;
        }
        Pair root = new Pair(nodes[1], 1);
        Stack<Pair> stack = new Stack<>();
        stack.push(root);
        int sum = 0;
        while (!stack.isEmpty()) {
            Pair node = stack.pop();
            int index = node.index;
            if ((index * 2 >= 16 && index * 2 + 1 >= 16) || (nodes[index * 2] == -1 && nodes[index * 2 + 1] == -1)) {
                sum += node.pathSum;
            }
            if (index * 2 < 16 && nodes[index * 2] != -1) {
                stack.push(new Pair(node.pathSum + nodes[index * 2],
                        index * 2));
            }
            if (index * 2 + 1 < 16 && nodes[index * 2 + 1] != -1) {
                stack.push(new Pair(node.pathSum + nodes[index * 2 + 1],
                        index * 2 + 1));
            }
        }
        return sum;
    }
}
