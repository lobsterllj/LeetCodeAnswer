import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        int[][] costs = new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        System.out.println(main.twoCitySchedCost(costs));
    }

    public int twoCitySchedCost(int[][] costs) {
        int res = 0;
        int n = costs.length;
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
        for (int i = 0; i < n / 2; ++i) {
            res+=costs[i][0];
            System.out.println(costs[i][0] + " " + costs[i][1]);
        }
        for (int i = n / 2; i < n; ++i) {
            res+=costs[i][1];
            System.out.println(costs[i][0] + " " + costs[i][1]);
        }
        return res;
    }


}

