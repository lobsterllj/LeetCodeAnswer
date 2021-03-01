import jdk.swing.interop.SwingInterOpUtils;

import javax.lang.model.type.IntersectionType;
import java.net.http.WebSocketHandshakeException;
import java.sql.SQLOutput;
import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};

        System.out.println(main.fourSumCount(A,B,C,D));

//        List res = main.fourSum(ints, -11);
//        res.forEach(it -> System.out.println(it));

    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A.length == 0)
            return 0;
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);
        int len = A.length;
        if (A[0] + B[0] + C[0] + D[0] > 0 || A[len - 1] + B[len - 1] + C[len - 1] + D[len - 1] < 0)
            return 0;

        Map<Integer, Integer> AB = new HashMap<>();
        Map<Integer, Integer> CD = new HashMap<>();
        int res = 0;

        int cache_ab, cache_cd;
        for (int j = 0; j < A.length; ++j) {
            for (int i = 0; i < B.length; ++i) {
                cache_ab = AB.getOrDefault(A[j] + B[i], 0) + 1;
                AB.put(A[j] + B[i], cache_ab);
            }
        }
        for (int j = 0; j < C.length; ++j) {
            for (int i = 0; i < D.length; ++i) {
                if (AB.containsKey(-(C[i] + D[j])))
                    res += AB.get(-(C[i] + D[j]));
            }
        }

        return res;
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length < 4)
            return res;

        Arrays.sort(nums);
        int len = nums.length;
        int mid;
        int large;
        for (int j = 0; j < len - 3; ++j) {
            if (j > 0 && nums[j] == nums[j - 1])
                continue;
            if (nums[j] + nums[j + 1] + nums[j + 2] + nums[j + 3] > target)
                return res;

            if (nums[j] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target)
                continue;

            for (int i = j + 1; i < len - 2; ++i) {
                if (i > j + 1 && nums[i] == nums[i - 1])
                    continue;

                mid = i + 1;
                large = len - 1;

                while (mid < large) {
                    if (nums[j] + nums[i] + nums[mid] + nums[large] == target) {
                        res.add(Arrays.asList(nums[j], nums[i], nums[mid], nums[large]));
                        mid++;
                        large--;
                        while (nums[mid] == nums[mid - 1] && mid < large) {
                            mid++;
                        }
                        while (nums[large] == nums[large + 1] && mid < large) {
                            large--;
                        }
                    } else if (nums[j] + nums[i] + nums[mid] + nums[large] < target) {
                        mid++;
                    } else {
                        large--;
                    }
                }
            }
        }
        return res;
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


}
