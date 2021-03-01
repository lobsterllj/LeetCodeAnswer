import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();
        int[][] matrix = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1},
                {0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1}
        };

        System.out.println(main.largestSubmatrix(matrix));

    }

    public int largestSubmatrix(int[][] matrix) {
        int Rows = matrix.length;
        int Cols = matrix[0].length;
        int[][] heights = new int[Rows][Cols];
        for (int col = 0; col < Cols; ++col) {
            heights[0][col] = matrix[0][col];
        }
        for (int row = 1; row < Rows; ++row) {
            for (int col = 0; col < Cols; ++col) {
                if (matrix[row][col] == 1) {
                    heights[row][col] = heights[row - 1][col] + 1;
                }
            }
        }
        for (int row = 0; row < Rows; ++row) {
            Arrays.sort(heights[row]);
        }

        int res = 0;
        for (int row = 0; row < Rows; ++row) {
            int cache = getMaxSquare(heights[row]);
            res = Math.max(res, cache);
        }
        return res;
    }

    public int getMaxSquare(int[] h) {
        int len_h = h.length;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(-1);
        int[] leftSubIndex = new int[len_h];
        for (int i = 0; i < len_h; ++i) {
            while (stack.peekLast() != -1 && h[stack.peekLast()] >= h[i]) {
                stack.pollLast();
            }
            leftSubIndex[i] = stack.peekLast();
            stack.add(i);
        }

        Deque<Integer> stack1 = new ArrayDeque<>();
        stack1.add(len_h);
        int[] rightSubIndex = new int[len_h];
        for (int i = len_h - 1; i > -1; --i) {
            while (stack1.peekLast() != len_h && h[stack1.peekLast()] >= h[i]) {
                stack1.pollLast();
            }
            rightSubIndex[i] = stack1.peekLast();
            stack1.add(i);
        }

        int res = 0;
        for (int i = 0; i < len_h; ++i) {
            int cache = h[i] * (rightSubIndex[i] - leftSubIndex[i] - 1);
            res = Math.max(res, cache);
        }

        return res;
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
