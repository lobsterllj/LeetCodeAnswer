import java.sql.Array;
import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        int[] ints = new int[]{0,1,7};
        int[] res = main.sortByBits(ints);
        for (int re : res) {
            System.out.println(re);
        }
    }

    public int[] sortByBits(int[] arr) {
        if (arr.length == 0)
            return new int[]{};
        Set<Integer> cnt_1 = new HashSet();

        for (int i = 0; i < arr.length; ++i) {
            cnt_1.add(cntsOf1(arr[i]));
        }
        System.out.println(cnt_1);
        Map<Integer,Integer> index_cnt_1=new HashMap<>();
        int cache=0;
        for(int it:cnt_1){
            index_cnt_1.put(it,cache++);
        }
        List<PriorityQueue> minHeaps = new LinkedList<>();
        for (int i = 0; i < cnt_1.size(); ++i) {
            PriorityQueue<Integer> a = new PriorityQueue<>();
            minHeaps.add(a);
        }
        for (int i = 0; i < arr.length; ++i) {
            minHeaps.get(index_cnt_1.get(cntsOf1(arr[i]))).add(arr[i]);
        }
        int j = 0;
        for (PriorityQueue it : minHeaps) {
            while (!it.isEmpty()) {
                arr[j++] =((int) it.poll());
            }
        }
        return arr;
    }

    public int cntsOf1(int a) {
        int cnts = 0;
        while (a != 0) {
            if ((a & 1) == 1)
                cnts++;
            a >>= 1;
        }
        return cnts;
    }
}
