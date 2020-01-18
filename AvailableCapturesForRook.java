public class AvailableCapturesForRook {
    // Find all p in 4 directions.
    public int numRookCaptures(char[][] board) {
        int row = 0;
        int col = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        int num = 0;
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'p') {
                num++;
                break;
            } else if (board[i][col] == 'B') {
                break;
            } else {
                continue;
            }
        }

        for (int i = row + 1; i < board.length; i++) {
            if (board[i][col] == 'p') {
                num++;
                break;
            } else if (board[i][col] == 'B') {
                break;
            } else {
                continue;
            }
        }

        for (int i = col - 1; i >= 0; i--) {
            if (board[row][i] == 'p') {
                num++;
                break;
            } else if (board[row][i] == 'B') {
                break;
            } else {
                continue;
            }
        }

        for (int i = col + 1; i < board[row].length; i++) {
            if (board[row][i] == 'p') {
                num++;
                break;
            } else if (board[row][i] == 'B') {
                break;
            } else {
                continue;
            }
        }
        return num;
    }
}
