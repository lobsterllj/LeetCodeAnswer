import java.math.BigInteger;
import java.net.CacheRequest;
import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] nums = new int[]{3, 4, 5, 1, 2};
        System.out.println(main.findMin(nums));
    }

    public int findMin(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    public int find(int[] nums, int sta, int end) {
        if (sta == end) {
            return nums[sta];
        }
        if (sta == end - 1) {
            return Math.min(nums[sta], nums[end]);
        }
        int mid = (sta + end) >>> 1;
        if (nums[mid] > nums[sta] && nums[mid] > nums[end]) {
            return find(nums, mid + 1, end);
        } else if (nums[mid] < nums[sta] && nums[mid] < nums[end]) {
            return find(nums, sta, mid);
        } else {
            return find(nums, sta, mid - 1);
        }
    }
}
