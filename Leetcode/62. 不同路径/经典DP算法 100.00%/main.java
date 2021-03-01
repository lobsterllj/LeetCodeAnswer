import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {
        main main = new main();
        System.out.println(main.uniquePaths(3,2));
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int row = 0; row < m; ++row) {
            dp[row][0] = 1;
        }
        for (int col = 0; col < n; ++col) {
            dp[0][col] = 1;
        }
        for (int row = 1; row < m; ++row) {
            for (int col = 1; col < n; ++col) {
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


}
