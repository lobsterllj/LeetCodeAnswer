
public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();

        int[] nums = new int[]{2, 4, 8, 2};
        System.out.println(main.minimumSize(nums, 4));

    }

    public int minimumSize(int[] nums, int maxOperations) {
        int res = 1;
        int sta = 1;
        int com;
        int end = (int) 1e9;
        while (sta < end) {
            com = (sta + end) >>> 1;
            if (!check(nums, com, maxOperations)) {
                sta = com + 1;
            } else {
                end = com;
                res = com;
            }
        }
        return res;
    }

    public boolean check(int[] nums, int cost, int maxOperations) {
        int cnt = 0;
        for (int it : nums) {
            if (it > cost) {
                if (it % cost == 0)
                    cnt += it / cost - 1;
                else
                    cnt += it / cost;
            }
        }
        return cnt <= maxOperations;
    }

}
