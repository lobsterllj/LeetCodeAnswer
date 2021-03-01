public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] ints = new int[]{1, 3, 2, 3, 1};
        System.out.println(main.reversePairs(ints));
    }

    public int reversePairs(int[] nums) {
        if (nums.length <= 1)
            return 0;
        int[] numsSorted = new int[nums.length];
        return mergesort(nums, numsSorted, 0, nums.length-1);
    }

    public int mergesort(int[] nums, int[] numsSorted, int left, int right) {
        for (int k = left; k <= right; ++k)
            System.out.print("nums["+k+"]: "+nums[k]+" ");
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
        System.out.println("left:"+left);
        System.out.println("mid:"+mid);
        System.out.println("right:"+right);
        int i = left;
        int j = mid + 1;
        for (; i <=mid; ++i) {
            while (j <= right && (long)nums[i] > 2*(long)nums[j]) {
                res += mid - i + 1;
                j++;
            }
        }
        System.out.println("res:"+res);
        return res;
    }


}
