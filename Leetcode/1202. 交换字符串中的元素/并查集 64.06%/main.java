import com.sun.jdi.CharValue;

import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();
        List<Integer> p1 = new ArrayList<>();
        p1.add(0);
        p1.add(3);
        pairs.add(p1);

        List<Integer> p2 = new ArrayList<>();
        p2.add(1);
        p2.add(2);
        pairs.add(p2);

        System.out.println(main.smallestStringWithSwaps(s, pairs));
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int len = s.length();
        if (len == 1)
            return s;
        UnionFind unionFind = new UnionFind(len);
        char[] chars = s.toCharArray();
        char[] charsRes = new char[len];

        for (List<Integer> it : pairs) {
            int x = it.get(0);
            int y = it.get(1);
            unionFind.union(x, y);
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            int cache = unionFind.find(i);
            List<Integer> temp = map.getOrDefault(cache, new ArrayList<>());
            temp.add(i);
            map.put(cache, temp);
        }

        for (int it : map.keySet()) {
            List<Integer> temp = map.get(it);
            Integer[] cache = new Integer[temp.size()];
            for (int i = 0; i < temp.size(); ++i) {
                cache[i] = temp.get(i);
            }
            Arrays.sort(cache, (o1, o2) -> chars[o1] - chars[o2]);

            for (int i = 0; i < cache.length; ++i) {
                charsRes[temp.get(i)] = chars[cache[i]];
            }

        }
        StringBuilder res = new StringBuilder();
        for (char it : charsRes) {
            res.append(it);
        }

        return res.toString();
    }

    private class UnionFind {
        private int[] fathers;

        public UnionFind(int n) {
            fathers = new int[n];
            for (int i = 0; i < n; ++i)
                fathers[i] = i;
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
            fathers[rootX] = rootY;
        }

    }


}

