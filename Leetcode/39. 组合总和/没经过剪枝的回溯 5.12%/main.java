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
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> cache = new ArrayList<>();
        backtracking(set, cache, 0, candidates, target);
        for (List<Integer> list : set)
            res.add(list);
        return res;
    }

    public void backtracking(Set<List<Integer>> set, List<Integer> cache, int sum, int[] candidates, int target) {
        if (sum > target)
            return;
        if (sum == target) {
            List<Integer> temp = new ArrayList<>(cache);
            temp.sort((a, b) -> a - b);
            set.add(temp);
            return;
        }

        for (int i = 0; i < candidates.length; ++i) {
            int ci = candidates[i];
            sum += ci;
            cache.add(ci);
            backtracking(set, cache, sum, candidates, target);
            cache.remove(cache.size() - 1);
            sum -= ci;

        }
    }

}
