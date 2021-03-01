import javafx.css.Size;

import java.lang.invoke.VolatileCallSite;
import java.security.PublicKey;
import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        int[] ints = new int[]{2, 1, 2};
        System.out.println(main.largestPerimeter(ints));

    }

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        int large = n - 1;
        int mid = n - 2;
        int small = n - 3;
        while (small >= 0) {
            if ((A[small] + A[mid]) > A[large]) {
                return A[small] + A[mid] + A[large];
            } else {
                large--;
                mid--;
                small--;
            }
        }
        return 0;
    }


}
