
public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();

    }

    int Rows;
    int Cols;
    int[][] dir = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public void solve(char[][] board) {
        Rows = board.length;
        if (Rows == 0)
            return;
        Cols = board[0].length;
        for (int row = 0; row < Rows; ++row) {
            if (board[row][0] == 'O')
                dfs(board, row, 0);
            if (board[row][Cols - 1] == 'O')
                dfs(board, row, Cols - 1);
        }
        for (int col = 0; col < Cols; ++col) {
            if (board[0][col] == 'O')
                dfs(board, 0, col);
            if (board[Rows - 1][col] == 'O')
                dfs(board, Rows - 1, col);
        }
        for (int row = 0; row < Rows; ++row) {
            for (int col = 0; col < Cols; ++col) {
                if (board[row][col] == 'A')
                    board[row][col] = 'O';
                else if (board[row][col] == 'O')
                    board[row][col] = 'X';
            }
        }

    }


    public void dfs(char[][] board, int row, int col) {
        if (row >= Rows || row < 0 || col >= Cols || col < 0)
            return;
        if (board[row][col] == 'X' || board[row][col] == 'A')
            return;
        board[row][col] = 'A';

        for (int[] d : dir) {
            dfs(board, row + d[0], col + d[1]);
        }
        return;
    }


}
