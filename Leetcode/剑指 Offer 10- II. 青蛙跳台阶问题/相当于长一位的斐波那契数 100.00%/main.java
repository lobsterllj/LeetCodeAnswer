import java.math.BigInteger;
public class main {

    public static void main(String[] args) {
        main main = new main();
//        for (int i = 0; i < 201; ++i)
//            System.out.println("i:" + i + " fib: " + main.numWays(i));
        System.out.println(" fib: " + main.numWays(7));

    }

    BigInteger zero = new BigInteger("0");
    BigInteger e9 = new BigInteger("1000000007");

    public int numWays(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        n++;
        BigInteger[] fibs_b = new BigInteger[n + 1];
        for (int i = 0; i < n + 1; ++i) {
            fibs_b[i] = new BigInteger("0");
        }
        fibs_b[0] = new BigInteger("0");
        fibs_b[1] = new BigInteger("1");

        for (int i = 2; i <= n; ++i) {
            step(i, fibs_b);
        }
        String res_str = (fibs_b[n].remainder(e9)).toString();
        return Integer.valueOf(res_str);
    }
    public void step(int n, BigInteger[] fibs) {
        if (!fibs[n].equals(zero))
            return;
        fibs[n] = fibs[n - 1].add(fibs[n - 2]);
    }


    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        BigInteger[] fibs_b = new BigInteger[n + 1];
        for (int i = 0; i < n + 1; ++i) {
            fibs_b[i] = new BigInteger("0");
        }
        fibs_b[0] = new BigInteger("0");
        fibs_b[1] = new BigInteger("1");

        for (int i = 2; i <= n; ++i) {
            recurb(i, fibs_b);
        }
        String res_str = (fibs_b[n].remainder(e9)).toString();
        return Integer.valueOf(res_str);

    }

    public void recurb(int n, BigInteger[] fibs) {
        if (!fibs[n].equals(zero))
            return;
        fibs[n] = fibs[n - 1].add(fibs[n - 2]);
    }

}
