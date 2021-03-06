import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtArray prtArray = new prtArray();

        int[][] grid = new int[][]{
                {1, 0, 0, 0},
                {1, 1, 1, 0}
        };
        int[][] hits = new int[][]{
                {1, 0}
        };
        int[] res = main.hitBricks(grid, hits);
        prtArray.prtArray(res);

//        int[][] grid1 = new int[][]{
//                {1},
//                {1},
//                {1},
//                {1},
//                {1}
//        };
//        int[][] hits1 = new int[][]{
//                {3, 0},
//                {4, 0},
//                {1, 0},
//                {2, 0},
//                {0, 0}
//        };
//        int[] res1 = main.hitBricks(grid1, hits1);
//        prtArray.prtArray(res1);

//        int[][] grid2 = new int[][]{
//                {1, 1, 1},
//                {0, 1, 0},
//                {0, 0, 0}
//        };
//        int[][] hits2 = new int[][]{
//                {0, 2},
//                {2, 0},
//                {0, 1},
//                {1, 2}
//        };
//        int[] res2 = main.hitBricks(grid2, hits2);
//        prtArray.prtArray(res2);

    }

    private int rows;
    private int cols;

    private class UnionFind {
        /**
         * 成员变量
         */
        public int[] fathers;
        public int[] rank;
        int size = rows * cols + 1;
        int[][] grid;

        /**
         * 实例化并查集
         */
        public UnionFind(int[][] grid) {
            this.grid = grid;
            fathers = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; ++i) {
                fathers[i] = i;
                rank[i] = 1;
            }


            for (int col = 0; col < cols; ++col) {
                if (grid[0][col] == 1) {
                    this.union(getindex(0, col), size - 1);
                }
            }


            for (int row = 1; row < rows; ++row) {
                for (int col = 0; col < cols; ++col) {
                    if (grid[row][col] == 1) {
                        linkedaround(row, col);
                    }
                }
            }

        }

        public void linkedaround(int row, int col) {
            grid[row][col] = 1;
            if (row == 0) {
                this.union(getindex(row, col), size - 1);
            }
            if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                this.union(getindex(row - 1, col), getindex(row, col));
            }
            if (row + 1 <= rows - 1 && grid[row + 1][col] == 1) {
                this.union(getindex(row + 1, col), getindex(row, col));
            }
            if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                this.union(getindex(row, col - 1), getindex(row, col));
            }
            if (col + 1 <= cols - 1 && grid[row][col + 1] == 1) {
                this.union(getindex(row, col + 1), getindex(row, col));
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
         *
         * @param x 除数
         * @param y 被除数
         */
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY)
                return;
            fathers[rootX] = rootY;
            rank[rootY] += rank[rootX];
        }


        /**
         * 返回当前连接top的砖块总数
         *
         * @return
         */
        public int linkedTop() {
            int topfather = find(size - 1);
            return rank[topfather];
        }

    }

    public int getindex(int i, int j) {
        return i * cols + j;
    }


    public int[] hitBricks(int[][] grid, int[][] hits) {
        rows = grid.length;
        cols = grid[0].length;
        int[] res = new int[hits.length];
        boolean[] miss = new boolean[hits.length];
        if (rows == 1) {
            for (int i = 0; i < res.length; ++i) {
                res[i] = 0;
            }
            return res;
        }

        for (int i = 0; i < hits.length; ++i) {
            if (grid[hits[i][0]][hits[i][1]] == 0) {
                miss[i] = true;
            }
            grid[hits[i][0]][hits[i][1]] = 0;
        }

        UnionFind unionFind = new UnionFind(grid);
        int top0 = unionFind.linkedTop();

        for (int i = hits.length - 1; i > -1; --i) {
            if (!miss[i]) {
                unionFind.linkedaround(hits[i][0], hits[i][1]);
                int topcache = unionFind.linkedTop();
                if (topcache != top0)
                    res[i] = topcache - top0 - 1;
                else
                    res[i] = 0;
                top0 = topcache;
            }

        }

        return res;
    }
}




