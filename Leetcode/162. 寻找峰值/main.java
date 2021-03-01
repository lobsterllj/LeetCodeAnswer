import javax.sound.midi.Soundbank;
import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        int[] ints=new int[]{1,2,3,1};
        System.out.println(main.findPeakElement(ints));

    }

    public int findPeakElement(int[] nums) {
        if(nums.length<2)
            return 0;
        for(int i=1;i<nums.length;++i){
            if(nums[i]<nums[i-1]){
                return i-1;
            }
        }
        return nums.length-1;
    }

}





