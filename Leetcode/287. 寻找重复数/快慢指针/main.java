import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        int[] ints=new int[]{1,3,4,2,2};
        System.out.println(main.findDuplicate(ints));
    }

    public int findDuplicate(int[] nums) {
        int fast=0;
        int slow=0;
        while(true){
            fast=nums[nums[fast]];
            slow=nums[slow];
            if(fast==slow){
                fast=0;
                while (fast!=slow){
                    fast=nums[fast];
                    slow=nums[slow];
                }
                return fast;
            }
        }
    }

}





