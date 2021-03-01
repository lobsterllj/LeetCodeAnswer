import java.util.HashSet;
import java.util.Set;

public class main {
    public static void main(String[] args) {
        main aa = new main();
        int[] ints = new int[]{1,0,2,3,0,4,5,0};
        aa.moveZeroes(ints);
        for (int it : ints) {
            System.out.println(it);
        }
    }

    public void moveZeroes(int[] nums) {
        if (nums.length != 0) {
            int index = 0;
            for (int i=0;i<nums.length;++i)
            {
                if(nums[i]!=0)
                {
                    nums[index]=nums[i];
                    index++;
                }
            }
            for(int i=index;i<nums.length;++i)
            {
                nums[i]=0;
            }
        }
        return;
    }
}
