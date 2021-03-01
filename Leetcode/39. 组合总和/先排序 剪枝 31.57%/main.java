import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();

        int[] candidates = new int[]{2, 3, 5};
        System.out.println(main.combinationSum(candidates, 8));

    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cache = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(res, cache, 0, 0, candidates, target);
        return res;
    }

    public void backtracking(List<List<Integer>> res, List<Integer> cache, int sta, int sum, int[] candidates, int target) {
        if (sum > target)
            return;
        if (sum == target) {
            List<Integer> temp = new ArrayList<>(cache);
            res.add(temp);
            return;
        }

        for (int i = sta; i < candidates.length; ++i) {
            int ci = candidates[i];
            sum += ci;
            cache.add(ci);
            backtracking(res, cache, i, sum, candidates, target);
            cache.remove(cache.size() - 1);
            sum -= ci;

        }
    }

}
