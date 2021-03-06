import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        int[] ints = new int[]{1, 2, 4, 4, 45, 45};
        int[] res = main.topKFrequent(ints, 1);
        for (int it : res)
            System.out.println(it);
    }

    static class int_plus {
        int val;
        int freq;

        public int_plus(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }

    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<int_plus> minHeap = new PriorityQueue<>((a, b) -> a.freq - b.freq);
        int[] res = new int[k];
        int cache;
        for (int it : nums) {
            cache = freq.getOrDefault(it, 0) + 1;
            freq.put(it, cache);
        }
        for (int it : freq.keySet()) {
            int_plus int_plus = new int_plus(it, freq.get(it));
            if (minHeap.size() < k )
                minHeap.add(int_plus);
            else if(int_plus.freq > minHeap.peek().freq){
                minHeap.poll();
                minHeap.add(int_plus);
            }
        }
        for (int i = k-1; i > -1; --i) {
            int_plus res_int = minHeap.poll();
            res[i] = res_int.val;
        }
        return res;
    }

}





