import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;
import java.util.concurrent.DelayQueue;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] ints = new int[]{0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        System.out.println(main.findRepeatNumber(ints));
    }

    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] != i) {
                for (int j = 0; j < nums.length; ++j)
                    System.out.print(nums[j] + " ");
                System.out.println();
                if (nums[i] == nums[nums[i]])
                    return nums[i];
                int cache = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = cache;
            }
        }
        return -1;
    }

}
