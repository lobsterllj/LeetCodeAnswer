import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] ints1 = new int[]{1, 2};
        int[] ints2 = new int[]{3, 4};
        System.out.println(main.findMedianSortedArrays(ints1, ints2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int mid_left = (len1 + len2 + 1) >>> 1;
        int mid_right = (len1 + len2 + 2) >>> 1;

        return 0.5 * (getKth(nums1, nums2, 0, len1 - 1, 0, len2 - 1, mid_left)
                + getKth(nums1, nums2, 0, len1 - 1, 0, len2 - 1, mid_right));
    }

    public int getKth(int[] nums1, int[] nums2, int sta1, int end1, int sta2, int end2, int k) {
        int len1 = end1 - sta1 + 1;
        int len2 = end2 - sta2 + 1;
        if (len1 > len2)
            return getKth(nums2, nums1, sta2, end2, sta1, end1, k);
        if (len1 == 0)
            return nums2[sta2 + k - 1];
        if (k == 1)
            return Math.min(nums1[sta1], nums2[sta2]);

        int newsta1 = sta1 + Math.min(len1, (k >>> 1)) - 1;
        int newsta2 = sta2 + Math.min(len2, (k >>> 1)) - 1;

        if (nums1[newsta1] > nums2[newsta2]) {
            return getKth(nums1, nums2, sta1, end1, newsta2 + 1, end2, k - (newsta2 - sta2 + 1));
        } else {
            return getKth(nums1, nums2, newsta1 + 1, end1, sta2, end2, k - (newsta1 - sta1 + 1));
        }
    }
}
