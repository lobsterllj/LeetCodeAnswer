import java.util.*;
import java.util.concurrent.DelayQueue;

public class main {

    public static void main(String[] args) {
        main main = new main();
        System.out.println(main.numSquares(5));

    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; ++i) {
            dp[i] = i;
            for (int j = 1; j * j <= i; ++j)
                dp[i] = Math.min(dp[i], dp[i -( j * j)] + 1);
        }
        return dp[dp.length - 1];
    }


}
