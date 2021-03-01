import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] ints = new int[]{3, 30, 34, 5, 9};
        System.out.println(main.minNumber(ints));
    }

    public String minNumber(int[] nums) {
        String[] res = new String[nums.length];
        for (int i = 0; i < nums.length; ++i)
            res[i] = String.valueOf(nums[i]);

        Arrays.sort(res, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }

        });
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; ++i) {
            result.append(res[i]);
        }
        return result.toString();
    }


}

