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
        long[] prefixes_sum=new long[nums.length+1];
        prefixes_sum[0]=0;
        for(int i=0;i<prefixes_sum.length-1;++i){
            prefixes_sum[i+1]=prefixes_sum[i]+nums[i];
        }
        int res=0;
        for(int j=0;j<prefixes_sum.length-1;++j){
            for(int i=j;i<prefixes_sum.length-1;++i){
                if(betweenLU(prefixes_sum[i+1]-prefixes_sum[j],lower,upper))
                    res++;
            }
        }
        return res;
    }

    public int countRangeSum2(int[] nums, int lower, int upper) {
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





