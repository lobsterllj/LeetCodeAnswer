import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[][] matrix = new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(main.longestIncreasingPath(matrix));
    }

    public int row_max;
    public int col_max;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int maxLen = 0;
        row_max = matrix.length;
        col_max = matrix[0].length;
        int[][] memory = new int[row_max][col_max];
        for (int i = 0; i < row_max; ++i) {
            for (int j = 0; j < col_max; ++j)
                maxLen = Math.max(maxLen, dfs(matrix, memory, i, j));
        }
        prt(matrix, memory);
        return maxLen;
    }

    public int dfs(int[][] matrix, int[][] memory, int row, int col) {
        if (memory[row][col] != 0)
            return memory[row][col];
        memory[row][col]++;
        if ((row + 1) < row_max && (matrix[row + 1][col] > matrix[row][col])) {
            memory[row][col] = Math.max(dfs(matrix, memory, row + 1, col) + 1, memory[row][col]);
        }
        if ((col + 1) < col_max && (matrix[row][col + 1] > matrix[row][col])) {
            memory[row][col] = Math.max(dfs(matrix, memory, row, col + 1) + 1, memory[row][col]);
        }
        if ((row - 1) >= 0 && (matrix[row - 1][col] > matrix[row][col])) {
            memory[row][col] = Math.max(dfs(matrix, memory, row - 1, col) + 1, memory[row][col]);
        }
        if ((col - 1) >= 0 && (matrix[row][col - 1] > matrix[row][col])) {
            memory[row][col] = Math.max(dfs(matrix, memory, row, col - 1) + 1, memory[row][col]);
        }
        return memory[row][col];
    }

    public void prt(int[][] matrix, int[][] memory) {
        System.out.println("matrix:");
        for (int i = 0; i < row_max; ++i) {
            for (int j = 0; j < col_max; ++j)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
        System.out.println("memory:");
        for (int i = 0; i < row_max; ++i) {
            for (int j = 0; j < col_max; ++j)
                System.out.print(memory[i][j] + " ");
            System.out.println();
        }
    }
}
