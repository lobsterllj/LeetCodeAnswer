import java.util.*;

public class main {
    private int[] cntofIndex;
    private int[] index;
    private int[] temp;
    private int[] tempIndex;

    public static void main(String[] args) {
        main main = new main();
        int[] ints = new int[]{5, 2, 6, 1};
        List<Integer> res = main.countSmaller(ints);

        for (int it : res) {
            System.out.print(it + " ");
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if (nums.length == 0)
            return res;
        cntofIndex = new int[nums.length];
        index = new int[nums.length];
        temp = new int[nums.length];
        tempIndex = new int[nums.length];
        //index = 现有索引   val = 在原数组中的索引
        for (int i = 0; i < nums.length; ++i) {
            index[i] = i;
        }

        mergesortandcnt(nums, 0, nums.length - 1);
        for (int it : cntofIndex)
            res.add(it);
        return res;
    }

    public void mergesortandcnt(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (right + left) >>> 1;
        mergesortandcnt(nums, left, mid);
        mergesortandcnt(nums, mid + 1, right);


        int i = left;
        int j = mid + 1;
        int m = left;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tempIndex[m] = index[i];
                cntofIndex[index[i]] += (j - mid - 1);
                temp[m++] = nums[i++];
            } else {
                tempIndex[m] = index[j];
                temp[m++] = nums[j++];
            }
        }
        while (i <= mid) {
            tempIndex[m] = index[i];
            cntofIndex[index[i]] += (j - mid - 1);
            temp[m++] = nums[i++];
        }
        while (j <= right) {
            tempIndex[m] = index[j];
            temp[m++] = nums[j++];
        }

        for (int x = left; x <= right; ++x) {
            nums[x] = temp[x];
            index[x] = tempIndex[x];
        }

        return;
    }


    public int mergesort(int[] nums, int[] numsSorted, int left, int right) {
        for (int k = left; k <= right; ++k)
            System.out.print("nums[" + k + "]: " + nums[k] + " ");
        System.out.println();
        if (left >= right) {
            return 0;
        }
        int res = 0;
        int mid = (right + left) >>> 1;
        res += mergesort(nums, numsSorted, left, mid);
//        System.out.println("res1="+res);
        res += mergesort(nums, numsSorted, mid + 1, right);
//        System.out.println("res2="+res);
        res += findreversePairs(nums, left, right);
//        System.out.println("res3="+res);

        int i = left;
        int j = mid + 1;
        int m = left;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j])
                numsSorted[m++] = nums[i++];
            else
                numsSorted[m++] = nums[j++];
        }
        while (i <= mid) {
            numsSorted[m++] = nums[i++];
        }
        while (j <= right) {
            numsSorted[m++] = nums[j++];
        }

        for (int k = left; k <= right; ++k)
            nums[k] = numsSorted[k];

//        for (int k = left; k <= right; ++k)
//            System.out.print("nums["+k+"]: "+nums[k]+" ");
//        System.out.println();

        return res;
    }

    public int findreversePairs(int[] nums, int left, int right) {
        int res = 0;

        int mid = (right + left) >>> 1;
        System.out.println("left:" + left);
        System.out.println("mid:" + mid);
        System.out.println("right:" + right);
        int i = left;
        int j = mid + 1;
        for (; i <= mid; ++i) {
            while (j <= right && (long) nums[i] > 2 * (long) nums[j]) {
                res += mid - i + 1;
                j++;
            }
        }
        System.out.println("res:" + res);
        return res;
    }


}
