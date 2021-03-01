import java.util.*;
import java.util.concurrent.DelayQueue;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] ints = new int[]{1, 2, 3, 4, 4, 5, 5};
        System.out.println(main.isPossible(ints));
    }

    public boolean isPossible(int[] nums) {
        if (nums.length < 3)
            return false;
        Map<Integer, PriorityQueue<Integer>> cnts = new HashMap<>();
        //key=int in nums     val=EndByKey length of lines;
        for (int it : nums) {
            System.out.println("it"+it);


            if (!cnts.containsKey(it))
                cnts.put(it, new PriorityQueue<Integer>());
            if (cnts.containsKey(it - 1)) {
                PriorityQueue<Integer> cache = cnts.get(it - 1);
                int temp_len = cache.poll() + 1;
                if(cache.isEmpty())
                    cnts.remove(it-1);
                cnts.get(it).add(temp_len);
            }
            else {
                PriorityQueue<Integer> cache = cnts.get(it);
                cache.add(1);
                cnts.put(it,cache);
            }
            for(int it1:cnts.keySet())
                System.out.println("it1:"+it1+" pq:"+cnts.get(it1));
        }
        for(int it:cnts.keySet()) {
            PriorityQueue<Integer> res=cnts.get(it);
            while (!res.isEmpty())
                if(res.poll()<3)
                    return false;
        }

        return true;
    }


}
