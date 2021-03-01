import jdk.swing.interop.SwingInterOpUtils;

import javax.lang.model.type.IntersectionType;
import java.net.http.WebSocketHandshakeException;
import java.sql.SQLOutput;
import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] ints = new int[]{34, 55, 79, 28, 46, 33, 2, 48, 31, -3, 84, 71, 52, -3, 93, 15, 21, -43, 57, -6, 86, 56, 94, 74, 83, -14, 28, -66, 46, -49, 62, -11, 43, 65, 77, 12, 47, 61, 26, 1, 13, 29, 55, -82, 76, 26, 15, -29, 36, -29, 10, -70, 69, 17, 49};
//        List res = main.threeSum(ints);
//        res.forEach(it -> System.out.println(it));
        int[] ints1 = new int[]{4, 5};
        System.out.println(main.removeElement(ints1, 5));
        for (int i = 0; i < ints1.length; i++) {
            System.out.println("ints1 = " + ints1[i]);
        }

    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;
        int left = 0;
        int right = nums.length - 1;
        int cnts = nums.length;
        while (left < right) {
            if (nums[left] != val) {
                left++;
            } else if (nums[right] == val) {
                right--;
            }
            if (nums[left] == val && nums[right] != val) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == val)
                cnts--;
            else
                break;
        }
        return cnts;
    }

    public void swap(int[] nums, int i, int j) {
        int cache = nums[i];
        nums[i] = nums[j];
        nums[j] = cache;
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length < 3)
            return res;
        Arrays.sort(nums);
        int mid;
        int large;
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] > 0)
                return res;
            mid = i + 1;
            large = nums.length - 1;
            while (mid < large) {
                if (nums[i] + nums[mid] + nums[large] == 0) {
                    res.add(Arrays.asList(nums[i], nums[mid], nums[large]));
                    mid++;
                    large--;
                    while (nums[mid] == nums[mid - 1] && mid < large) {
                        mid++;
                    }
                    while (nums[large] == nums[large + 1] && mid < large) {
                        large--;
                    }
                } else if (nums[i] + nums[mid] + nums[large] < 0) {
                    mid++;
                } else {
                    large--;
                }
            }
        }
        return res;
    }


}
