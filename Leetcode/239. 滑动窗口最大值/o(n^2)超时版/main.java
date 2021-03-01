import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        int[] ints=new int[]{1,-1};
        int[] res=main.maxSlidingWindow(ints,1);
        for(int it:res){
            System.out.println(it);
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0)
            return new int[]{};
        int[] res=new int[nums.length-k+1];
        for(int i=0;i< res.length;++i){
            res[i]=Integer.MIN_VALUE;
        }
        for(int i=0;i< nums.length-k+1;++i){
            for (int j=i;j<i+k;++j){
                if(nums[j]>res[i])
                    res[i]=nums[j];
            }
        }
        return res;
    }

}





