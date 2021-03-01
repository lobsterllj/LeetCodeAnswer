import java.util.HashSet;
import java.util.Set;

public class main {
    public static void main(String[] args) {
        main aa = new main();
        int[] ints=new int[]{1,2,3,1};
        System.out.println(aa.containsDuplicate(ints));


    }
    public boolean containsDuplicate(int[] nums) {
        Set cnts=new HashSet<Integer>();
        for(int it:nums)
            cnts.add(it);
        return (cnts.size()!= nums.length);
    }
}
