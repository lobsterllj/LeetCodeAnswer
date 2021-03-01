import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtints prtints = new prtints();
        int[][] edges = new int[][]{
                {0, 0},
                {0, 1},
                {1, 0},
        };
        System.out.println(main.removeStones(edges));

    }

    class UnionFind {
        Map<Integer, Integer> map;
        int cnts;

        public UnionFind() {
            map = new HashMap<>();
            cnts = 0;
        }

        public int find(int x) {
            if (map.containsKey(x)) {
                int ori = x;
                while (x != map.get(x)) {
                    x = map.get(x);
                }
                map.put(ori, x);
            } else {
                map.put(x, x);
                //创建一个组，故总组数+1
                cnts++;
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY)
                return;
            map.put(rootX, rootY);
            //合并两个组，故总组数-1
            cnts--;
        }

        public int getcnts() {
            return cnts;
        }
    }

    public int removeStones(int[][] stones) {
        int num = stones.length;
        if (num == 1)
            return 0;

        UnionFind unionFind = new UnionFind();
        for (int[] it : stones) {
            //横坐标+10000能保证横纵坐标永远不可能相等
            //这种union方式以a:[0,0] b:[1,0] c:[0,1]为例
            //a->[10000,0] b->[10001,0] c->[10000,1]
            //首先把横坐标为10000和纵坐标0连接
            //10001-0 10000-1
            //a和b通过0连接在一起
            //c和a通过10000 连接在一起
            //最终a，b，c同属一个组
            unionFind.union(it[0] + 10000, it[1]);
        }
        System.out.println(unionFind.map);
        return num - unionFind.getcnts();

    }

}

