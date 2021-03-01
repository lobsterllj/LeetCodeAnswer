import org.w3c.dom.ls.LSException;

import java.lang.invoke.VolatileCallSite;
import java.security.PublicKey;
import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
//        int[] ints = new int[]{2, 1, 2, 5, 2, 1, 5, 2, 1, 3, 4, 4, 1, 5, 2};
//        int[] ints = new int[]{1, 5, 1, 1, 6, 4};
//        int[] ints = new int[]{1,3,2,2,3,1};
        int[] ints = new int[]{1, 1, 2, 2, 2, 1};
        for (int k = 0; k < ints.length; ++k) {
            System.out.print(k + ": " + ints[k] + "  ");
        }
        System.out.println();
        main.wiggleSort(ints);
        //Arrays.sort(ints);
        for (int k = 0; k < ints.length; ++k) {
            System.out.print(k + ": " + ints[k] + "  ");
        }

    }

    public int[] sortArray(int[] nums) {
        int[] cache = new int[nums.length];
        //mergeSort(nums, 0, nums.length - 1, cache);
        quickSort3(nums, 0, nums.length - 1);
        return nums;
    }

    public void insertionSort(int[] nums, int left, int right) {
        if ((right - left + 1) < 2)
            return;
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

    public void wiggleSort(int[] nums) {
        //找到中位数索引
        int mid = quickSelect(nums, 0, nums.length - 1);
        System.out.println("找到中位数索引:" + mid);
        for (int i = 0; i < nums.length; i++) {
            System.out.print("nums[" + i + "] = " + nums[i] + " ");
        }
        System.out.println();

//        //all in [left+1,lt] <pivot
//        //all in [lt+1,i-1]  =pivot
//        //all in [gt,right]  >pivot
//        int pivot = nums[mid];
//        int lessthanPivotIndex = 0;
//        int greaterthanPivotIndex = nums.length;
//        int index = 1;
//
//        while (index < greaterthanPivotIndex) {
//            if (nums[index] < pivot) {
//                lessthanPivotIndex++;
//                swap(nums, index, lessthanPivotIndex);
//                index++;
//            } else if (nums[index] == pivot) {
//                index++;
//            } else {
//                greaterthanPivotIndex--;
//                swap(nums, index, greaterthanPivotIndex);
//            }
//        }
//
//        swap(nums, 0, lessthanPivotIndex);
//        //all in [left,lt-1]  <pivot
//        //all in [lt,gr-1]    =pivot
//        //all in [gt,right]   >pivot
//
//        //三路分割 中位数居中后
        System.out.println("三路分割 中位数居中后");
        for (int i = 0; i < nums.length; i++) {
            System.out.print("nums[" + i + "] = " + nums[i] + " ");
        }
        System.out.println();
        int n = nums.length;
        int n2 = nums.length / 2;
        int n1 = n - n2;
        int[] nums1 = new int[n1];
        int[] nums2 = new int[n2];
        System.arraycopy(nums, 0, nums1, 0, n1);
        System.arraycopy(nums, n1, nums2, 0, n2);

        for (int i = 0; i < n1; ++i) {
            nums[2 * i] = nums1[n1 - i - 1];
        }
        for (int i = 0; i < n2; ++i) {
            nums[2 * i + 1] = nums2[n2 - i - 1];
        }


    }

    public int quickSelect(int[] nums, int left, int right) {

        System.out.println("快速选择前");
        for (int k = 0; k < nums.length; ++k) {
            System.out.print(k + ": " + nums[k] + "  ");
        }
        System.out.println();

        int pivot = nums[left];
        //all in [left+1,lt] <pivot
        //all in [lt+1,i-1]  =pivot
        //all in [gt,right]  >pivot
        int lessthanPivotIndex = left;
        int greaterthanPivotIndex = right + 1;
        int i = left + 1;

        while (i < greaterthanPivotIndex) {
            if (nums[i] < pivot) {
                lessthanPivotIndex++;
                swap(nums, i, lessthanPivotIndex);
                i++;
            } else if (nums[i] == pivot) {
                i++;
            } else {
                greaterthanPivotIndex--;
                swap(nums, i, greaterthanPivotIndex);
            }
        }


        swap(nums, left, lessthanPivotIndex);
        //all in [left,lt-1]  <pivot
        //all in [lt,gt-1]    =pivot
        //all in [gt,right]   >pivot

        //快速选择后
        System.out.println("快速选择后");
        for (int k = 0; k < nums.length; ++k) {
            System.out.print(k + ": " + nums[k] + "  ");
        }
        System.out.println();

        System.out.println("lessthanPivotIndex:" + lessthanPivotIndex);
        System.out.println("greaterthanPivotIndex:" + greaterthanPivotIndex);
        int mid = ((nums.length - 1) >> 1);
        System.out.println("mid:" + mid);

        if (lessthanPivotIndex > mid) {
            return quickSelect(nums, left, lessthanPivotIndex - 1);
        } else if (mid > greaterthanPivotIndex - 1) {
            return quickSelect(nums, lessthanPivotIndex + 1, right);
        } else {
            return mid;
        }
    }


    public void quickSort3(int[] nums, int left, int right) {
        if (right - left + 1 <= 7) {
            insertionSort(nums, left, right);
            return;
        }
        int randomPartitonIndex = new Random().nextInt(right - left + 1) + left;
        swap(nums, left, randomPartitonIndex);

        //all in [left+1,lt] <pivot
        //all in [lt+1,i-1]  =pivot
        //all in [gt,right]  >pivot
        int pivot = nums[left];
        int lessthanPivotIndex = left;
        int greaterthanPivotIndex = right + 1;
        int i = left + 1;

        while (i < greaterthanPivotIndex) {
            if (nums[i] < pivot) {
                lessthanPivotIndex++;
                swap(nums, i, lessthanPivotIndex);
                i++;
            } else if (nums[i] == pivot) {
                i++;
            } else {
                greaterthanPivotIndex--;
                swap(nums, i, greaterthanPivotIndex);
            }
        }


        swap(nums, left, lessthanPivotIndex);
        //all in [left,lt-1]  <pivot
        //all in [lt,gr-1]    =pivot
        //all in [gt,right]   >pivot
        quickSort3(nums, left, lessthanPivotIndex - 1);
        quickSort3(nums, greaterthanPivotIndex, right);

    }

    public void quickSort(int[] nums, int left, int right) {
        if (right - left + 1 <= 7) {
            insertionSort(nums, left, right);
            return;
        }
        int partitionIndex = partition(nums, left, right);
        quickSort(nums, left, partitionIndex - 1);
        quickSort(nums, partitionIndex + 1, right);

    }

    public int partition(int[] nums, int left, int right) {
        int randomIndex = new Random().nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);
        //基准量
        int pivot = nums[left];
        int lessThanPivotIndex = left;

        //循环不变量
        //all in [left+1,lt]  <pivot
        //all in [lt+1,i) >=pivot
        for (int i = left + 1; i <= right; ++i) {
            if (nums[i] < pivot) {
                lessThanPivotIndex++;
                swap(nums, i, lessThanPivotIndex);
            }
        }

        //all in [left,lt-1]  <pivot
        //          index:lt  =pivot
        //all in [lt+1,right] >=pivot
        swap(nums, left, lessThanPivotIndex);
        return lessThanPivotIndex;
    }

    public void swap(int[] nums, int i, int j) {
        int cache = nums[i];
        nums[i] = nums[j];
        nums[j] = cache;
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
            if (i == mid + 1) {
                nums[m] = cache[j];
                j++;
            } else if (j == right + 1) {
                nums[m] = cache[i];
                i++;
            } else if (cache[i] <= cache[j]) {
                nums[m] = cache[i];
                i++;
            } else if (cache[i] > cache[j]) {
                nums[m] = cache[j];
                j++;
            }
        }

    }

}
