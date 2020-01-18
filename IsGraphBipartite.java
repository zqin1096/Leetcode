/*
Given an undirected graph, return true if and only if it is bipartite. Recall
that a graph is bipartite if we can split it's set of nodes into two
independent subsets A and B such that every edge in the graph has one node in
A and another node in B.

The graph is given in the following form: graph[i] is a list of indexes j for
which the edge between nodes i and j exists.  Each node is an integer between
0 and graph.length - 1.  There are no self edges or parallel edges: graph[i]
does not contain i, and it doesn't contain any element twice.
 */
public class IsGraphBipartite {
    // Graph could be disconnected.
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            // Check the node if it has not been assigned a color.
            if (colors[i] == 0 && !dfs(graph, colors, i, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] colors, int node, int color) {
        // If this node has been assigned a color, check if that color is the
        // same as this color.
        if (colors[node] != 0) {
            return colors[node] == color;
        }
        colors[node] = color;
        for (int i = 0; i < graph[node].length; i++) {
            if (!dfs(graph, colors, graph[node][i], -color)) {
                return false;
            }
        }
        return true;
    }
}
