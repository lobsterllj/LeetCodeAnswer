public class main {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        int[] prices1 = new int[]{2, 1, 2, 0, 1};
        System.out.println(main.maxProfit(prices));
        System.out.println("*****************");
        System.out.println(main.maxProfit(prices1));
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2)
            return 0;
        int[][] hold = new int[len][3];
        int[][] none = new int[len][3];
        for (int i = 0; i < 3; ++i) {
            none[0][i] = 0;
            hold[0][i] = -prices[0];
        }
        for (int i = 1; i < len; ++i) {
            for (int j = 0; j < 3; ++j) {
                hold[i][j] = Math.max(
                        none[i - 1][j] - prices[i],
                        hold[i - 1][j]
                );
            }
            for (int j = 0; j < 2; ++j) {
                none[i][j] = Math.max(
                        hold[i - 1][j + 1] + prices[i],
                        none[i - 1][j]
                );
            }
        }

        prtMatrix prtMatrix=new prtMatrix();
        prtMatrix.prtMatrix(hold);
        prtMatrix.prtMatrix(none);

        int res = 0;
        for (int i = 0; i < 3; ++i) {
            res = Math.max(none[len - 1][i], res);
        }
        return res;
    }

}

