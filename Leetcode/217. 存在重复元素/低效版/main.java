import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        main aa = new main();
        int[] ints=new int[]{1,2,3,1};
        System.out.println(aa.containsDuplicate(ints));


    }
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> cnts = new HashMap();
        Integer cache = 0;
        for (int it : nums) {
            if (cnts.containsKey(it)) {
                cache = cnts.get(it) + 1;
                cnts.put(it, cache);
            } else {
                cnts.put(it, 1);
            }
        }
        for (int i : cnts.keySet()) {
            if(cnts.get(i)>1)
                return true;
        }
        return false;
    }
}
