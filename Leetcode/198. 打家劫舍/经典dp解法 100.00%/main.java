import java.util.*;
import java.util.concurrent.DelayQueue;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] ints = new int[]{2, 7, 9, 3, 1};
        System.out.println(main.rob(ints));

    }

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            dp[i + 1] = Math.max(dp[i], (nums[i] + dp[i - 1]));
        }
        return dp[dp.length-1];
    }


}
