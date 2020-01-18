/*
Given a directed, acyclic graph of N nodes.  Find all possible paths from node
0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.
graph[i] is a list of all nodes j for which the edge (i, j) exists.
 */

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    // Backtracking.
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        allPathsSourceTarget(graph, list, 0, result);
        return result;
    }

    private void allPathsSourceTarget(int[][] graph, List<Integer> list,
                                      int node, List<List<Integer>> res) {
        if (node == graph.length - 1) {
            List<Integer> path = new ArrayList<>(list);
            res.add(path);
            return;
        }
        for (int i = 0; i < graph[node].length; i++) {
            list.add(graph[node][i]);
            allPathsSourceTarget(graph, list, graph[node][i], res);
            list.remove(list.size() - 1);
        }
    }
}
