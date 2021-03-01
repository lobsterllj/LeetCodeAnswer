import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();

//        int[] nums = new int[]{1, 2, 3, 1};
//        int k = 3;
//        int t = 0;
//        System.out.println(main.containsNearbyAlmostDuplicate(nums, k, t));

        int[] nums1 = new int[]{1, 2};
        int k1 = 0;
        int t1 = 1;
        System.out.println(main.containsNearbyAlmostDuplicate(nums1, k1, t1));

    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k == 0)
            return false;
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            long it = nums[i];
            //找到treeSet中小于等于当前元素it的最大元素
            Long floor = treeSet.floor(it);
            if (floor != null && floor >= it - t)
                return true;

            //找到treeSet中大于等于当前元素it的最小元素
            Long ceiling = treeSet.ceiling(it);
            if (ceiling != null && ceiling <= it + t)
                return true;

            if (treeSet.size() == k)
                treeSet.remove((long) nums[i - k]);
            treeSet.add(it);

        }
        return false;
    }


}




