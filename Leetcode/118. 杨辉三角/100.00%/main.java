import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        System.out.println(main.generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        List<Integer> row0 = new ArrayList<>();
        row0.add(1);
        res.add(row0);
        if (numRows > 1) {
            for (int i = 1; i < numRows; ++i) {
                List<Integer> rowPre = res.get(i - 1);
                List<Integer> rowi = new ArrayList<>();
                rowi.add(1);
                for (int j = 1; j < i; ++j) {
                    rowi.add(rowPre.get(j-1)+rowPre.get(j));
                }
                rowi.add(1);
                res.add(rowi);
            }
        }
        return res;
    }
}
