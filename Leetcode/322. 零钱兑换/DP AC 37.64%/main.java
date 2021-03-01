import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;
import java.util.concurrent.DelayQueue;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] coins = new int[]{1, 2, 5, 10};
        System.out.println(main.coinChange(coins, 17));

    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        Arrays.sort(coins);

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        for (int i = 1; i < dp.length; ++i) {
            int cache = find(coins, i);
            if (cache == i)
                dp[i] = 1;
            else if (cache < i) {
                if (cache == -1) {
                    dp[i] = -1;
                    continue;
                }
                int temp = Integer.MAX_VALUE;
                boolean unreach = true;
                for (int it : coins) {
                    if (i - it > 0&&dp[i - it] > 0) {
                        unreach = false;
                        temp = Math.min(temp, dp[i - it]);
                    }
                }
                if (!unreach)
                    dp[i] = 1 + temp;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print("dp" + i + ":" + dp[i] + " ");
        }
        System.out.println();
        return dp[dp.length - 1];
    }

    public int find(int[] coins, int tar) {
        int res = -1;
        for (int i = coins.length - 1; i > -1; --i) {
            if (coins[i] <= tar) {
                res = coins[i];
                break;
            }
        }
        return res;
    }
}
