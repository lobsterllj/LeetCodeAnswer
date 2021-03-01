import java.util.*;
import java.util.concurrent.DelayQueue;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] ints = new int[]{1, 2, 3, 3, 4, 4, 5, 5};
        System.out.println(main.isPossible(ints));
    }

    public boolean isPossible(int[] nums) {
        if (nums.length < 3)
            return false;
        Map<Integer, Deque<Integer>> pre_map = new HashMap<>();
        Map<Integer, Deque<Integer>> next_map = new HashMap<>();
        int[] next_index = new int[nums.length];
        int[] pre_index = new int[nums.length];
        int[] cnt_linked = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            next_index[i] = -1;
            pre_index[i] = -1;
            cnt_linked[i] = 1;
        }

        for (int i = 0; i < nums.length; ++i) {
            Deque<Integer> stackPre = pre_map.getOrDefault(nums[i], new ArrayDeque<>());
            stackPre.addLast(i);
            pre_map.put(nums[i], stackPre);

            Deque<Integer> stackNex = next_map.getOrDefault(nums[i], new ArrayDeque<>());
            stackNex.addLast(i);
            next_map.put(nums[i], stackNex);
        }
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                Deque<Integer> stackNex = next_map.getOrDefault(nums[i], new ArrayDeque<>());
                stackNex.addLast(i);
                next_map.put(nums[i], stackNex);
                continue;
            }
            //取出【i+1】的索引栈
            Deque<Integer> stackPre = next_map.getOrDefault(nums[i + 1], new ArrayDeque<>());
            if(stackPre.size()==0)
                continue;
            //弹出栈底值,并更新preMap
            int linkedNextIndex = stackPre.pollFirst();
            pre_map.put(nums[i + 1], stackPre);

            //【i】->【linkedNextIndex】
            next_index[i] = linkedNextIndex;
            //【i】<-【linkedNextIndex】
            pre_index[linkedNextIndex] = i;
            //update 【linkedNextIndex】的前驱长度
            cnt_linked[linkedNextIndex] = cnt_linked[i] + 1;


        }
        System.out.println("向后搜索：");
        prtl(nums,next_index,pre_index,cnt_linked);


        for (int i = nums.length - 1; i > 0; --i) {
            System.out.println("curi:" + i);
            if (pre_index[i] != -1) {
                cnt_linked[pre_index[i]] = cnt_linked[i];
                continue;
            }
            //【i】不是其他节点的后继,寻找比nums【i】小1的前驱索引栈
            Deque<Integer>  stackNex= next_map.getOrDefault(nums[i] - 1, new LinkedList<>());
            if (stackNex.size() == 0)
                continue;

            //stackNex存在，弹出栈顶值
            int linkedPreIndex = stackNex.pollLast();
            System.out.println(linkedPreIndex);

            //【linkedPreIndex】->【i】
            next_index[linkedPreIndex] = i;
            //【linkedPreIndex】<-【i】
            pre_index[i] = linkedPreIndex;
            //update 【linkedPreIndex】的长度
            cnt_linked[linkedPreIndex] = cnt_linked[i] + 1;


        }
        System.out.println("向前搜索：");
        prtl(nums,next_index,pre_index,cnt_linked);

        return true;
    }

    public void prtl(int[] nums,int[] next_index,int[] pre_index,int[] cnt_linked){
        for (int i = 0; i < nums.length; ++i) {
            System.out.print("nums[" + i + "]:" + nums[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < nums.length; ++i) {
            System.out.print("next[" + i + "]:" + next_index[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < nums.length; ++i) {
            System.out.print("pre[" + i + "]:" + pre_index[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < nums.length; ++i) {
            System.out.print("cnt[" + i + "]:" + cnt_linked[i] + " ");
        }
        System.out.println();
    }
}
