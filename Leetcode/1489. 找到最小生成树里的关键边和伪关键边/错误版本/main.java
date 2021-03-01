import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();

//        int[][] points = new int[][]{
//                {0, 0},
//                {2, 2},
//                {3, 10},
//                {5, 2},
//                {7, 0}
//        };
//        System.out.println(main.minCostConnectPoints(points));
//
//        int[][] points1 = new int[][]{
//                {-1000000, -1000000},
//                {1000000, 1000000}
//        };
//        System.out.println(main.minCostConnectPoints(points1));

        int[][] edges = new int[][]{
                {0, 1, 1},
                {1, 2, 1},
                {2, 3, 2},
                {0, 3, 2},
                {0, 4, 3},
                {3, 4, 3},
                {1, 4, 6}
        };
        int n = 5;
        System.out.println(main.findCriticalAndPseudoCriticalEdges(n, edges));

    }

    private class UnionFind {
        /**
         * 成员变量
         */
        public int[] fathers;
        public int[] rank;
        int size;
        int length;

        /**
         * 实例化并查集
         */
        public UnionFind(int n) {
            size = 0;
            length = 0;
            fathers = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; ++i) {
                fathers[i] = i;
                rank[i] = 1;
            }
        }

        /**
         * 查找根节点，并压缩途径路径
         *
         * @param x 被查找的节点
         * @return 对应的根节点
         */
        public int find(int x) {
            if (x != fathers[x])
                fathers[x] = find(fathers[x]);
            return fathers[x];
        }

        /**
         * 连接两个集合
         */
        public void union(edge edge) {
            int rootX = find(edge.p1);
            int rootY = find(edge.p2);
            if (rootX == rootY)
                return;
            if (rank[rootX] > rank[rootY]) {
                fathers[rootY] = rootX;
                rank[rootX] += rank[rootY];
            } else {
                fathers[rootX] = rootY;
                rank[rootY] += rank[rootX];
            }
            length += edge.len;
            size++;

        }

    }

    class edge {
        int p1;
        int p2;
        int len;

        public edge(int p1, int p2, int len) {
            this.p1 = p1;
            this.p2 = p2;
            this.len = len;
        }
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();

        edge[] edgeArray = new edge[edges.length];
        int index_edgeArray = 0;
        for (int[] e : edges) {
            edge cache = new edge(e[0], e[1], e[2]);
            edgeArray[index_edgeArray++] = cache;
        }
        Arrays.sort(edgeArray, new Comparator<edge>() {
            @Override
            public int compare(edge o1, edge o2) {
                return o1.len - o2.len;
            }
        });

        int mstlen = 0;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < edgeArray.length; ++i) {
            unionFind.union(edgeArray[i]);
            if (unionFind.size == n - 1)
                mstlen = unionFind.length;
        }

        for (int i = 0; i < edgeArray.length; ++i) {
            unionFind = new UnionFind(n);
            for (int j = 0; j < edgeArray.length; ++j) {
                if (i == j)
                    continue;
                unionFind.union(edgeArray[j]);
            }
            if (unionFind.size < n - 1 || unionFind.length > mstlen) {
                res1.add(i);
                continue;
            }

            unionFind = new UnionFind(n);
            unionFind.union(edgeArray[i]);
            for (int j = 0; j < edgeArray.length; ++j) {
                if (i == j)
                    continue;
                unionFind.union(edgeArray[j]);
            }
            if (unionFind.size == n - 1 && unionFind.length == mstlen)
                res2.add(i);
        }

        res.add(res1);
        res.add(res2);

        return res;
    }

    public int minCostConnectPoints(int[][] points) {
        int lenP = points.length;
        if (lenP == 1)
            return 0;
        edge[] edges = new edge[(lenP * (lenP - 1)) >> 1];
        int index_edges = 0;
        for (int i = 0; i < lenP; ++i) {
            for (int j = i + 1; j < lenP; ++j) {
                edges[index_edges++] = new edge(i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]));
            }
        }
        Arrays.sort(edges, new Comparator<edge>() {
            @Override
            public int compare(edge o1, edge o2) {
                return o1.len - o2.len;
            }
        });
        UnionFind unionFind = new UnionFind(edges.length + 1);
        for (int i = 0; i < edges.length; ++i) {
            unionFind.union(edges[i]);
            if (unionFind.size == lenP - 1)
                return unionFind.length;
        }
        return 0;
    }


}




