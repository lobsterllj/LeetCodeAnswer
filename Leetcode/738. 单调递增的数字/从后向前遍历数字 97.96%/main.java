import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        System.out.println(main.monotoneIncreasingDigits(332));
    }

    public int monotoneIncreasingDigits(int N) {
        if (N == 0)
            return 0;
        Deque<Integer> stack=new LinkedList<>();
        while (N != 0) {
            stack.addFirst(N % 10);
            N /= 10;
        }
        int len = stack.size();
        int[] res = new int[len];
        int index = len - 1;
        int index9 = len;

        while (!stack.isEmpty()){
            res[index] = stack.pollLast();
            if (index < len - 1 && res[index] > res[index + 1]) {
                res[index]--;
                index9 = index + 1;
            }
            index--;
        }

        for (int i = index9; i < len; ++i)
            res[i] = 9;
        int cnt=0;

        for(int it:res)
            cnt=10*cnt+it;

        return cnt;
    }


}

