public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();

        int n = 4;
        int[][] edges = new int[][]{
                {3, 1, 2},
                {3, 2, 3},
                {1, 1, 3},
                {1, 2, 4},
                {1, 1, 2},
                {2, 3, 4}
        };
        System.out.println(main.maxNumEdgesToRemove(n,edges));

    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        for (int[] edge : edges) {
            edge[1]--;
            edge[2]--;
        }
        unionFind unionFind1 = new unionFind(n);
        unionFind unionFind2 = new unionFind(n);
        int cnt = 0;

        //连接公共边
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (!unionFind1.isConnected(edge[1], edge[2])) {
                    unionFind1.union(edge[1], edge[2]);
                    unionFind2.union(edge[1], edge[2]);
                } else {
                    cnt++;
                }
            }
        }

        //连接私有边
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (!unionFind1.isConnected(edge[1], edge[2]))
                    unionFind1.union(edge[1], edge[2]);
                else
                    cnt++;
            } else if (edge[0] == 2) {
                if (!unionFind2.isConnected(edge[1], edge[2]))
                    unionFind2.union(edge[1], edge[2]);
                else
                    cnt++;
            }
        }

        if (unionFind1.groupNum > 1 || unionFind2.groupNum > 1)
            return -1;
        return cnt;
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

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
