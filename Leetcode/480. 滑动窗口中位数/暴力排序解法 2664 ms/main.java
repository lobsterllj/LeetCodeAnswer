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

    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        double[] res = new double[len - k + 1];
        for (int i = 0; i < res.length; ++i) {
            res[i] = getMedium(nums, i, i + k - 1);
        }
        return res;
    }

    public double getMedium(int[] nums, int sta, int end) {
        int len = end - sta + 1;
        int[] copy = new int[len];
        System.arraycopy(nums, sta, copy, 0, len);
        Arrays.sort(copy);
        return ((double) ((long) copy[(len - 1) / 2] + (long) copy[len / 2]) * 0.5);
    }

}
