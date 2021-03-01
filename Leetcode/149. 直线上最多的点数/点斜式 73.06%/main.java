import java.sql.SQLOutput;
import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[][] ints=new int[][]{{1,1},{2,2},{3,3}};
        System.out.println(main.maxPoints(ints));

    }

    public int maxPoints(int[][] points) {
        if (points.length < 3)
            return points.length;
        int index = 0;
        for (; index < points.length; ++index) {
            if ((points[index][0] != points[0][0]) || (points[index][1] != points[0][1]))
                break;
        }
        if (index == points.length)
            return points.length;
        int res = 0;
        for (int i = 0; i < points.length; ++i) {
            Map<String, Integer> k_cnt = new HashMap<>();
            int MaxCnts = 0;
            int duplicata = 0;
            for (int j = i + 1; j < points.length; ++j) {
                if ((points[j][0] == points[i][0]) && (points[j][1] == points[i][1])) {
                    duplicata++;
                    continue;
                }
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                int g = gcb(y, x);
                x = x / g;
                y = y / g;
                String key = y + "@" + x;
                int cache = k_cnt.getOrDefault(key, 0);
                k_cnt.put(key, cache + 1);
                MaxCnts = Math.max(MaxCnts, k_cnt.get(key));
            }
            res = Math.max(res, MaxCnts + duplicata + 1);
        }
        return res;
    }

    public int gcb(int a, int b) {
        while (b != 0) {
            int cache = b;
            b = a % b;
            a = cache;
        }
        return a;
    }
}
