import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        int[][] ints = new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int[][] ints1 = new int[][]{{2, 3, 6, 6, 10}, {5, 9, 12, 17, 19}, {10, 14, 17, 20, 20}, {15, 17, 20, 24, 24}, {20, 20, 25, 26, 29}};

        System.out.println(main.kthSmallest(ints1, 4));

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
                //System.out.println("maxHeap:" + maxHeap);
            }
            if (i == n - 1 || matrix[i][0] > maxHeap.peek()) {
                break;
            }
        }
        //System.out.println("k_offset:" + k_offset);
        List<Integer> num=new LinkedList<>();
        List<Integer> num_cnts=new LinkedList<>();
        int buffer;
        while(!maxHeap.isEmpty()){
            buffer=maxHeap.poll();
            num.add(buffer);
            num_cnts.add(k_offset.get(buffer));
        }
        int cnts=0;
        for(int i=num.size()-1;i>-1;--i){
            cnts+=num_cnts.get(i);
            if(cnts>k-1)
                return num.get(i);
        }


        return 0;
    }
}





