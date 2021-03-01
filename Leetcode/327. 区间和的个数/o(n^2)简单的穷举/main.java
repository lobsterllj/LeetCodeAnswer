import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        int[] nums = new int[]{-2, 5, -1};
        int lower = -2, upper = 2;
//        System.out.println("Integer.MIN_VALUE:" + Integer.MIN_VALUE);
//        System.out.println("Integer.MAX_VALUE:" + Integer.MAX_VALUE);

        System.out.println(main.countRangeSum(nums, lower, upper));

    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums.length == 0)
            return 0;
        int cnt_intervals = 0;
        long rangesum = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i; j < nums.length; ++j) {
                if (betweenLU(rangesum + nums[j], lower, upper)) {
                        cnt_intervals++;
                }
                rangesum += nums[j];
            }
            rangesum = 0;
        }
        return cnt_intervals;
    }

    public boolean betweenLU(long in, int low, int upp) {
        return (in > low - 1) && (in < upp + 1);
    }



}





