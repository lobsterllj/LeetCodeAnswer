import java.util.*;

public class main {
    static class MedianFinder {
        double mediaNum;
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;
        int cache;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            minHeap = new PriorityQueue<>((a, b) -> a - b);
            maxHeap = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int num) {
            if (minHeap.size() == 0 && maxHeap.size() == 0) {
                mediaNum = (double) num;
                maxHeap.add(num);
            } else {
                if (minHeap.size() < maxHeap.size()) {
                    cache = maxHeap.poll();
                    minHeap.add(Math.max(cache, num));
                    maxHeap.add(Math.min(cache, num));
                    mediaNum = ((double) (minHeap.peek()) + (double) (maxHeap.peek())) / 2;
                } else if (minHeap.size() > maxHeap.size()) {
                    cache = minHeap.poll();
                    minHeap.add(Math.max(cache, num));
                    maxHeap.add(Math.min(cache, num));
                    mediaNum = ((double) (minHeap.peek()) + (double) (maxHeap.peek())) / 2;
                } else {
                    cache = maxHeap.peek();
                    if (num > cache) {
                        minHeap.add(num);
                        mediaNum = minHeap.peek();
                    } else {
                        maxHeap.add(num);
                        mediaNum = maxHeap.peek();
                    }

                }
            }
            for (int it : maxHeap) {
                System.out.println("maxheap" + it);
            }

            for (int it : minHeap) {
                System.out.println("minheap" + it);
            }
        }

        public double findMedian() {
            return mediaNum;
        }
    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */

    public static void main(String[] args) {
        main main = new main();
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        System.out.println(obj.findMedian());
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
        obj.addNum(4);
        System.out.println(obj.findMedian());


    }


}





