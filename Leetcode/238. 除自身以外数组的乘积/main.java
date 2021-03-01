import java.util.*;

public class main {
    public static void main(String[] args) {
        main aa = new main();
        int[] a1 = new int[]{1, 2, 3, 4};
        int[] res = aa.productExceptSelf(a1);
        for (int it : res)
            System.out.println(it);

    }

    public int[] productExceptSel(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;
        int[] res = new int[nums.length];
        for (int i = 1; i < nums.length; ++i)
            left[i] = nums[i - 1] * left[i - 1];
        for (int j = nums.length - 2; j > -1; --j)
            right[j] = nums[j + 1] * right[j + 1];
        for (int k = 0; k < nums.length; ++k)
            res[k] = left[k] * right[k];
        return res;
    }

    public int[] productExceptSelf(int[] nums) {
        int right = 1;
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        for (int j = nums.length - 2; j > -1; --j) {
            right *= nums[j + 1];
            res[j] *= right;
        }
        return res;
    }
}





