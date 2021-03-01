import java.util.PriorityQueue;

public class main {

    public static void main(String[] args) {
        main main = new main();
        System.out.println(main.countDigitOne(20));
    }

    public int countDigitOne(int n) {
        int digit = 1;
        int cur = n % 10;
        int high = n / 10;
        int low = 0;
        int res = 0;
        while (cur != 0 || high != 0) {
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                res += (high * digit + low) + 1;
            } else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }

}

