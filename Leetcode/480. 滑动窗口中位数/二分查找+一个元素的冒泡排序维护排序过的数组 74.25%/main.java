import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();

        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        prtInts.prt(main.medianSlidingWindow(nums, k));

    }

    int lenk;

    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int lenRes = len - k + 1;
        lenk = k;
        double[] res = new double[lenRes];

        int[] window = new int[k];
        for (int i = 0; i < k; ++i)
            window[i] = nums[i];
        Arrays.sort(window);
        res[0] = getMedium(window);

        for (int i = 0; i < lenRes - 1; ++i) {

            int index = findIndex(window, nums[i]);
            window[index] = nums[i + k];
            //冒泡排序
            //向右
            while (index < k - 1 && window[index] > window[index + 1]) {
                swap(window, index, index + 1);
                index++;
            }
            //向左
            while (index > 0 && window[index] < window[index - 1]) {
                swap(window, index, index - 1);
                index--;
            }
            res[i + 1] = getMedium(window);

        }
        return res;
    }

    public void swap(int[] ints, int i1, int i2) {
        int cache = ints[i1];
        ints[i1] = ints[i2];
        ints[i2] = cache;
    }

    public double getMedium(int[] nums) {
        return ((double) ((long)nums[(lenk - 1) / 2] +(long) nums[lenk / 2]) * 0.5);
    }

    public int findIndex(int[] nums, int tar) {
        int sta = 0;
        int end = nums.length;
        int com;
        while (sta < end) {
            com = (sta + end) >>> 1;
            if (nums[com] < tar)
                sta = com + 1;
            else
                end = com;
        }
        return sta;
    }


}
