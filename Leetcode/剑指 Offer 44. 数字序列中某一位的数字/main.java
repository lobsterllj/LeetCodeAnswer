import java.util.PriorityQueue;

public class main {

    public static void main(String[] args) {
        main main = new main();
        System.out.println(main.findNthDigit(11));
    }

    public int findNthDigit(int n) {
        int digit = 1;//位数
        int start = 1;//该位数最小的数字
        int count = 9;//该位数所有数字的个数
        while (n > count) {
            n -= count;
            digit += 1;
            start = 10 * start;
            count = 9 * start * digit;
        }
        int num = start + (n - 1) / digit;
        int res = String.valueOf(num).charAt((n - 1) % digit)-'0';
        return res;
    }

}

