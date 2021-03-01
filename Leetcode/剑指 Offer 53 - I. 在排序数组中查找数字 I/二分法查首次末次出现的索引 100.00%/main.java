public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(main.search(nums, 8));

    }

    public int search(int[] nums, int target) {
        int end = nums.length - 1;
        if (end < 0)
            return 0;
        int sta1 = 0;
        int com;
        while (sta1 < end) {
            com = (sta1 + end) >>> 1;
            if (nums[com] < target) {
                sta1 = com + 1;
            } else {
                end = com;
            }
        }

        end = nums.length - 1;
        int sta2 = 0;
        while (sta2 < end) {
            com = (sta2 + end + 1) >>> 1;
            if (nums[com] > target) {
                end = com - 1;
            } else {
                sta2 = com;
            }
        }
        if (nums[sta1] == target)
            return sta2 - sta1 + 1;
        else
            return 0;

    }

}

