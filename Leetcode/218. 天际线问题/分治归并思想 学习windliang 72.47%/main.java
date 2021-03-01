import org.w3c.dom.Node;

import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();

    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings.length == 0)
            return new LinkedList<>();
        return merge(buildings, 0, buildings.length - 1);
    }

    public List<List<Integer>> merge(int[][] buildings, int start, int end) {
        List<List<Integer>> res = new LinkedList<>();
        if (start == end) {
            List<Integer> cache = new LinkedList<>();
            cache.add(buildings[start][0]);
            cache.add(buildings[start][2]);
            res.add(cache);

            cache = new LinkedList<>();
            cache.add(buildings[start][1]);
            cache.add(0);
            res.add(cache);

            return res;
        }

        int mid = (start + end) >> 1;
        List<List<Integer>> res_left = merge(buildings, start, mid);
        List<List<Integer>> res_right = merge(buildings, mid + 1, end);
        int i_left = 0, i_right = 0;
        int h_left = 0, h_right = 0;

        while (i_left < res_left.size() || i_right < res_right.size()) {
            long x1 = i_left < res_left.size() ? res_left.get(i_left).get(0) : Long.MAX_VALUE;
            long x2 = i_right < res_right.size() ? res_right.get(i_right).get(0) : Long.MAX_VALUE;
            long x;
            int h;
            if (x1 < x2) {
                h_left = res_left.get(i_left).get(1);
                x = x1;
                i_left++;
            } else if (x1 > x2) {
                h_right = res_right.get(i_right).get(1);
                x = x2;
                i_right++;
            } else {
                h_left = res_left.get(i_left).get(1);
                h_right = res_right.get(i_right).get(1);
                x = x1;
                i_left++;
                i_right++;
            }
            h = Math.max(h_left, h_right);
            if (res.isEmpty() || res.get(res.size() - 1).get(1) != h) {
                List<Integer> cache = new LinkedList<>();
                cache.add((int) x);
                cache.add(h);
                res.add(cache);
            }
        }

        return res;
    }
}
