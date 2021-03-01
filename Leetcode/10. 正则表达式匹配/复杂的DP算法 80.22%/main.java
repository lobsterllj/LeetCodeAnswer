public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();
        formMatrix formMatrix = new formMatrix();

        String s = "abcd";
        String p = ".*";
        System.out.println(main.isMatch(s, p));

    }

    public boolean isMatch(String s, String p) {
        prtMatrix prtMatrix = new prtMatrix();

        char[] charS = s.toCharArray();
        char[] charP = p.toCharArray();
        int lenS = charS.length;
        int lenP = charP.length;

        boolean[][] dp = new boolean[lenS + 1][lenP + 1];
        // dp[i][j] == true p的[0, j - 1]位能匹配s的[0, i - 1]位
        // 起始时 [0, 0 - 1] 为空 表示当前没有匹配的值
        // 结束时 判断dp[lenS][lenP] 即判断[0, lenS - 1] 与 [0, lenP - 1]是否匹配
        dp[0][0] = true;

        // 初始化 第偶数位为'*'时  "a*b*c*" 可以匹配 “”
        for (int i = 2; i <= lenP; i += 2) {
            if (charP[i - 1] == '*')
                dp[0][i] = dp[0][i - 2];
        }

        for (int si = 1; si <= lenS; ++si) {
            for (int pi = 1; pi <= lenP; ++pi) {
                // 想要考察 [0, si - 1] 与 [0, pi - 1] 的匹配情况
                if (charP[pi - 1] == charS[si - 1] || charP[pi - 1] == '.') {
                    // charP[pi - 1]  与 charS[si - 1] 匹配
                    dp[si][pi] = dp[si - 1][pi - 1];
                } else if (charP[pi - 1] == '*') {
                    if (dp[si][pi - 2]) {
                        // [0, pi - 3] 已匹配, charP[pi - 1] == '*' 故让'*'匹配0个字符即可满足[0, pi - 1]已匹配[0, si - 1]
                        dp[si][pi] = true;
                    } else if (charP[pi - 2] == charS[si - 1] || charP[pi - 2] == '.') {
                        // charS[si - 1] 和 charP[pi - 2] 匹配, charS[pi - 1] = '*' 故[0, si - 2]--[0, pi - 1] 的匹配状态和 [0, si - 1]--[0, pi - 1]相同
                        dp[si][pi] = dp[si - 1][pi];
                    }
                }
                System.out.println(si + "-" + pi);
                prtMatrix.prtMatrix(dp);
            }
        }
        return dp[lenS][lenP];
    }

}