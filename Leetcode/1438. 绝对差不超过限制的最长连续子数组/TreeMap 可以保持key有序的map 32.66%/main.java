import java.util.TreeMap;

public class main {
    int Rows;
    int Cols;

    int[][] dir = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();
        formMatrix formMatrix = new formMatrix();

        int[] nums = new int[]{4, 2, 2, 2, 4, 4, 2, 2};
        System.out.println(main.longestSubarray(nums, 0));

    }

    public int longestSubarray(int[] nums, int limit) {
        int len = nums.length;
        if (len == 1)
            return 1;
        int res = 1;

        int sta = 0;
        int end = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        while (end < len) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[sta], map.get(nums[sta]) - 1);
                if (map.get(nums[sta]) == 0)
                    map.remove(nums[sta]);
                sta++;
            }
            res = Math.max(res, end - sta + 1);
            end++;
        }

        return res;
    }


}
