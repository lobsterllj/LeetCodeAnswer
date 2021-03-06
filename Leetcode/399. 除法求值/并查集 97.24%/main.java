import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        List<List<String>> equations = new ArrayList<>();
        List<String> cache = new ArrayList<>();
        cache.add("a");
        cache.add("b");
        equations.add(cache);
        List<String> cache1 = new ArrayList<>();
        cache1.add("b");
        cache1.add("c");
        equations.add(cache1);
        List<String> cache2 = new ArrayList<>();
        cache2.add("bc");
        cache2.add("cd");
        equations.add(cache2);

        double[] values = {1.5, 2.5, 5.0};

        List<List<String>> queries = new ArrayList<>();
        List<String> ache = new ArrayList<>();
        ache.add("a");
        ache.add("c");
        queries.add(ache);
        List<String> ache1 = new ArrayList<>();
        ache1.add("c");
        ache1.add("b");
        queries.add(ache1);
        List<String> ache2 = new ArrayList<>();
        ache2.add("bc");
        ache2.add("cd");
        queries.add(ache2);
        List<String> ache3 = new ArrayList<>();
        ache3.add("cd");
        ache3.add("bc");
        queries.add(ache3);

        double[] res = main.calcEquation(equations, values, queries);
        for (int i = 0; i < res.length; ++i) {
            System.out.print(res[i] + " ");
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();
        UnionFind unionFind = new UnionFind(2 * equationsSize);
        Map<String, Integer> map = new HashMap<>(2 * equationsSize);

        int id = 0;
        for (int i = 0; i < equationsSize; ++i) {
            List<String> cache = equations.get(i);
            String string1 = cache.get(0);
            String string2 = cache.get(1);
            if (!map.containsKey(string1))
                map.put(string1, id++);
            if (!map.containsKey(string2))
                map.put(string2, id++);
            unionFind.union(map.get(string1), map.get(string2), values[i]);
        }

        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; ++i) {
            List<String> cache = queries.get(i);
            String string1 = cache.get(0);
            String string2 = cache.get(1);
            if (map.containsKey(string1) && map.containsKey(string2)) {
                res[i] = unionFind.isConnected(map.get(string1), map.get(string2));
            } else {
                res[i] = -1.0d;
            }
        }
        return res;
    }

    private class UnionFind {
        /**
         * 父节点
         */
        private int[] parents;

        /**
         * 指向父节点的权重
         */
        private double[] weight;

        /**
         * 实例化并查集
         *
         * @param n 并查集的最大可能长度
         */
        public UnionFind(int n) {
            this.parents = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; ++i) {
                parents[i] = i;
                weight[i] = 1.0d;
            }
        }

        /**
         * 查找根节点，并压缩途径路径
         *
         * @param x 被查找的节点
         * @return x 对应的根节点
         */
        public int find(int x) {
            if (x != parents[x]) {
                int origin = parents[x];
                parents[x] = find(parents[x]);
                weight[x] *= weight[origin];
            }
            return parents[x];
        }

        /**
         * 连接两个集合
         *
         * @param x     除数
         * @param y     被除数
         * @param value 商
         */
        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY)
                return;
            parents[rootX] = rootY;
            weight[rootX] = (value * weight[y]) / weight[x];
        }

        /**
         * 判断两个节点是否属于一个集合
         * 如果属于一个集合，返回两个节点与父节点的权重的比值
         *
         * @param x 节点1
         * @param y 节点2
         * @return
         */
        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY)
                return weight[x] / weight[y];
            else
                return -1.0d;
        }
    }
}

