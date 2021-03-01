import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class main {

    public static void main(String[] args) {
        main main = new main();

    }

    class CQueue {
        Deque<Integer> in;
        Deque<Integer> out;

        public CQueue() {
            this.in = new ArrayDeque<>();
            this.out = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            in.addFirst(value);
        }

        public int deleteHead() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.addFirst(in.pollFirst());
                }
            }
            if (out.isEmpty()) {
                return -1;
            }
            return out.pollFirst();
        }
    }

}
