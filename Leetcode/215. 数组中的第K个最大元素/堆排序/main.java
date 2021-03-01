import java.util.PriorityQueue;

public class main {
    public static void main(String[] args) {
        main main = new main();
        int[] ints=new int[]{0,2,3,4,1,3,4,5,7};
        System.out.println(main.findKthLargest(ints,2));

    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b);
        minHeap.add(nums[0]);
        for (int i = 1; i < k; ++i) {
            minHeap.add(nums[i]);
        }
        for (int i = k; i < nums.length; ++i) {
            if (nums[i] >= minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }


}
