import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {
        main main = new main();
        List<Integer> A=new ArrayList<>();
        A.add(3);
        A.add(2);
        A.add(1);
        List<Integer> B=new ArrayList<>();
        List<Integer> C=new ArrayList<>();
        main.hanota(A,B,C);
        System.out.println("A:"+A);
        System.out.println("B:"+B);
        System.out.println("C:"+C);
    }

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        recur(A.size(), A, C, B);
    }

    public void recur(int num, List<Integer> src, List<Integer> tar, List<Integer> cache) {
        if (num == 1) {
            tar.add(src.get(src.size() - 1));
            src.remove(src.size() - 1);
            return;
        }
        recur(num - 1, src, tar, cache);
        recur(num - 1, tar, cache, src);
        tar.add(src.get(src.size() - 1));
        src.remove(src.size() - 1);
        recur(num - 1, cache, tar, src);
    }

}
