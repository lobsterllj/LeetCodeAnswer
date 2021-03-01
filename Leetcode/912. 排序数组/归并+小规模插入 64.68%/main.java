import javafx.css.Size;

import java.lang.invoke.VolatileCallSite;
import java.security.PublicKey;
import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        int[] ints = new int[]{7, 6, 5, 4, 3, 2, 1};
//        main.insertionSort(ints, 1, 3);
        main.sortArray(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.println("ints = " + ints[i]);
        }

    }

    public int[] sortArray(int[] nums) {
        int[] cache = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, cache);
        return nums;
    }

    public void insertionSort(int[] nums, int left, int right) {
        if ((right - left + 1) < 2)
            return;
        int n = right - left + 1;
        for (int i = left + 1; i <= right; ++i) {
            int uninsert = nums[i];
            int j = i - 1;
            while (j >= left && nums[j] > uninsert) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = uninsert;
        }
    }

    public void mergeSort(int[] nums, int left, int right, int[] cache) {
        if (right - left + 1 <= 7) {
            insertionSort(nums, left, right);
            return;
        }
        int mid = (left + right) >>> 1;
        mergeSort(nums, left, mid, cache);
        mergeSort(nums, mid + 1, right, cache);
        if (nums[mid] == nums[mid + 1])
            return;
        mergeTwosorted(nums, left, mid, right, cache);
    }

    public void mergeTwosorted(int[] nums, int left, int mid, int right, int[] cache) {
        System.arraycopy(nums, left, cache, left, right - left + 1);
        int i = left, j = mid + 1;
        for (int m = left; m <= right; ++m) {
            if(i==mid+1){
                nums[m]=cache[j];
                j++;
            }
            else if(j==right+1){
                nums[m]=cache[i];
                i++;
            }
            else if(cache[i]<=cache[j]){
                nums[m]=cache[i];
                i++;
            }
            else if(cache[i]>cache[j]){
                nums[m]=cache[j];
                j++;
            }
        }

    }

}
