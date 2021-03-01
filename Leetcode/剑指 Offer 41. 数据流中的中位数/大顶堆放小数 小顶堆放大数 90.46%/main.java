import java.util.PriorityQueue;

public class main {
    static class MedianFinder {
        double median;
        PriorityQueue<Integer> minheap;
        PriorityQueue<Integer> maxheap;
        int cache;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            minheap = new PriorityQueue<>((a, b) -> a - b);
            maxheap = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int num) {
            if (minheap.size() == 0 && maxheap.size() == 0) {
                maxheap.add(num);
                median = (double) num;
            } else if (minheap.size() < maxheap.size()) {
                cache = maxheap.poll();
                maxheap.add(Math.min(cache, num));
                minheap.add(Math.max(cache, num));
                median = (((double) minheap.peek()) + ((double) maxheap.peek())) / 2;
            } else if (minheap.size() > maxheap.size()) {
                cache = minheap.poll();
                maxheap.add(Math.min(cache, num));
                minheap.add(Math.max(cache, num));
                median = (((double) minheap.peek()) + ((double) maxheap.peek())) / 2;
            } else {
                cache = maxheap.peek();
                if (num > cache) {
                    minheap.add(num);
                    median = (double) minheap.peek();
                } else {
                    maxheap.add(num);
                    median = (double) maxheap.peek();
                }
            }
            for (int it : maxheap) {
                System.out.println("maxheap" + it);
            }

            for (int it : minheap) {
                System.out.println("minheap" + it);
            }
        }

        public double findMedian() {
            return median;
        }
    }

    public static void main(String[] args) {
        main main = new main();
        MedianFinder obj = new MedianFinder();
        obj.addNum(-1);
        System.out.println(obj.findMedian());
        obj.addNum(-2);
        System.out.println(obj.findMedian());
        obj.addNum(-3);
        System.out.println(obj.findMedian());
        obj.addNum(-4);
        System.out.println(obj.findMedian());
        obj.addNum(-5);
        System.out.println(obj.findMedian());

    }


}

