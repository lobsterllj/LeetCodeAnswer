import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] ints = new int[]{7, 5, 6, 4};
        System.out.println(main.reversePairs(ints));

    }

    public int reversePairs(int[] nums) {
        if (nums.length < 2)
            return 0;
        int[] nums_copy = new int[nums.length];
        int res = mergesort(nums, nums_copy, 0, nums.length - 1);
        return res;
    }

    public int mergesort(int[] nums, int[] nums_copy, int sta, int end) {
        if (sta >= end)
            return 0;

        int mid = (sta + end) >>> 1;
        int res = 0;
        res += mergesort(nums, nums_copy, sta, mid);
        res += mergesort(nums, nums_copy, mid + 1, end);

        int i = sta;
        int j = mid + 1;
        int index = sta;

//      归并排序+计算crossRes
        int cache = 0;
        while (i <= mid && j <= end) {
            if (nums[i] > nums[j]) {
                nums_copy[index++] = nums[j];
                cache = j - mid;
                j++;
            } else {
                nums_copy[index++] = nums[i];
                res += cache;
                i++;
            }
        }
        while (i <= mid) {
            nums_copy[index++] = nums[i];
            res += cache;
            i++;
        }
        while (j <= end) {
            nums_copy[index++] = nums[j++];
        }


        for (int k = sta; k <= end; ++k) {
            nums[k] = nums_copy[k];
        }
        return res;
    }

}

