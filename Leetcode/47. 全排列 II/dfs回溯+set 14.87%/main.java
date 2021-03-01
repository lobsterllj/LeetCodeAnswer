import java.util.*;

public class main {
    int n;

    public static void main(String[] args) {
        main main = new main();
        int[] nums = new int[]{1, 1, 3};

        System.out.println(main.permuteUnique(nums));

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n == 1) {
            List<Integer> cache = new ArrayList<>();
            cache.add(nums[0]);
            res.add(cache);
            return res;
        }
        boolean[] visited = new boolean[n];
        List<Integer> cache = new ArrayList<>();
        Set<List<Integer>> repeat = new HashSet<>();
        add2res(res, cache, nums, repeat, visited);
        return res;
    }

    public void add2res(List<List<Integer>> res, List<Integer> cache, int[] nums, Set<List<Integer>> repeat, boolean[] visited) {
        if (cache.size() == n) {
            if (!repeat.contains(cache)) {
                List<Integer> temp = new ArrayList<>(cache);
                res.add(temp);
                repeat.add(temp);
            }
            return;
        }
        for (int i = 0; i < n; ++i) {
            if (visited[i])
                continue;
            visited[i] = true;
            cache.add(nums[i]);
            add2res(res, cache, nums, repeat, visited);
            cache.remove(cache.size() - 1);
            visited[i] = false;
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n == 1) {
            List<Integer> cache = new ArrayList<>();
            cache.add(nums[0]);
            res.add(cache);
            return res;
        }
        boolean[] visited = new boolean[n];
        List<Integer> cache = new ArrayList<>();
        add2r(res, cache, nums, visited);
        return res;
    }

    public void add2r(List<List<Integer>> res, List<Integer> cache, int[] nums, boolean[] visited) {
        if (cache.size() == n) {
            List<Integer> temp = new ArrayList<>(cache);
            res.add(temp);
        }
        for (int i = 0; i < n; ++i) {
            if (visited[i])
                continue;
            visited[i] = true;
            cache.add(nums[i]);
            add2r(res, cache, nums, visited);
            cache.remove(cache.size() - 1);
            visited[i] = false;
        }
    }
}

