public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < col - 1; j++) {
                // 与斜下方的元素比较(最后一行和最后一列除外).
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                } else {
                    continue;
                }
            }
        }
        return true;
    }
}
