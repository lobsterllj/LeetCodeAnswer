import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();

        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        prtInts.prt(main.topKFrequent(nums, k));

    }


    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cnts = new HashMap<>();
        for (int it : nums) {
            int cnt = cnts.getOrDefault(it, 0) + 1;
            cnts.put(it, cnt);
        }

        int len = nums.length;
        List<Integer>[] lists = new List[len + 1];

        for (int key : cnts.keySet()) {
            int freq = cnts.get(key);
            if (lists[freq] == null)
                lists[freq] = new ArrayList<>();
            lists[freq].add(key);
        }

        List<Integer> res_list = new ArrayList<Integer>();
        for (int i = len; i > 0 && res_list.size() < k; --i) {
            if (lists[i] != null)
                res_list.addAll(lists[i]);
        }

        int resLen = res_list.size();
        int[] res = new int[resLen];
        for (int i = 0; i < resLen; ++i) {
            res[i] = res_list.get(i);
        }
        return res;

    }

}
