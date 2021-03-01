import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();

        System.out.println(main.generateParenthesis(3));

    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder cache = new StringBuilder();
        int nl = n;
        int nr = n;
        recur(res, cache, nl, nr);

        return res;
    }

    public void recur(List<String> res, StringBuilder cache, int nl, int nr) {
        if (nr < nl || nl < 0 || nr < 0)
            return;

        if (nl == 0 && nr == 0) {
            res.add(cache.toString());
            return;
        }

        cache.append('(');
        recur(res, cache, nl - 1, nr);
        cache.deleteCharAt(cache.length() - 1);

        cache.append(')');
        recur(res, cache, nl, nr - 1);
        cache.deleteCharAt(cache.length() - 1);

    }


    private class unionFind {
        int[] fathers;
        int[] size;
        int groupNum;

        public unionFind(int n) {
            fathers = new int[n];
            size = new int[n];
            groupNum = n;
            for (int i = 0; i < n; ++i) {
                fathers[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (x != fathers[x]) {
                fathers[x] = find(fathers[x]);
            }
            return fathers[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY)
                return;
            if (size[rootX] < size[rootY]) {
                fathers[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                fathers[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            groupNum--;
            return;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }


}
