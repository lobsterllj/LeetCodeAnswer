import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        int[] in = {1,2,2,4};
        main aa = new main();
        System.out.println(aa.twoSum(in,4)[0]);
        System.out.println(aa.twoSum(in,4)[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> search=new HashMap<>();
        for(int i=0;i<nums.length;++i)
        {
            if(search.containsKey(nums[i]))
            {
                return new int[]{search.get(nums[i]),i};
            }
            search.put(target-nums[i],i);
        }
        return new int[]{0, 0};
    }

}
