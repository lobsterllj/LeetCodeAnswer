import java.security.PublicKey;
import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();

        int[][] grid = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };
        System.out.println(main.maxAreaOfIsland(grid));

    }

    int Rows;
    int Cols;
    int[][] dir = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public int maxAreaOfIsland(int[][] grid) {
        Rows = grid.length;
        Cols = grid[0].length;
        int res = 0;
        for (int row = 0; row < Rows; ++row) {
            for (int col = 0; col < Cols; ++col) {
                if (grid[row][col] == 1) {
                    int cache = dfs(grid, row, col);
                    res = Math.max(res, cache);
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int row, int col) {
        if (row >= Rows || row < 0 || col >= Cols || col < 0)
            return 0;
        if (grid[row][col] == 0)
            return 0;
        grid[row][col] = 0;
        int res = 1;
        for (int[] d : dir) {
            res += dfs(grid, row + d[0], col + d[1]);
        }
        return res;
    }


}
