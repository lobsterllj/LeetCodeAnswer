public class main {

    public static void main(String[] args) {
        main main = new main();
        System.out.println(main.movingCount(3, 3, 2));
    }

    int row_nums;
    int col_nums;

    public int movingCount(int m, int n, int k) {
        if (k == 0)
            return 1;
        row_nums = m;
        col_nums = n;
        boolean[][] visited = new boolean[m][n];
        int res = stepIn(visited, 0, 0, k);
        return res;
    }

    public int stepIn(boolean[][] visited, int row, int col, int k) {
        System.out.println("row: " + row + "   col:" + col + "  k:" + k);
        for (int i = 0; i < row_nums; ++i) {
            for (int j = 0; j < col_nums; ++j) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
        if (row < 0 || row >= row_nums || col < 0 || col >= col_nums || visited[row][col] || !canIn(row, col, k))
            return 0;
        visited[row][col] = true;
        return stepIn(visited, row + 1, col, k) + stepIn(visited, row - 1, col, k)
                + stepIn(visited, row, col + 1, k) + stepIn(visited, row, col - 1, k) + 1;

    }

    public boolean canIn(int row, int col, int k) {
        int res = 0;
        while (row != 0) {
            res += row % 10;
            row /= 10;
        }
        while (col != 0) {
            res += col % 10;
            col /= 10;
        }
        return res <= k;
    }

}
