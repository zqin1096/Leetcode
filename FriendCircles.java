public class FriendCircles {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                findCircleNum(M, visited, i);
                count++;
            }
        }
        return count;
    }

    // Set the visited[j] to true as long as it can be reached, which means they are in a friend circle.
    private void findCircleNum(int[][] M, boolean[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                // If a people has been found in a friend group, then there
                // is no need to search this people again.
                visited[j] = true;
                findCircleNum(M, visited, j);
            }
        }
    }
}
