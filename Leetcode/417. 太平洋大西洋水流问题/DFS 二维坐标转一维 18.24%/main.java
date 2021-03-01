import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();
        formMatrix formMatrix = new formMatrix();
        int[][] matrix = formMatrix.formMatrix("[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]");

        System.out.println(main.pacificAtlantic(matrix));

    }

    int Rows;
    int Cols;

    int[][] dir = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        Rows = matrix.length;
        if (Rows == 0)
            return res;
        Cols = matrix[0].length;
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        for (int row = 0; row < Rows; ++row) {
            boolean[][] visitedA = new boolean[Rows][Cols];
            dfs(setA, matrix, visitedA, row, 0, -1);
            boolean[][] visitedB = new boolean[Rows][Cols];
            dfs(setB, matrix, visitedB, row, Cols - 1, -1);
        }
        for (int col = 0; col < Cols; ++col) {
            boolean[][] visitedA = new boolean[Rows][Cols];
            dfs(setA, matrix, visitedA, 0, col, -1);
            boolean[][] visitedB = new boolean[Rows][Cols];
            dfs(setB, matrix, visitedB, Rows - 1, col, -1);
        }

        for (int index : setA) {
            if (setB.contains(index)) {
                List<Integer> cache = new ArrayList<>();
                cache.add(index / Cols);
                cache.add(index % Cols);
                res.add(cache);
            }
        }
        return res;
    }

    public void dfs(Set<Integer> set, int[][] matrix, boolean[][] visited, int row, int col, int preVal) {
        if (row < 0 || col < 0 || row >= Rows || col >= Cols || visited[row][col] || matrix[row][col] < preVal || set.contains(row * Cols + col))
            return;
        visited[row][col] = true;
        set.add(row * Cols + col);
        for (int[] d : dir) {
            dfs(set, matrix, visited, row + d[0], col + d[1], matrix[row][col]);
        }
    }


}
