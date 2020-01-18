import java.util.*;

public class ShortestPathWithAlternatingColors {

    class Node {
        int node;
        int distance;
        Boolean nextColor;

        Node(int node, int distance, Boolean nextColor) {
            this.node = node;
            this.distance = distance;
            this.nextColor = nextColor;
        }
    }

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        boolean[][] colors = new boolean[n][2];
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, true));
        queue.add(new Node(0, 0, false));
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            answer[node.node] = answer[node.node] == -1 ? node.distance : Math.min(answer[node.node], node.distance);
            List<Node> successors = null;
            if (node.nextColor) {
                successors = generateSuccessors(node, red_edges,
                        false, colors);
            } else {
                successors = generateSuccessors(node, blue_edges,
                        true, colors);
            }
            for (Node successor : successors) {
                queue.add(successor);
            }
        }
        return answer;
    }

    private List<Node> generateSuccessors(Node start, int[][] edges,
                                          boolean nextColor,
                                          boolean[][] colors) {
        List<Node> list = new LinkedList<>();
        for (int[] edge : edges) {
            if (edge[0] == start.node && !colors[edge[1]][nextColor ? 0 : 1]) {
                list.add(new Node(edge[1], start.distance + 1, nextColor));
                colors[edge[1]][nextColor ? 0 : 1] = true;
            }
        }
        return list;
    }
}
