import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        int[][] ints = new int[][]{{1, 5, 9},
                                 {10, 11, 13},
                                 {12, 13, 15}};
//        int[][] ints1 = new int[][]{{1,  2,  3,  6,  10},
//                                    {1,  3,  12, 17, 19},
//                                    {1, 14, 17, 20, 20},
//                                    {1, 17, 20, 24, 24},
//                                    {1, 20, 25, 26, 29}};

        int[][] ints1 = new int[][]{{1, 2}, {1, 3}};


        System.out.println(main.mergesort(ints, 8));


    }

    static class ValOFwhichRows {
        int val;
        int rows;

        public ValOFwhichRows(int val, int rows) {
            this.val = val;
            this.rows = rows;
        }
    }


    public int mergesort(int[][] matrix, int k) {
        if (matrix.length == 0)
            return 0;
        int n = matrix.length;
        PriorityQueue<ValOFwhichRows> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.val != b.val)
                return (a.val-b.val);
            else
                return (a.rows- b.rows);
        });
        int[] pointer = new int[n];//记录martix每一行当前待比较的位置
        for (int i = 0; i < n; ++i) {
            ValOFwhichRows node = new ValOFwhichRows(matrix[i][pointer[i]], i);
            minHeap.add(node);
        }
        int cnt=0;
        while (cnt< k-1) {
            System.out.println("cnt:"+cnt);
            //查找至martix第k大的数
            //弹出最小的元素
            System.out.println("minheap.peek:");
            minHeap.forEach(it-> System.out.println(it.val));
            ValOFwhichRows node=minHeap.peek();

            if(pointer[node.rows]==n-1){
                System.out.println("node.val000:"+node.val);
                System.out.println("node.rows000:"+node.rows);
                node=minHeap.poll();
                cnt++;
                System.out.println("node:"+node.val);
                continue;
            }
            node=minHeap.poll();
            cnt++;
            System.out.println("node.val:"+node.val);
            System.out.println("node.rows:"+node.rows);

            pointer[node.rows]++;
            node.val=matrix[node.rows][pointer[node.rows]];
            minHeap.add(node);
        }

        return minHeap.peek().val;
    }


    public int wrongkthSmallest2(int[][] matrix, int k) {
        if (matrix.length == 0)
            return 0;
        else if (k == 1)
            return matrix[0][0];
        else {
            int[] diagonals = new int[(2 * matrix.length) - 1];
            diagonals[0] = 1;
            for (int i = 1; i < (diagonals.length >> 1) + 1; ++i) {
                diagonals[i] = diagonals[i - 1] + i + 1;
            }
            for (int i = (diagonals.length >> 1) + 1; i < diagonals.length; ++i) {
                diagonals[i] = diagonals[i - 1] + 9 - i;
            }
            for (int i = 0; i < diagonals.length; i++) {
                System.out.println("i:" + i + "diagonals:" + diagonals[i]);
            }
            int index_diag = find(k, diagonals);
            System.out.println("k:" + k + "find:" + find(k, diagonals));

            int y = k - diagonals[index_diag - 1] - 1;
            int x = index_diag - y;
            return matrix[y][x];
        }
    }

    public int find(int tar, int[] ints) {
        if (ints.length == 0)
            return 0;
        int begin = 0;
        int end = ints.length - 1;
        int compare;
        while (begin != end) {
            compare = (begin + end) >> 1;
            System.out.println("tar:" + tar + " int[compare]" + ints[compare]);
            if (tar > ints[compare])
                begin = compare + 1;
            else
                end = compare;
        }
        return begin;
    }


    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0)
            return 0;
        Set<Integer> set_matrix = new HashSet<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int cnts_cache;
        Map<Integer, Integer> k_offset = new HashMap<>();

        int n = matrix.length;
        //第i行，第j列
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                set_matrix.add(matrix[i][j]);
                if (k_offset.containsKey(matrix[i][j])) {
                    cnts_cache = k_offset.get(matrix[i][j]) + 1;
                    k_offset.put(matrix[i][j], cnts_cache);
                } else {
                    k_offset.put(matrix[i][j], 1);
                    if (k_offset.size() < k + 1) {
                        maxHeap.add(matrix[i][j]);
                    } else {
                        if (matrix[i][j] < maxHeap.peek()) {
                            maxHeap.poll();
                            maxHeap.add(matrix[i][j]);
                        }
                    }
                }
                System.out.println("maxHeap:" + maxHeap);
            }
            if (i == n - 1 || matrix[i][0] > maxHeap.peek()) {
                break;
            }
        }
        //System.out.println("k_offset:" + k_offset);
        List<Integer> num = new LinkedList<>();
        List<Integer> num_cnts = new LinkedList<>();
        int buffer;
        while (!maxHeap.isEmpty()) {
            buffer = maxHeap.poll();
            num.add(buffer);
            num_cnts.add(k_offset.get(buffer));
        }
        int cnts = 0;
        for (int i = num.size() - 1; i > -1; --i) {
            cnts += num_cnts.get(i);
            if (cnts > k - 1)
                return num.get(i);
        }


        return 0;
    }
}





