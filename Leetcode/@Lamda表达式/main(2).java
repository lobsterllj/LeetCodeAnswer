import java.sql.Array;
import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        int[] ints = new int[]{0, 1, 2, 3, 4};
        List<Integer> ints_list = Arrays.asList(0, 1, 2, 3, 4);
        System.out.println("第一次打印：");
        ints_list.forEach((it) -> System.out.println(it + " "));

        Collections.sort(ints_list, (a, b) -> {
            if (a < b) {
                return 1;
            } else if (a == b) {
                return 0;
            }else {
                return -1;
            }


        });
        System.out.println("第二次打印：");
        ints_list.forEach((it) -> System.out.println(it + " "));
//        String[] atp = {"1", "2", "3"};
//        List<String> players =  Arrays.asList(atp);
//        players.forEach((player) -> System.out.print(player + "; "));

        Lambda l = (int a) -> {
            System.out.println(a);
            return 0;
        };
        System.out.println("第三次打印：");
        l.test(2);
    }

    public interface Lambda {
        public int test(int a);
    }


}
