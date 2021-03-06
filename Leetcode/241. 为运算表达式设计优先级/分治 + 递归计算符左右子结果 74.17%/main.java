import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();

        String input = "2*3-4*5";
        System.out.println(main.diffWaysToCompute(input));

    }

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new LinkedList<>();
        char[] chars = input.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; ++i) {
            char opr = chars[i];
            if (opr == '+' || opr == '-' || opr == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1, len));
                for (int l : left) {
                    for (int r : right) {
                        res.add(AoprB(l, r, opr));
                    }
                }
            }
        }

        if (res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        return res;
    }

    public int AoprB(int A, int B, char opr) {
        if (opr == '+')
            return A + B;
        else if (opr == '-')
            return A - B;
        else
            return A * B;
    }

}
