import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        System.out.println(main.removeKdigits("1234567890", 9));
    }

    public String removeKdigits(String num, int k) {
        char[] chars = num.toCharArray();
        Deque<Integer> cache = new ArrayDeque<>();
        for (int i = 0; i < chars.length; ++i) {
            while (cache.size() > 0 && k > 0 && cache.peekLast() > chars[i] - '0') {
                cache.pollLast();
                k--;
            }
            cache.addLast(chars[i] - '0');
        }


        while (k > 0) {
            cache.pollLast();
            k--;
        }

        StringBuilder res = new StringBuilder();
        boolean flag = false;
        while (!cache.isEmpty()) {
            if (!flag) {
                int temp = cache.pollFirst();
                if (temp != 0) {
                    flag = true;
                    res.append(temp);
                }
            }
            else {
                res.append(cache.pollFirst());
            }
        }
        if (!flag)
            return "0";
        return res.toString();
    }


}

