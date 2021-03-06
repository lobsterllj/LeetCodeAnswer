import java.sql.SQLOutput;
import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        String s = "ababacb";
        String a = "aaabbb";
        System.out.println(main.longestSubstring(s, 3));
    }

    public int longestSubstring(String s, int k) {
        if (s.length() == 0)
            return 0;
        return dfs(s, 0, s.length() - 1, k);
    }

    public int dfs(String s, int start, int end, int k) {
        if (start < 0 || end > s.length() - 1 || end - start + 1 < k)
            return 0;
        int[] cnts = new int[26];
        int res = 0;
        for (int i = start; i <= end; ++i) {
            char it = s.charAt(i);
            cnts[it - 'a']++;
        }
        List<Integer> splitPoint = new ArrayList<>();
        for (int i = start; i <= end; ++i) {
            char it = s.charAt(i);
            if (cnts[it - 'a'] < k) {
                splitPoint.add(i);
            }
        }
        System.out.println(splitPoint);
        if (splitPoint.size() == 0) {
            res = Math.max(res, (end - start + 1));
            return res;
        }

        res = Math.max(res, dfs(s, start, splitPoint.get(0)-1, k));
        for(int i=0;i<splitPoint.size()-1;++i){
            res = Math.max(res, dfs(s, splitPoint.get(i)+1, splitPoint.get(i+1)-1, k));
        }
        res = Math.max(res, dfs(s, splitPoint.get(0)+1, end, k));

        return res;
    }
}
