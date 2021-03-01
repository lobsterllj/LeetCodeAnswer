import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();

        int[][] heights = new int[][]{
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };

        System.out.println(main.minimumEffortPath(heights));

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


    int rows;
    int cols;

    public int minimumEffortPath(int[][] heights) {

        rows = heights.length;
        cols = heights[0].length;
        int last = rows * cols - 1;

        unionFind unionFind = new unionFind(rows * cols);

        List<edge> edgeList = new ArrayList<edge>();
        List<int[]> edges = new ArrayList<>();

        for (int row = 0; row < rows; ++row) {
            for (int col = 1; col < cols; ++col) {
                edge cache = new edge(getIndex(row, col - 1), getIndex(row, col), Math.abs(heights[row][col] - heights[row][col - 1]));
                edgeList.add(cache);
            }
        }

        for (int col = 0; col < cols; ++col) {
            for (int row = 1; row < rows; ++row) {
                edge cache = new edge(getIndex(row - 1, col), getIndex(row, col), Math.abs(heights[row][col] - heights[row - 1][col]));
                edgeList.add(cache);
            }
        }

        edgeList.sort((e1, e2) -> (e1.dis - e2.dis));
        for (edge it : edgeList) {
            unionFind.union(it.x, it.y);
            if (unionFind.isConnected(0, last)) {
                return it.dis;
            }
        }
        return 0;

    }

    public int getIndex(int row, int col) {
        return row * cols + col;
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


    class LFUCache {
        //使用频次最小元素的使用频次
        int minfreq;

        //LFUCache容量大小
        int capacity;

        //key_Node 哈希表
        Map<Integer, Node> key_table;

        //freq_doublelinkedlist
        Map<Integer, LinkedList<Node>> freq_list;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            minfreq = 0;
            key_table = new HashMap<>();
            freq_list = new HashMap<>();
        }

        public int get(int key) {
            if (capacity == 0)
                return -1;
            if (!key_table.containsKey(key)) {
                return -1;
            }
            //更新key_table与freq_list


//            //如果当前freq对应的freq_list内的链表为空，需要删除此链表
//            if () {
//
////                如果此freq为minfreq 当前被查找的元素的freq一定为minfreq 故将minfreq更新为freq + 1 即minfreq + 1
//                if () {
//
//                }
//
//            }

            return 0;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            if (!key_table.containsKey(key)) {
                //如果原表内不含有该元素，故需要添加新元素，可能会导致超出容量范围
                if (key_table.size() == capacity) {


//                    如果当前minfreq对应的freq_list内的链表为空，需要删除此链表
//                    if () {
//
//                    }


                }


                minfreq = 1;
            } else {
                //如果原表内已经含有该元素，故没有添加新元素，不会导致超出容量范围


////            如果当前freq对应的freq_list内的链表为空，需要删除此链表
//            if () {
//
////                如果此freq为minfreq 当前被查找的元素的freq一定为minfreq 故将minfreq更新为freq + 1 即minfreq + 1
//                if () {
//
//                }
//
//            }


            }
        }
    }

    class Node {
        int key, val, freq;

        Node(int key, int val, int freq) {
            this.key = key;
            this.val = val;
            this.freq = freq;
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
