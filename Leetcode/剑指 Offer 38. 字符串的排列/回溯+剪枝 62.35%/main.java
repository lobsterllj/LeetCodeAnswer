import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class main {

    public static void main(String[] args) {
        main main = new main();
        String s = "aab";
        String[] res = main.permutation(s);
        for (String it : res)
            System.out.println(it);
    }

    int n;
    char[] chars;
    List<String> res = new LinkedList<>();

    public String[] permutation(String s) {
        n = s.length();
        StringBuilder cache = new StringBuilder();
        chars = s.toCharArray();
        boolean[] visited = new boolean[n];
        Arrays.sort(chars);
        recur(cache, visited);
        return res.toArray(new String[]{});

    }

    public void recur(StringBuilder cache, boolean[] visited) {
        if (cache.length() == n) {
            res.add(cache.toString());
        }
        for (int i = 0; i < n; ++i) {
            if (visited[i])
                continue;
            if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) {
                //chars经过排序后，相同的元素左右相邻
                //以a,a,b为例记为a1，a2，b
                //如果当先选择a2时
                //visited：0，1，0
                //此时a1仍可被选择，故必和原来a1先被选，a2未备选的得到的结果一致，故剪枝
                continue;
            }
            
            visited[i] = true;
            cache.append(chars[i]);
            recur(cache, visited);
            cache.deleteCharAt(cache.length() - 1);
            visited[i] = false;
        }
    }
}

