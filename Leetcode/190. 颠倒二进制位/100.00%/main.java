import java.sql.SQLOutput;
import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        System.out.println(main.reverseBits(3));

    }

    public int reverseBits(int n) {
        int[] org = new int[32];
        int res = 0;
        int index = 0;
        while (index < 32) {
            org[index++] = (n & 1) == 1 ? 1 : 0;
            n = n >>> 1;
        }
        for (int i = 0; i < 32; ++i) {
            System.out.print(org[i]+" ");
            res = (res << 1) + org[i];
        }
        System.out.println();
        return res;
    }

}
