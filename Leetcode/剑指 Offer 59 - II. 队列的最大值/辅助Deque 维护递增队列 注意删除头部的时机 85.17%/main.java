import java.util.ArrayDeque;
import java.util.Deque;

public class main {
    static class MaxQueue {
        Deque<Integer> items;
        Deque<Integer> maxValue;

        public MaxQueue() {
            items = new ArrayDeque<>();
            maxValue = new ArrayDeque<>();
        }

        public int max_value() {
            if (maxValue.isEmpty())
                return -1;
            return maxValue.peekFirst();
        }

        public void push_back(int value) {
            items.addLast(value);
            while (!maxValue.isEmpty() && value > maxValue.peekLast()) {
                maxValue.pollLast();
            }
            maxValue.addLast(value);
        }

        public int pop_front() {
            if (items.isEmpty())
                return -1;
            int value = items.pollFirst();
            if (maxValue.peekFirst() == value) {
                maxValue.pollFirst();
            }
            return value;
        }
    }

    public static void main(String[] args) {
        main main = new main();
        MaxQueue obj = new MaxQueue();
        int param_1 = obj.max_value();
        System.out.println(param_1);
        obj.push_back(3);
        int param_3 = obj.pop_front();
        System.out.println(param_3);
    }

}

