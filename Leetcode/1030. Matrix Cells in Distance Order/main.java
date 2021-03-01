import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class main {
    public static void main(String[] args) {
        main main = new main();

    }

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {

        int[][] res = new int[R * C][2];
        int index = 0;
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                res[index++]=new int[]{i,j};
            }
        }
        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return manhattan(o1[0], o1[1], r0, c0) - manhattan(o2[0], o2[1], r0, c0);
            }
        });

        return res;
    }

    public int[][] allCellsDistOrder1(int R, int C, int r0, int c0) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return manhattan(o1[0], o1[1], r0, c0) - manhattan(o2[0], o2[1], r0, c0);
            }
        });

        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                minHeap.add(new int[]{i, j});
            }
        }
        int[][] res = new int[minHeap.size()][2];
        int index = 0;
        for (int k = minHeap.size(); k > 0; --k) {
            res[index++] = minHeap.poll();
        }
        return res;
    }

    public int manhattan(int R, int C, int r, int c) {
        return Math.abs(R - r) + Math.abs(C - c);
    }

    public int manhattan1(int R, int C, int r, int c) {
        int res = 0;
        res += (R > r ? R - r : r - R);
        res += (C > c ? C - c : c - C);
        return res;
    }

}





