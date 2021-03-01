import java.util.*;
import java.util.concurrent.DelayQueue;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] ints = new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(main.lengthOfLIS(ints));

    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int res=1;
        for (int i = 0; i < nums.length; ++i) {
            int max = 0;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]);

                }
            }
            dp[i] += max;
            res=Math.max(dp[i],res);
//            for (int i1 = 0; i1 < dp.length; i1++) {
//                System.out.print(dp[i1] + " ");
//            }
//            System.out.println();
        }
        return res;
    }


}
