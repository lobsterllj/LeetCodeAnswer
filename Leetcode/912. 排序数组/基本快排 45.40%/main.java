import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();


        int[] nums = new int[]{1, 3, 8, 4, 6, 2};
        prtInts.prt(nums);

        main.sortArray(nums);
        prtInts.prt(nums);

    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int partitionIndex = partition(nums, left, right);
        quickSort(nums, left, partitionIndex - 1);
        quickSort(nums, partitionIndex + 1, right);

    }

    public int partition(int[] nums, int left, int right) {
        int pivotIndex = new Random().nextInt(right - left + 1) + left;
        int pivotVal = nums[pivotIndex];

        int ltPivot = left;
        swap(nums, pivotIndex, left);

        //all in [left+1,ltPivot] 小于 pivotVal
        for (int i = left; i <= right; ++i) {
            if (nums[i] < pivotVal) {
                ltPivot++;
                swap(nums, i, ltPivot);
            }
        }

        //all in [left, ltPivot - 1] 小于 pivotVal
        //ltPivot 等于pivotVal
        //all in [ltPivot + 1, right] 大于等于 pivotVal
        swap(nums, left, ltPivot);
        return ltPivot;

    }

    public void swap(int[] nums, int i1, int i2) {
        int cache = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = cache;
    }


}
