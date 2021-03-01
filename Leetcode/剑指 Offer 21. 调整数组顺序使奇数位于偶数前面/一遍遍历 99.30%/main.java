

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] nums = new int[]{1, 2, 3, 4};
        int[] res = main.exchange(nums);
        for (int i = 0; i < res.length; ++i)
            System.out.println(res[i]);
    }

    public int[] exchange(int[] nums) {
        if (nums.length == 1)
            return nums;
        int i = 0;
        int j = nums.length - 1;
        //[0,i-1] 全为奇数
        //[j+1，n-1] 全为偶数
        while (i < j) {
            while (i < nums.length && nums[i] % 2 != 0) {
                i++;
            }
            while (j > -1 && nums[j] % 2 == 0) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int cache = nums[i];
        nums[i] = nums[j];
        nums[j] = cache;
    }

}
