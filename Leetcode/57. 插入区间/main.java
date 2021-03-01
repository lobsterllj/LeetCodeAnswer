import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[][] ints1 = new int[][]{{1, 5}};
        int[] ints2 = new int[]{2, 7};
        int[][] res = main.insert(ints1, ints2);
        for (int i = 0; i < res.length; ++i) {

            System.out.println(i + ": " + res[i][0] + "-" + res[i][1]);
        }

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0)
            return new int[][]{newInterval};
        List<int[]> res_list = new LinkedList<>();
        int left_insert = newInterval[0];
        int right_insert = newInterval[1];
        int newleft = left_insert, newright = right_insert;
        int index = 0;
        for (int i = 0; i < intervals.length; ++i) {
            //phrase1
            if (newleft > intervals[i][1]) {
                res_list.add(intervals[i]);
            }
            //phrase2
            else if (newleft > intervals[i][0]) {
                newleft = intervals[i][0];
            }
            if (newright < intervals[i][1] || i == intervals.length - 1) {
                if (newright < intervals[i][0]) {
                    res_list.add(new int[]{newleft, newright});
                    index = i;

                } else {
                    if (newright < intervals[i][1]) {
                        res_list.add(new int[]{newleft, intervals[i][1]});
                    } else {
                        res_list.add(new int[]{newleft, newright});
                    }
                    index = ++i;
                }
                break;
            }
        }
        //phrase3
        for (int i = index; i < intervals.length; ++i) {
            res_list.add(intervals[i]);
        }

        int[][] res = new int[res_list.size()][2];
        for (int j = 0; j < res_list.size(); ++j) {
            res[j] = res_list.get(j);
        }

        return res;
    }

}





