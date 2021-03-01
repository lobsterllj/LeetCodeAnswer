import java.sql.SQLOutput;
import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        System.out.println(main.fractionToDecimal(4,333));

    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        StringBuilder res = new StringBuilder();
        long nume = Long.valueOf(numerator);
        long deno = Long.valueOf(denominator);
        if ((nume > 0 && deno < 0) || (nume < 0 && deno > 0))
            res.append("-");
        res.append(Math.abs(nume / deno));
        long reminder = nume % deno;
        if (reminder == 0)
            return res.toString();
        res.append(".");
        Map<Long, Integer> rem_index = new HashMap<>();
        while (reminder != 0) {
            if (rem_index.containsKey(reminder)) {
                res.insert(rem_index.get(reminder),"(");
                res.append(")");
                break;
            }
            rem_index.put(reminder, res.length());
            nume = reminder * 10;
            res.append(Math.abs(nume / deno));
            reminder = nume % deno;
        }
        return res.toString();
    }
}
