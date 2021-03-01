public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] ints = new int[]{5, 3, 1, 4, 2};
        System.out.println(main.stoneGameVII(ints));
    }

    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[][] sum = new int[n][n];
        //sum[i][j] 表示从索引i到索引j的元素之和
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (j == i)
                    sum[i][j] = stones[i];
                else {
                    sum[i][j] = stones[j] + sum[i][j - 1];
                }
            }
        }
        int[][] dp = new int[n][n];

        //dp[i][j]表示此时先选的人（假设为甲），另一个人（乙），从索引i至j的范围内的（甲收益-乙收益）的最大值
        //当[i,j]只包含两个元素时，先选的删掉最小的的并拿走最大的，后选的没选，故此时dp[i][j]应为两个元素的最大值
        //以 [2，3，4] 为例
        //dp[0][1]=3   dp[1][2]=4
        //sum[0][1]=5   sum[1][2]=7
        //甲让乙扔掉最大的，那么甲、乙这一轮结束后，甲收益-乙收益最大
        //甲可以从2或者4中选择一个扔掉
        //甲如果扔掉了2，则乙必须让此时dp[1][2]最大，乙扔掉的便是sum[1][2]-dp[1][2]=3
        //甲如果扔掉了4，则乙必须让此时dp[0][1]最大，乙扔掉的便是sum[0][1]-dp[0][1]=2

        //倒序开始[n-2][n-1]慢慢扩展至[0][n-1]
        for (int i = n - 2; i > -1; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (i == j - 1)
                    dp[i][j] = Math.max(stones[i], stones[j]);
                else {
                    dp[i][j] = Math.max(sum[i + 1][j] - dp[i + 1][j], sum[i][j - 1] - dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }


}
