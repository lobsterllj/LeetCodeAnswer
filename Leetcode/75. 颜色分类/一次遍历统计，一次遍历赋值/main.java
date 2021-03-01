import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] ints=new int[]{2,0,2,1,1,0};
        main.sortColors(ints);
    }

    public void sortColors(int[] nums) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < nums.length; ++i) {
            switch (nums[i]) {
                case 0:
                    cnt0++;
                    break;
                case 1:
                    cnt1++;
                    break;
                case 2:
                    cnt2++;
                    break;
            }
        }
        for(int i=0;i<cnt0;++i){
            nums[i]=0;
        }
        for(int i=cnt0;i<cnt0+cnt1;++i){
            nums[i]=1;
        }
        for(int i=cnt0+cnt1;i<cnt0+cnt1+cnt2;++i){
            nums[i]=2;
        }
    }

}





