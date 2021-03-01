import java.util.PriorityQueue;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] nums = new int[]{2, 7, 4, 1, 8, 1};
        System.out.println(main.lastStoneWeight(nums));
    }

    public int lastStoneWeight(int[] stones) {
        if (stones.length == 0) {
            return stones[0];
        }
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < stones.length; ++i) {
            maxheap.add(stones[i]);
        }

        while (maxheap.size() > 1) {
            int max = maxheap.poll();
            int cache = maxheap.poll();
            maxheap.add(max - cache);

        }
        return maxheap.peek();
    }

}

