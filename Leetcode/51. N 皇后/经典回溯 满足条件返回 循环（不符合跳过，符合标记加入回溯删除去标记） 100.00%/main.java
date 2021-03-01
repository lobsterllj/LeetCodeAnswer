import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();

        System.out.println(main.solveNQueens(4));

    }

    int n;

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 1) {
            List<String> cache = new ArrayList<>();
            cache.add("Q");
            res.add(cache);
            return res;
        }
        if (n == 2 || n == 3) {
            return res;
        }

        String[] strings = new String[n];
        for (int i = 0; i < n; ++i) {
            StringBuilder strB = new StringBuilder();
            for (int j = 0; j < n; ++j) {
                if (i == j)
                    strB.append('Q');
                else
                    strB.append('.');
            }
            strings[i] = strB.toString();
        }

        this.n = n;
        boolean[] RowVisited = new boolean[n];
        boolean[] ColVisited = new boolean[n];
        boolean[] IncVisited = new boolean[2 * n - 1];
        boolean[] DecVisited = new boolean[2 * n - 1];
        List<String> cache = new ArrayList<>();

        backTracking(res, cache, RowVisited, ColVisited, IncVisited, DecVisited, strings, 0);

        return res;
    }

    public void backTracking(List<List<String>> res, List<String> cache, boolean[] RowVisited, boolean[] ColVisited, boolean[] IncVisited, boolean[] DecVisited, String[] strings, int row) {
        // 凑满了n行
        if (cache.size() == n) {
            List<String> temp = new ArrayList<>(cache);
            res.add(temp);
            return;
        }

        if (row >= n) {
            return;
        }

        for (int col = 0; col < n; ++col) {
            // 在[row,col] == "Q" 此行不可添加入结果
            if (RowVisited[row] || ColVisited[col] || IncVisited[row + col] || DecVisited[row - col + n - 1]) {
                continue;
            }

            RowVisited[row] = true;
            ColVisited[col] = true;
            IncVisited[row + col] = true;
            DecVisited[row - col + n - 1] = true;
            cache.add(strings[col]);
            backTracking(res, cache, RowVisited, ColVisited, IncVisited, DecVisited, strings, row + 1);
            cache.remove(cache.size() - 1);
            RowVisited[row] = false;
            ColVisited[col] = false;
            IncVisited[row + col] = false;
            DecVisited[row - col + n - 1] = false;

        }

    }

}
