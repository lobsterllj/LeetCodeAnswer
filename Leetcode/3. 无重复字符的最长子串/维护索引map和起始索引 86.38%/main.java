import jdk.swing.interop.SwingInterOpUtils;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class main {

    public static void main(String[] args) {
        main main = new main();
        System.out.println(main.lengthOfLongestSubstring("abba"));

    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        char[] chars = s.toCharArray();
        Map<Character, Integer> lastIndex = new HashMap<>();
        int start = 0;
        int res = 1;
        int[] len = new int[chars.length];
        for (int i = 0; i < chars.length; ++i) {
            if (lastIndex.containsKey(chars[i])) {
                if (start <= lastIndex.get(chars[i]))
                    start = lastIndex.get(chars[i]) + 1;
            }
            lastIndex.put(chars[i], i);
            len[i] = i - start + 1;
            res = Math.max(res, i - start + 1);
        }
        for (int i = 0; i < chars.length; ++i)
            System.out.println("i:" + i + " len:" + len[i] + "  ");
        return res;
    }

}
