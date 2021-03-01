
public class main {

    public static void main(String[] args) {
        main main = new main();
        String s = "aaaa";
        System.out.println(main.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;
        char[] chars = s.toCharArray();
        int begin = 0;
        int maxLen = 1;
        boolean[][] isPal = new boolean[len][len];
        for (int i = 0; i < len; ++i)
            isPal[i][i] = true;

        //以此判断char[row,col]是否回文串
        for (int col = 1; col < len; ++col) {
            for (int row = 0; row < col; row++) {
                System.out.println("row" + row + "col" + col);
                if (chars[row] != chars[col]) {
                    isPal[row][col] = false;
                } else {
                    if (col - row < 3) {
                        isPal[row][col] = true;
                    } else {
                        isPal[row][col] = isPal[row + 1][col - 1];
                    }
                }

                if (isPal[row][col] && col - row + 1 > maxLen) {
                    maxLen = col - row + 1;
                    begin = row;
                }
            }
        }
        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; ++col) {
                System.out.print(isPal[row][col] + " ");
            }
            System.out.println();
        }
        return s.substring(begin, begin + maxLen);
    }

}
