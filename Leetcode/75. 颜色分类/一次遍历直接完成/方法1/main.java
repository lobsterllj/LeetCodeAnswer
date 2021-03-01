import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] ints=new int[]{1,2,0};
        main.sortColors(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public void sortColors(int[] nums) {
        int f0=0;
        int f2=nums.length-1;
        for (int i=0;i<nums.length;++i){
            if(nums[i]==0){
                swap(nums,i,f0);
                f0++;
            }
            else if(nums[i]==2){
                while(nums[i]==2&&f2>=i){
                    swap(nums,i,f2);
                    f2--;
                }
                if(nums[i]==0){
                    swap(nums,i,f0);
                    f0++;
                }
            }
//            System.out.println("===========");
//            for (int k = 0; k < nums.length; k++) {
//                System.out.println("k:"+nums[k]);
//            }
        }
    }
    public void swap(int[] nums,int i,int j){
        int cache=nums[j];
        nums[j]=nums[i];
        nums[i]=cache;
    }

}





