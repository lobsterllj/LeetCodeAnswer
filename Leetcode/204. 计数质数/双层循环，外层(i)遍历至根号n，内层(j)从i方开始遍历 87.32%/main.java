import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        System.out.println(main.countPrimes(100));
    }

    public int countPrimes(int n) {
        if (n <= 1)
            return 0;
        boolean[] primeTable = new boolean[n + 1];
        int res = 0;
        for (int i = 2; i * i < n; i++) {
            //i = 根号n:n一定非素数
            //i > 根号n:已经保证n为素数，不必再判断之后的i
            if (!primeTable[i])
                //如果i未被改动或者为质数
                for (int j = i * i; j < n + 1; j += i) {
                    //从i*i开始，每隔i的数一定为非质数
                    //这里最小可以从i*2开始，但这样存在冗余
                    //比如 n = 25，i = 4 时算法会标记 4 × 2 = 8，4 × 3 = 12 等等数字，但是这两个数字已经被 i = 2 和 i = 3 的 2 × 4 和 3 × 4 标记了。
                    //如果j从j=i*i 即16开始，即可避免重复标记 8 和 12
                    primeTable[j] = true;
                }
        }
        for (int i = 2; i < n; ++i) {
            if (primeTable[i] == false) {
                res++;
            }
        }
        return res;
    }
}
