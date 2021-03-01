import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        int[] ints=new int[]{1,3,2};
        main.nextPermutation(ints);
        int i=0;
        while(i<3){
            System.out.println(ints[i++]);
        }
    }

    public void nextPermutation(int[] nums) {
        if(nums.length<2)
            return;
        int index=nums.length-1;
        while (index>0){
            if(nums[index-1]<nums[index]){
                int unexIndex=0;
                for(int k=index;k<nums.length;++k){
                    if(nums[k]>nums[index-1]){
                        unexIndex=k;
                    }
                    else {
                        break;
                    }
                }
                exchange(nums,index-1,unexIndex);
                Arrays.sort(nums,index,nums.length);
                break;
            }
            --index;
        }
        if(index==0)
            Arrays.sort(nums);
    }
    public void exchange(int[] nums,int i,int j){
        int cache=nums[i];
        nums[i]=nums[j];
        nums[j]=cache;
    }
}





