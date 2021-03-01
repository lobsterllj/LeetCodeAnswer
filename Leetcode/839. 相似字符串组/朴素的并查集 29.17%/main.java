import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();

        String[] strs = new String[]{"tars", "rats", "arts", "star"};
        System.out.println(main.numSimilarGroups(strs));
        System.out.println(main.getDif(strs[0], strs[1]));
    }

    public int numSimilarGroups(String[] strs) {
        int len = strs.length;
        unionFind unionFind = new unionFind(len);
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                int cache = getDif(strs[i], strs[j]);
                if (cache == 2 || cache == 0)
                    unionFind.union(i, j);
            }
        }
        return unionFind.groupNum;
    }

    public int getDif(String s1, String s2) {
        int res = 0;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        for (int i = 0; i < s1.length(); ++i) {
            if (chars1[i] != chars2[i])
                res++;
        }
        return res;
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

    class edge {
        public int x;
        public int y;
        public int dis;

        public edge(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }

        public int getDis() {
            return dis;
        }
    }


}
