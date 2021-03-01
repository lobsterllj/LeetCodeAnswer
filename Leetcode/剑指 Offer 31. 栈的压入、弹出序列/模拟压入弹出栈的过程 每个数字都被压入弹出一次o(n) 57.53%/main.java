import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        int[] pushed = new int[]{2,1,0};
        int[] popped = new int[]{1,2,0};
        System.out.println(main.validateStackSequences(pushed, popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length < 2)
            return true;

        Deque<Integer> ori = new LinkedList<>();
        for (int i = 0; i < pushed.length; ++i) {
            ori.addLast(pushed[i]);
        }
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < popped.length; ++i) {
            System.out.println("--------------");
            System.out.println("ori"+ori);
            System.out.println("stack"+stack);

            //stack栈顶==popped【i】直接把数字从pushed弹出
            if(!stack.isEmpty()&&stack.peekLast()==popped[i]){
                stack.pollLast();
                continue;
            }
            //pushed不等于popped【i】的全部入栈
            while (!ori.isEmpty() && ori.peekFirst() != popped[i]) {
                stack.addLast(ori.pollFirst());
            }
            //pushed【k】==popped【i】直接把数字从pushed弹出
            if (!ori.isEmpty() &&ori.peekFirst() == popped[i]) {
                ori.pollFirst();
                continue;
            }

            return false;

        }
        return stack.isEmpty();
    }


}

