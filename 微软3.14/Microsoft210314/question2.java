package Microsoft210314;

import java.util.*;

public class question2 {
    public static void main(String[] args) {
        question2 solution2 = new question2();
//1
//        int[] A = new int[]{2, 1};
//        int[] P = new int[]{5, 1};
//        int B = 3;
//        int E = 6;
//2
//        int[] A = new int[]{2, 1};
//        int[] P = new int[]{5, 1};
//        int B = 2;
//        int E = 6;
//3
//        int[] A = new int[]{1, 4, 2};
//        int[] P = new int[]{10, 4, 7};
//        int B = 11;
//        int E = 1;
//4
//        int[] A = new int[]{5, 5, 1};
//        int[] P = new int[]{3, 3, 6};
//        int B = 4;
//        int E = 8;
//5
        int[] A = new int[]{1, 3};
        int[] P = new int[]{2, 6};
        int B = 1;
        int E = 5;


        System.out.println(solution2.solution(A, P, B, E));
    }

    public boolean solution(int[] A, int[] P, int B, int E) {
        // write your code in Java SE 8
        List<List<Integer>> blocks = new ArrayList<>();
        int numsOfCranes = P.length;
        for (int i = 0; i < numsOfCranes; ++i) {
            List<Integer> cache = new ArrayList<>(2);
            cache.add(P[i] - A[i]);
            cache.add(P[i] + A[i]);
            blocks.add(cache);
        }

        blocks.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int o1left = o1.get(0);
                int o1right = o1.get(1);
                int o2left = o2.get(0);
                int o2right = o2.get(1);
                if (o1left == o2left) {
                    return o2right - o1right;
                } else {
                    return o1left - o2left;
                }
            }
        });
//        System.out.println(blocks);

        List<List<Integer>> Mergedblocks = new ArrayList<>();
        int sta = blocks.get(0).get(0);
        int end = blocks.get(0).get(1);
        for (int i = 1; i < numsOfCranes; ++i) {
            int left = blocks.get(i).get(0);
            int right = blocks.get(i).get(1);
            if (end < left) {
                List<Integer> cache = new ArrayList<>(2);
                cache.add(sta);
                cache.add(end);
                Mergedblocks.add(cache);
                sta = left;
                end = right;
            } else if (end < right) {
                end = right;
            }
        }
        List<Integer> cache = new ArrayList<>(2);
        cache.add(sta);
        cache.add(end);
        Mergedblocks.add(cache);

//        System.out.println(Mergedblocks);

        for (int i = 0; i < numsOfCranes; ++i) {
            int left = Mergedblocks.get(i).get(0);
            int right = Mergedblocks.get(i).get(1);
            if (B >= left && B <= right && E >= left && E <= right) {
                return true;
            }
        }

        return false;
    }

}
