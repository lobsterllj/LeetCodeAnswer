public class main {
    public static void main(String[] args) {
        int[] in = {2, -2, 2, -2, 2, -2};
        main aa = new main();
        System.out.println(aa.maxProduct(in));
    }

    public int maxProduct(int[] nums) {
        int final_max = Integer.MIN_VALUE;
        int max = 1;
        int min = 1;
        int cache;
        for (int it : nums) {
            if (it < 0) {
                cache = max;
                max = min;
                min = cache;
            }
            max = Math.max(it, (max * it));
            min = Math.min(it, (min * it));
            final_max = Math.max(final_max, max);
        }
        return final_max;
    }
}
