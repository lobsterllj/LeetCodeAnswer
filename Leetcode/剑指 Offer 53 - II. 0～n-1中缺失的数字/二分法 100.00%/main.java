public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9};
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{0, 1, 3};
        int[] nums3 = new int[]{1, 2};

        System.out.println(main.missingNumber(nums));
        System.out.println(main.missingNumber(nums1));
        System.out.println(main.missingNumber(nums2));
        System.out.println(main.missingNumber(nums3));

    }

    public int missingNumber(int[] nums) {
        if (nums[0] != 0)
            return 0;
        int len = nums.length;
        int end = len - 1;

        if (nums[end] != len)
            return len;
        int sta1 = 0;
        int com;
        while (sta1 < end) {
            com = (sta1 + end) >>> 1;
            if (nums[com] == com) {
                //result in [com+1,end]
                sta1 = com + 1;
            } else{
                //nums[com] > com
                //result in [sta,com]
                end = com;
            }
        }
        return sta1;
    }


}

