import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {

    public static void main(String[] args) {
        main main = new main();
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strings1 = new String[]{""};
        System.out.println(main.groupAnagrams(strings));

    }

    int[] key = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        if (strs.length == 0)
            return res;

        Map<Long, List<String>> res_map = new HashMap<>();
        for (int i = 0; i < strs.length; ++i) {
            char[] cache = strs[i].toCharArray();
            long temp = 1;
            for (int j = 0; j < cache.length; ++j) {
                temp *= key[cache[j] - 'a'];
            }

            List<String> buffer = res_map.getOrDefault(temp, new ArrayList<>());
            buffer.add(strs[i]);
            res_map.put(temp, buffer);

        }
        for (long it : res_map.keySet()) {
            List<String> cache = new ArrayList<>(res_map.get(it));
            res.add(cache);
        }
        return res;
    }

    public int[] find(int n) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        dp[1] = true;
        for (int i = 2; i * i < n + 1; i++) {
            if (!dp[i])
                for (int j = 2 * i; j < n + 1; j += i) {
                    dp[j] = true;
                }
        }
        int cnt = 0;
        int[] res = new int[26];
        int index = 0;
        for (int k = 0; k < n + 1; ++k) {
            if (!dp[k])
                res[index++] = k;
            System.out.println(k + " " + dp[k]);
        }
        return res;
    }

}
