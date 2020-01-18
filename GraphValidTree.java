import java.util.ArrayList;
import java.util.List;

/*
Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge
is a pair of nodes), write a function to check whether these edges make up a
valid tree.

 */
public class GraphValidTree {
    // DFS.
    public boolean validTree(int n, int[][] edges) {
        // Detect if a cycle exists in an undirected graph.
        List<List<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            neighbors.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            neighbors.get(edges[i][0]).add(edges[i][1]);
            neighbors.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        boolean valid = dfs(-1, visited, 0, neighbors);
        // Graph may be disconnected, check if all nodes are visited.
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return valid;
    }

    // Use a parent parameter so we do not go back where the node comes from.
    private boolean dfs(int parent, boolean[] visited, int node,
                        List<List<Integer>> neighbors) {
        if (visited[node]) {
            return false;
        }
        visited[node] = true;
        for (int i = 0; i < neighbors.get(node).size(); i++) {
            if (neighbors.get(node).get(i) != parent) {
                if (!dfs(node, visited, neighbors.get(node).get(i), neighbors)) {
                    return false;
                }
            }
        }
        return true;
    }
}
