import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[][] res = main.findContinuousSequence(9);
        for (int i = 0; i < res.length; ++i) {
            for (int j = 0; j < res[i].length; ++j)
                System.out.print(res[i][j]);
            System.out.println();
        }
    }

    public int[][] findContinuousSequence(int target) {
        if (target < 3)
            return new int[][]{};
        int sta = 1;
        int end = 2;
        int sum = 3;
        List<int[]> reslist = new ArrayList<>();
        int[] nums = new int[target + 1];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = i;
        }
        while (end <= target / 2 + 1) {
            if (sum < target) {
                end++;
                sum+=end;
            } else if (sum > target) {
                sum-=sta;
                sta++;
            } else {
                reslist.add(getints(nums, sta, end));
                sum-=sta;
                sta++;
            }
        }
        return reslist.toArray(new int[reslist.size()][]);
    }

    public int[] getints(int[] nums, int A, int B) {
        int[] res = new int[B - A + 1];
        System.arraycopy(nums, A, res, 0, res.length);
        return res;
    }

}

