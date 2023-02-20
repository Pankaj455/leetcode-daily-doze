/*
 * valid sudoku
 */
public class leetcode36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && isPresent(board[i][j], i, j, board))
                    return false;
            }
        }
        return true;
    }

    public boolean isPresent(char ele, int row, int col, char[][] board) {
        // col traversing
        for (int j = 0; j < 9; j++) {
            if (j != col && board[row][j] == ele) {
                return true;
            }
        }

        // row traversing
        for (int j = 0; j < 9; j++) {
            if (j != row && board[j][col] == ele) {
                return true;
            }
        }

        // 3x3 grid traversing
        int srow = row - (row % 3), scol = col - (col % 3);
        for (int i = srow; i < srow + 3; i++) {
            for (int j = scol; j < scol + 3; j++) {
                if (i != row && j != col && board[i][j] == ele) {
                    return true;
                }
            }
        }

        return false;
    }
}
