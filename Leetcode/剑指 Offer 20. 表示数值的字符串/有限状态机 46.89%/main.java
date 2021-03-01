import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        String s = "1E-16";
        System.out.println(main.isNumber(s));
    }

    //https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/solution/mian-shi-ti-20-biao-shi-shu-zhi-de-zi-fu-chuan-y-2/
    //  ‘.’出现正确情况：只出现一次，且在e的前面
    //  ‘e’出现正确情况：只出现一次，且出现前有数字
    //  ‘+’‘-’出现正确情况：只能在开头和e后一位
    public boolean isNumber(String s) {
        Map[] states = {
                new HashMap<>() {{
                    put(' ', 0);
                    put('s', 1);
                    put('d', 2);
                    put('.', 4);
                }},
                // 0

                new HashMap<>() {{
                    put('d', 2);
                    put('.', 4);
                }},
                // 1

                new HashMap<>() {{
                    put('d', 2);
                    put('.', 3);
                    put('e', 5);
                    put(' ', 8);
                }},
                // 2

                new HashMap<>() {{
                    put('d', 3);
                    put('e', 5);
                    put(' ', 8);
                }},
                // 3

                new HashMap<>() {{
                    put('d', 3);
                }},
                // 4

                new HashMap<>() {{
                    put('s', 6);
                    put('d', 7);
                }},
                // 5

                new HashMap<>() {{
                    put('d', 7);
                }},
                // 6

                new HashMap<>() {{
                    put('d', 7);
                    put(' ', 8);
                }},
                // 7

                new HashMap<>() {{
                    put(' ', 8);
                }}
                // 8
        };
        int p = 0;
        char t;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') t = 'd';
            else if (c == '+' || c == '-') t = 's';
            else if (c == 'e' || c == 'E') t = 'e';
            else if (c == '.' || c == ' ') t = c;
            else t = '?';
            if (!states[p].containsKey(t)) return false;
            p = (int) states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }


}
