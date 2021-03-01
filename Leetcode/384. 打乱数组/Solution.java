import java.util.Arrays;
import java.util.Random;

public class Solution {
    int[] nums;
    int[] ori_nums;

    public Solution(int[] nums) {
        this.nums = nums;
        this.ori_nums = Arrays.copyOf(nums, nums.length);
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return this.ori_nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        Random random = new Random();
        for (int i = nums.length - 1; i > 0; --i) {
            swap(nums, random.nextInt(nums.length), i);
        }
        return nums;
    }

    private int[] swap(int[] ints, int x1, int x2) {
        int cache = ints[x1];
        ints[x1] = ints[x2];
        ints[x2] = cache;
        return ints;
    }

}
