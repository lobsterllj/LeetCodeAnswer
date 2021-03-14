package Microsoft210314;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class question1 {
    public static void main(String[] args) {
        question1 solution = new question1();
        System.out.println(solution.solution(2123456789));
    }

    public int solution(int N) {
        // write your code in Java SE 8
        if (N < 10) {
            return N;
        }
        List<Integer> decimals = new ArrayList<>(16);
        while (N > 0) {
            int cache = N % 10;
            decimals.add(cache);
            N /= 10;
        }
        decimals.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(decimals);

        long res = 0;
        for (int i = 0; i < decimals.size(); ++i) {
            res = res * 10 + decimals.get(i);
            if (res > 100000000) {
                return -1;
            }
        }
        return (int) res;
    }

}
