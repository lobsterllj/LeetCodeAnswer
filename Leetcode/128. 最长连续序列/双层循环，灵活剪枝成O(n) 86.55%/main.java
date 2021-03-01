import java.util.*;
import java.util.concurrent.DelayQueue;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] ints = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(main.longestConsecutive(ints));

    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        Set<Integer> num_set = new HashSet<>();
        for (int it : nums)
            num_set.add(it);
        int max;
        int res = 1;
        int cache;
        for (int it : num_set) {
            if (!num_set.contains(it - 1)) {
                max = 1;
                cache = it + 1;
                while (num_set.contains(cache)) {
                    max++;
                    cache++;
                }
                res = Math.max(max, res);
            }
        }
        return res;
    }


}
