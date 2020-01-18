import jdk.nashorn.api.tree.Tree;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    GraphNode target;

    // Build an undirected graph and use breath-first search.
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        buildGraph(new GraphNode(root.val), null, target, root);
        bfs(this.target, new HashSet<Integer>(), K, result);
        return result;
    }

    private void bfs(GraphNode node, Set<Integer> visited, int K, List<Integer> result) {
        Queue<GraphNode> queue = new LinkedList<>();
        visited.add(node.val);
        node.distance = 0;
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode temp = queue.remove();
            if (temp.distance == K) {
                result.add(temp.val);
            }
            for (GraphNode neighbor : temp.neighbors) {
                if (!visited.contains(neighbor.val)) {
                    neighbor.distance = temp.distance + 1;
                    visited.add(neighbor.val);
                    queue.add(neighbor);
                }
            }
        }
    }

    // Build the graph and return the target GraphNode.
    private void buildGraph(GraphNode graphNode, GraphNode parent, TreeNode target, TreeNode treeNode) {
        if (graphNode.val == target.val) {
            this.target = graphNode;
        }
        if (parent != null) {
            graphNode.neighbors.add(parent);
        }
        if (treeNode.left != null) {
            GraphNode left = new GraphNode(treeNode.left.val);
            graphNode.neighbors.add(left);
            buildGraph(left, graphNode, target, treeNode.left);
        }
        if (treeNode.right != null) {
            GraphNode right = new GraphNode(treeNode.right.val);
            graphNode.neighbors.add(right);
            buildGraph(right, graphNode, target, treeNode.right);
        }
    }

    private class GraphNode {
        int val;
        List<GraphNode> neighbors;
        int distance;

        GraphNode(int val) {
            this.val = val;
            this.neighbors = new ArrayList<GraphNode>();
            this.distance = 0;
        }
    }
}
