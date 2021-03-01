import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[][] ints = new int[][]{
                {1, 2}, {2, 3}
        };
        int[][] ints1 = new int[][]{
                {0, 2},
                {1, 3},
                {2, 4},
                {3, 5},
                {4, 6}
        };

        System.out.println(main.eraseOverlapIntervals(ints1));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;
        if (len < 2)
            return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                if (ints[0] == t1[0])
                    return ints[1] - t1[1];
                return ints[0] - t1[0];
            }
        });

        int cur = 1;
        int pre = 0;
        int res = 0;
        while (cur < len) {
            System.out.println("pre:" + intervals[pre][0]+" "+intervals[pre][1]);
            System.out.println("cur:" + intervals[cur][0]+" "+intervals[cur][1]);
            if (intervals[pre][1] > intervals[cur][0]) {
                System.out.println("delete:" + cur);
                res++;
                if (intervals[pre][1] > intervals[cur][1]) {
                    //pre的右端比index的右端还要大
                    //删除pre
                    pre = cur;
                }
                //如果pre的右端比index的右端小
                //删除index
            }
            else {
                pre = cur;
            }
            cur++;
        }
        return res;
    }


}

