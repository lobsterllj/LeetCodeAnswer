import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {
        main main = new main();
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";

        char[][] board1 = new char[][]{{'a', 'a', 'b'}};
        String word1 = "aaa";
        System.out.println(main.exist(board, word));
    }

    int row_nums;
    int col_nums;

    public boolean exist(char[][] board, String word) {
        row_nums = board.length;
        col_nums = board[0].length;
        if (row_nums == 1 && col_nums == 1 && word.length() == 1)
            return board[0][0] == word.charAt(0);

        char[] words = word.toCharArray();
        for (int i = 0; i < row_nums; ++i) {
            for (int j = 0; j < col_nums; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    if (recallfind(board, words, i, j, 0))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean recallfind(char[][] board, char[] words, int row, int col, int index) {
        System.out.println("row: " + row + "   col:" + col + "  index:" + index);
        if (row < 0 || row >= row_nums || col < 0 || col >= col_nums || board[row][col] != words[index])
            return false;
        if (index == words.length - 1)
            return true;

        char cache = board[row][col];
        board[row][col] = '#';

        boolean temp=recallfind(board, words, row+1, col, index+1)||recallfind(board, words, row-1, col, index+1)
                ||recallfind(board, words, row, col+1, index+1)||recallfind(board, words, row, col-1, index+1);

        board[row][col]=cache;
        return temp;

    }


}
