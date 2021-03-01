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
            int cache_index;
            int cache_int = 0;
            while (index < nums.length) {
                cache_index = index;
                while ((cache_index < nums.length-1) && (nums[cache_index] == 0)) {
                    cache_index++;
                }
                cache_int=nums[index];
                nums[index] = nums[cache_index];
                nums[cache_index]=cache_int;
                index++;
            }
        }
        return;
    }
}
