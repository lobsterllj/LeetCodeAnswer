import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        main aa = new main();
        int[] ints = new int[]{3, 4, 1, 5};
        System.out.println(aa.increasingTriplet(ints));

    }

    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3)
            return false;
        int last = Integer.MAX_VALUE;
        int lastButOne = Integer.MAX_VALUE;
        for (int it : nums) {
            if (it <= last)
                last = it;
            else if (it <= lastButOne)
                lastButOne = it;
            else
                return true;
        }
        return false;
    }
}





