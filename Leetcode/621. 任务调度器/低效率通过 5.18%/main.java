import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;
import java.util.concurrent.DelayQueue;

public class main {

    public static void main(String[] args) {
        main main = new main();
        char[] tasks=new char[]{'A','A','A','B','B','B'};
        char[] tasks1=new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'};

        System.out.println(main.leastInterval(tasks1,2));

    }

    class charPlus {
        char val;
        int cnt;

        public charPlus(char val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }

    }

    public int leastInterval(char[] tasks, int n) {
        if (n == 0)
            return tasks.length;
        Map<Character, Integer> cnts = new HashMap<>();
        for (char it : tasks) {
            int cache = cnts.getOrDefault(it, 0) + 1;
            cnts.put(it, cache);
        }
        int pocTime = 0;
        PriorityQueue<charPlus> maxheap = new PriorityQueue<charPlus>((a, b) -> b.cnt - a.cnt);
        for (char it : cnts.keySet()) {
            maxheap.add(new charPlus(it, cnts.get(it)));
        }
        Deque<charPlus> msgQue = new ArrayDeque<>();
        charPlus nul = new charPlus('n', 0);
        int cnt_nulInmsq = 0;
        int cnt_mask=cnts.size();
        while ((!maxheap.isEmpty()) || (!msgQue.isEmpty())) {
            prt(maxheap,msgQue,pocTime);
            if (maxheap.isEmpty()) {
                msgQue.addLast(nul);
                cnt_nulInmsq++;
            } else {
                charPlus in_cache = maxheap.poll();
                msgQue.addLast(in_cache);
            }
            if (msgQue.size() == n + 1) {
                pocTime++;
                charPlus out_cache = msgQue.pollFirst();
                if (out_cache.equals(nul)){
                    if(cnt_nulInmsq>=n&&cnt_mask==0)
                        break;
                    cnt_nulInmsq--;
                    continue;
                }
                out_cache.cnt--;
                if(out_cache.cnt==0){
                    cnt_mask--;
                }
                if (out_cache.cnt > 0 ) {
                    maxheap.add(out_cache);
                }
            }
        }
        return --pocTime;

    }
    public void prt(PriorityQueue<charPlus> maxheap,Deque<charPlus> msgQue,int time){
        System.out.println("times:"+time);
        System.out.print("maxheap  ");
        for(charPlus it:maxheap){
            System.out.print("val:"+it.val+" cnt:"+it.cnt+" / ");
        }
        System.out.println();
        System.out.print("msgQue  ");
        for(charPlus it:msgQue){
            System.out.print("val:"+it.val+" cnt:"+it.cnt+" / ");
        }
        System.out.println();
    }

}
