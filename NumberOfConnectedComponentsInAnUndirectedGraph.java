import java.util.ArrayList;
import java.util.List;

/*
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge
is a pair of nodes), write a function to find the number of connected
components in an undirected graph.
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {
    int ans = 0;

    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            neighbors.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            neighbors.get(edges[i][0]).add(edges[i][1]);
            neighbors.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans++;
                dfs(neighbors, i, visited);
            }
        }
        return ans;
    }

    private void dfs(List<List<Integer>> neighbors, int node,
                     boolean[] visited) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        for (int i = 0; i < neighbors.get(node).size(); i++) {
            dfs(neighbors, neighbors.get(node).get(i), visited);
        }
    }
}
