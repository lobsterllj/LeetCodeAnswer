import java.sql.SQLOutput;
import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int a=Integer.MAX_VALUE-1;
        int b=Integer.MAX_VALUE-2;
        System.out.println((a+b)>>1);
        System.out.println((a+b)>>>1);
        int[] ints = new int[]{1, 2, 3, 3, 5};
        int[] ints1 = new int[]{3, 3};
        int target = 3;
        System.out.println("findFirstIndex");
        System.out.println(main.findFirstIndex(ints, target));
        System.out.println("findLastIndex");
        System.out.println(main.findLastIndex(ints, target));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};
        int firstIndex = findFirstIndex(nums, target);
        if (firstIndex == -1)
            return new int[]{-1, -1};
        int lastIndex = findLastIndex(nums, target);
        return new int[]{firstIndex, lastIndex};
    }

    public int findFirstIndex(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        int comp;
        while (begin != end) {
            comp = (begin + end) >> 1;
            System.out.println("begin:" + begin + " comp:" + comp + " end:" + end);
            System.out.println(nums[begin] + " " + nums[comp] + " " + nums[end]);
            if (nums[comp] < target)
                begin = comp + 1;
                //搜索区间-> [comp+1,end]
            else
                end = comp;
                //当可能包含target时，以target作为区间结束索引，对搜索区间进行向前截取，搜索区间-> [begin,comp]
        }
        if (nums[begin] != target)
            return -1;
        return begin;
    }

    public int findLastIndex(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        int comp = 0;
        while (begin != end) {
            comp = (begin + end + 1) >> 1;
            System.out.println("begin:" + begin + " comp:" + comp + " end:" + end);
            System.out.println(nums[begin] + " " + nums[comp] + " " + nums[end]);
            if (nums[comp] > target)
                end = comp - 1;
                //搜索区间-> [begin,comp-1]
            else
                begin = comp;
                //当可能包含target时，以target作为区间开始索引，对搜索区间进行向后截取，搜索区间-> [comp,end]

        }
        if (nums[begin] != target)
            return -1;
        return begin;
    }
}
