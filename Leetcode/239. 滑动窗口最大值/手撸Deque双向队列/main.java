import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        int[] ints=new int[]{1,3,-1,-3,5,3,6,7};
        int[] res=main.maxSlidingWindow(ints,3);
        for(int it:res){
            System.out.println(it);
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0)
            return new int[]{};
        int[] res=new int[nums.length-k+1];
        Deque<Integer> slide=new ArrayDeque<>();
        for(int i=0;i<nums.length;++i){
            while (!slide.isEmpty()&&nums[i]>=nums[slide.getLast()]){
                slide.pollLast();
            }
            slide.addLast(i);
            if(slide.peekFirst()<i-k+1){
                slide.pollFirst();
            }
            if(i>k-2){
                res[i-k+1]=nums[slide.peekFirst()];
            }
        }
        return res;
    }
    public int[] maxSlidingWindow_n2(int[] nums, int k) {
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





