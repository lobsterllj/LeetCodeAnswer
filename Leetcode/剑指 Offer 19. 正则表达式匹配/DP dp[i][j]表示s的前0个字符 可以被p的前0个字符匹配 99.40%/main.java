

public class main {

    public static void main(String[] args) {
        main main = new main();
        String s = "ab";
        String p = ".*";
        System.out.println(main.isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            //如果p的第i+1个字符也就是p.charAt(i)是"*"的话，
            //那么他就可以把p的第i个字符给消掉（也就是匹配0次）。
            //我们只需要判断p的第i-1个字符和s的前0个字符是否匹
            //配即可。比如p是"a*b*"，如果要判断p的第4个字符
            //"*"和s的前0个字符是否匹配，因为字符"*"可以消去
            //前面的任意字符，只需要判断p的"a*"和s的前0个字
            //符是否匹配即可
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                //默认p不以‘*’开头
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    //递推公式
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        //p的第j个字符和s的第i+1个字符不能匹配
                        //比如：s="abc"，p="abcd*"
                        //我们就让p的第j个和第j+1个字符同时消失，也就是让"d*"消失，只需要判断p的前j-1个字符和s的前i+1个字符是否匹配即可
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        //情况1:
                        //dp[i+1][j+1] = dp[i+1][j-1]
                        //类似于s="abc"，p="abcc*"; 我们就让*匹配0个，把p的"c*"砍掉，判断s="abc"和p="abc"是否匹配
                        //情况2:
                        //dp[i+1][j+1] = dp[i+1][j]
                        //类似于s="abc"，p="abc*"; 我们就让*匹配1个，把p的字符"*"砍掉，判断s="abc"和p="abc"是否匹配
                        //情况3:
                        //dp[i+1][j+1] = dp[i][j+1]
                        //类似于s="abcc"(或者s="abccc"，s="abcccc"……)，p="abc*";
                        //判断s="abc"(或者s="abcc"，s="abccc"……)和p="abc*"是否匹配
                        //把"c*"看做是一个整体，比如"abccc"的最后一个字符"c"和p的倒数第二个字符匹配成功，因为"c*"可以匹配多个
                        //我们就把"abccc"砍掉一个字符"c"，然后再判断"abcc"和"abc*"是否匹配。
                        //上面三个递推公式只要有一个为true，就表示能够匹配成功
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[m][n];
    }


}
