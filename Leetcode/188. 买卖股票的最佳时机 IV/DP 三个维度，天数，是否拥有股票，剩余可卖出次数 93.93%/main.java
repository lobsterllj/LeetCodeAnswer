public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] ints = new int[]{7, 5, 6, 4};
        int[] prices = new int[]{3, 2, 6, 5, 0, 3};
        System.out.println(main.maxProfit(2, prices));
    }

    public int maxProfit(int k, int[] prices) {
        if (k == 0)
            return 0;
        int days = prices.length;
        if (days == 0)
            return 0;
        k = Math.min(k, days >>> 1);
        int[][][] dp = new int[days][2][k + 1];
        //三个维度分别代表 天数 当天持有1/当天不持有0 当天可卖出次数
        for (int i = 0; i <= k; ++i) {
            dp[0][1][i] = -prices[0];
        }

        for (int i = 1; i < days; ++i) {
            //从次数0至次数k，遍历每一天所有可卖出次数的情况
            for (int j = 0; j <= k; ++j) {
                //当天不持有的情况
                if (j < k) {
                    //发生过交易
                    //今天卖的or今天之前卖的
                    dp[i][0][j] = Math.max(dp[i - 1][1][j + 1] + prices[i], dp[i - 1][0][j]);
                } else {
                    //没发生过交易
                    dp[i][0][j] = dp[i - 1][0][j];
                }
                //当天持有股票
                //今天买的or今天之前买的
                dp[i][1][j] = Math.max(dp[i - 1][0][j] - prices[i], dp[i - 1][1][j]);
            }
        }

        //最大收益一定出现在最后一天不持有股票的情况
        //但是把交易次数用光不一定获得最大收益
        //遍历所有交易次数情况
        int res = 0;
        for (int i = 0; i <= k; ++i) {
            res = Math.max(dp[days - 1][0][i], res);
        }

        return res;

    }

}

