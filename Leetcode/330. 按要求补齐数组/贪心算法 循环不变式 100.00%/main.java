public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] nums = new int[]{1, 3};
        System.out.println(main.minPatches(nums, 6));

        int[] nums1 = new int[]{1, 5, 10};
        System.out.println(main.minPatches(nums1, 20));

        int[] nums2 = new int[]{1, 2, 2};
        System.out.println(main.minPatches(nums2, 5));
    }

    public int minPatches(int[] nums, int n) {
        int len = nums.length;
        long total = 0;
        int index = 0;
        int res = 0;

        //循环不变量： all in [1,total] 可被取到
        while (total < n) {
            if (index < len && total + 1 >= nums[index]) {
                //[1,total] U [nums[index],nums[index]+total] = [1,total+nums[index]]
                total += nums[index++];
            } else {
                //total < nums[index] 需要在total+1处插入
                total = total + total + 1;
                res++;
            }
        }

        return res;
    }

}

