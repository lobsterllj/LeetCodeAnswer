import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();

        int[][] events = new int[][]{
                {1, 4},
                {4, 4},
                {2, 2},
                {3, 4},
                {1, 1}
        };

        System.out.println("res: " + main.maxEvents(events));

    }

    public int maxEvents(int[][] events) {
        int len = events.length;
        if (len == 1)
            return 1;
        Arrays.sort(events, (e1, e2) -> e1[0] - e2[0]);

        //维护一个按结束时间升序的堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int res = 0;
        int cur = 1;
        int index = 0;

        while (!pq.isEmpty() || index < len) {
            //开始日期相同的入堆
            while (index < len && events[index][0] == cur) {
                pq.add(events[index++][1]);
            }

            //结束时间在当前时间（cur）之前的弹出
            while (!pq.isEmpty() && pq.peek() < cur) {
                pq.poll();
            }

            //选择参会堆顶元素
            if (!pq.isEmpty()) {
                res++;
                pq.poll();
            }

            //处理下一天
            cur++;
        }

        return res;
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
        }

    }


}
