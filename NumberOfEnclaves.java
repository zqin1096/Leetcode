public class NumberOfEnclaves {
    // DFS.
    int total = 0;
    int nonEnclaves = 0;

    public int numEnclaves(int[][] A) {
        boolean[][] visited = new boolean[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 1) {
                    total++;
                    if (!visited[i][j] && (i == 0 || i == A.length - 1 || j == 0 || j == A[i].length - 1)) {
                        numEnclaves(A, visited, i, j);
                    }
                }
            }
        }
        return total - nonEnclaves;
    }

    private void numEnclaves(int[][] A, boolean[][] visited, int row,
                             int col) {
        visited[row][col] = true;
        nonEnclaves++;
        if (row - 1 >= 0 && A[row - 1][col] == 1 && !visited[row - 1][col]) {
            numEnclaves(A, visited, row - 1, col);
        }
        if (row + 1 < A.length && A[row + 1][col] == 1 && !visited[row + 1][col]) {
            numEnclaves(A, visited, row + 1, col);
        }
        if (col - 1 >= 0 && A[row][col - 1] == 1 && !visited[row][col - 1]) {
            numEnclaves(A, visited, row, col - 1);
        }
        if (col + 1 < A[row].length && A[row][col + 1] == 1 && !visited[row][col + 1]) {
            numEnclaves(A, visited, row, col + 1);
        }
    }
}
