import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();
        formMatrix formMatrix = new formMatrix();

        String s = "  0000000000012345678";
        System.out.println(main.myAtoi(s));

        String s1 = "00000-42a1234";
        System.out.println(main.myAtoi(s1));

        String s2 = "words and 987";
        System.out.println(main.myAtoi(s2));

        String s3 = "";
        System.out.println(main.myAtoi(s3));

        String s4 = " ";
        System.out.println(main.myAtoi(s4));
    }

    public int myAtoi(String s) {
        long res = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        if (len == 0)
            return 0;
        long max = Integer.MAX_VALUE;
        long min = -((long) Integer.MIN_VALUE);
        List<Integer> ints = new ArrayList<>();
        boolean isNegetive = false;
        int begin = -1;
        for (int i = 0; i < len; ++i) {
            if (begin == -1 && chars[i] >= '0' && chars[i] <= '9') {
                begin = i;
                break;
            }
            if (chars[i] == '+') {
                begin = i + 1;
                break;
            } else if (chars[i] == '-') {
                isNegetive = true;
                begin = i + 1;
                break;
            }
            if (chars[i] == '.' || (chars[i] >= 'a' && chars[i] <= 'z') || (chars[i] >= 'A' && chars[i] <= 'Z')) {
                return 0;
            }
        }
        if (begin == -1)
            return 0;
        for (int i = begin; i < len; ++i) {
            if (chars[i] < '0' || chars[i] > '9') {
                break;
            }
            if (chars[i] >= '0' && chars[i] <= '9') {
                ints.add(chars[i] - '0');
            }

        }
//        System.out.println(ints);
        for (int it : ints) {
            if (!isNegetive) {
                res = 10 * res + it;
                if (res > max) {
                    res = max;
                    break;
                }
            } else {
                res = 10 * res + it;
                if (res > min) {
                    res = min;
                    break;
                }
            }
        }
        if (isNegetive) {
            res = -res;
        }
        return (int) res;
    }

}