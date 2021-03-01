import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        main aa = new main();
        int[] a1=new int[]{1,2,2,3};
        int[] a2=new int[]{2,2,3};
        int[] res=aa.intersect(a1,a2);
        for(int it:res){
            System.out.println(it);
        }

    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> cnts_0 = new HashMap<>();
        Map<Integer, Integer> cnts = new HashMap<>();
        int cache;
        for (int it : nums1) {
            if (cnts_0.containsKey(it)) {
                cache = cnts_0.get(it) + 1;
                cnts_0.put(it, cache);
            } else {
                cnts_0.put(it, 1);
            }
        }
        for (int it : nums2) {
            if (cnts.containsKey(it)) {
                cache = cnts.get(it) + 1;
                cnts.put(it, cache);
            } else {
                cnts.put(it, 1);
            }
        }

        List<Integer> res_list = new ArrayList<>();
        for (int it : cnts_0.keySet()) {
            if (cnts.containsKey(it)) {
                cache=cnts_0.get(it)<cnts.get(it)?cnts_0.get(it):cnts.get(it);
                for(int i=0;i<cache;++i){
                    res_list.add(it);
                }
            }
        }
        int[] res = res_list.stream().mapToInt(Integer::valueOf).toArray();
        return res;

    }

}



