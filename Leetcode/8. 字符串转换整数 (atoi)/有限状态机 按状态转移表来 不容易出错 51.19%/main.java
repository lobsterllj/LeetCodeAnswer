import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();
        formMatrix formMatrix = new formMatrix();

        String s = "  0000000000012345678";
        System.out.println(main.myAtoi(s));

        String s1 = "00000-42a1234";
        System.out.println(main.myAtoi(s1));

        String s2 = "words and 987";
        System.out.println(main.myAtoi(s2));

        String s3 = "";
        System.out.println(main.myAtoi(s3));

        String s4 = " ";
        System.out.println(main.myAtoi(s4));
    }

    public int myAtoi(String s) {
        Automaton automaton = new Automaton();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            automaton.getState(c);
        }
        return (int) (automaton.signed * automaton.res);
    }


    /*
                      +/-(0)    int(1)    " "(2)   other(3)
    start(1)           3          4         1         2
    end(2)             2          2         2         2
    signed(3)          2          4         2         2
    in_number(4)       2          4         2         2
     */
    class Automaton {
        int signed = 1;
        long res = 0;
        private String state = "start";
        private Map<String, String[]> table = new HashMap<>();

        public Automaton() {
            table.put("start", new String[]{"signed", "in_number", "start", "end"});
            table.put("end", new String[]{"end", "end", "end", "end"});
            table.put("signed", new String[]{"end", "in_number", "end", "end"});
            table.put("in_number", new String[]{"end", "in_number", "end", "end"});
        }

        public void getState(char c) {
            if (state.equals("end"))
                return;
            state = table.get(state)[getChar(c)];
            if (state.equals("in_number")) {
                res = res * 10 + (c - '0');
                if (signed == 1) {
                    res = Math.min(res, Integer.MAX_VALUE);
                } else {
                    res = Math.min(res, -((long) Integer.MIN_VALUE));
                }
            }
            if (state.equals("signed")) {
                if (c == '-')
                    signed = -1;
            }
        }

        public int getChar(char c) {
            if (c == '+' || c == '-')
                return 0;
            if (c >= '0' && c <= '9')
                return 1;
            if (c == ' ')
                return 2;
            return 3;
        }
    }
}