
class Solution {

    boolean[][] rows = new boolean[9][10];
    boolean[][] cols = new boolean[9][10];
    boolean[][] boxes = new boolean[9][10];

    public void solveSudoku(char[][] board) {

        // Initialize existing numbers
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    int box = (i / 3) * 3 + (j / 3);

                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[box][num] = true;
                }
            }
        }

        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {

        if (row == 9) {
            return true;
        }

        if (col == 9) {
            return solve(board, row + 1, 0);
        }

        if (board[row][col] != '.') {
            return solve(board, row, col + 1);
        }

        int box = (row / 3) * 3 + (col / 3);

        for (int num = 1; num <= 9; num++) {

            if (!rows[row][num] &&
                !cols[col][num] &&
                !boxes[box][num]) {

                // Place number
                board[row][col] = (char) (num + '0');

                rows[row][num] = true;
                cols[col][num] = true;
                boxes[box][num] = true;

                // Recursively solve
                if (solve(board, row, col + 1)) {
                    return true;
                }

                // Backtracking
                board[row][col] = '.';

                rows[row][num] = false;
                cols[col][num] = false;
                boxes[box][num] = false;
            }
        }

        return false;
    }
}
