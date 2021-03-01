import javafx.css.Size;

import java.lang.invoke.VolatileCallSite;
import java.security.PublicKey;
import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();

    }

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        if (nums.length <= 2)
            return;
        int n = nums.length;
        int[] res = new int[n];
        int i = 0, j = n-1,j_s=0;
        if (n % 2 == 0) {
            i = n / 2 - 1;
        } else {
            i = n / 2;
        }
        j_s=i;
        int index = 0;
        while (index < n) {
            if (i > -1)
                res[index++] = nums[i--];
            if (j > j_s)
                res[index++] = nums[j--];
        }
        for (int k = 0; k < n; k++)
            nums[k] = res[k];
        return;
    }

}
