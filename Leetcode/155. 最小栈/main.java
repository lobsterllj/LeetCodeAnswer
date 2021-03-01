import javax.swing.*;
import java.nio.channels.ClosedSelectorException;
import java.util.*;

public class main {
    private static class node {
        int val;
        node pre;
        int min;

        public node() {
            this.pre = null;
        }
    }

    private static class MinStack {
        node topone;

        public MinStack() {
            topone = null;
        }

        public void push(int x) {
            if (topone == null) {
                topone = new node();
                topone.val = x;
                topone.min = x;
                topone.pre = null;
            } else {
                node cache = topone;
                int min_cache = topone.min;
                topone = new node();
                topone.val = x;
                topone.min = min_cache;
                topone.pre = cache;
                if (x < min_cache)
                    topone.min = x;
            }
        }

        public void pop() {
            node cache = topone;
            topone = topone.pre;
        }

        public int top() {
            return topone.val;
        }

        public int getMin() {
            return topone.min;
        }
    }

    public static void main(String[] args) {
        main aa = new main();
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        System.out.println(obj.top());
        System.out.println(obj.getMin());

    }


}





