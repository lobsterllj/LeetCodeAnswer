import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        String s = "LEETCODEISHIRING";
        System.out.println(main.convert(s, 3));

    }

    public boolean wordPattern(String pattern, String s) {
        char[] ps = pattern.toCharArray();
        String[] ss = s.split(" ");
        if (ps.length != ss.length)
            return false;
        Map<String, Integer> map = new HashMap<>();


        for (int i = 0; i < ss.length; ++i) {

            if (!map.containsKey(ss[i])) {
                map.put(ss[i], ps[i] - 'a');
            }
            if (map.get(ss[i]) != ps[i] - 'a')
                return false;

        }
        Set<Integer> cnt = new HashSet<>();
        for (String it : map.keySet()) {
            cnt.add(map.get(it));
        }
        return cnt.size() == map.size();
    }

    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() < 2)
            return s;
        char[] ss = s.toCharArray();
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 0; i < numRows; ++i) {
            List<Character> temp = new LinkedList<>();
            map.put(i, temp);
        }
//        System.out.println(map.size());
        int n = ss.length;
        int oneLoop;
        if (numRows < 3)
            oneLoop = numRows;
        else {
            oneLoop = (numRows - 1) << 1;
        }
        for (int i = 0; i < n; ++i) {
//            System.out.println(map);
            int j = i % oneLoop;
            if (j < numRows) {
//                System.out.println("rowsD:" + j);
//                System.out.println("j:" + j);
                List<Character> cache = map.get(j);
                cache.add(ss[i]);
                map.put(j, cache);
            } else {
//                System.out.println("rowsU:" + ((2 * numRows) - j - 2));
//                System.out.println("j:" + j);
                List<Character> cache = map.get((2 * numRows) - j - 2);
                cache.add(ss[i]);
                map.put((2 * numRows) - j - 2, cache);
            }
        }
//        System.out.println(map);
        StringBuilder res = new StringBuilder();
        for (int it : map.keySet()) {
            List<Character> cache = map.get(it);
            for (char that : cache)
                res.append(that);
        }
        return res.toString();
    }
}
