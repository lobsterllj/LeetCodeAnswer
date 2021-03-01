import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

public class main {

    public static void main(String[] args) {
        main main = new main();
        System.out.println(main.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(main.lengthOfLongestSubstring("bbbbb"));
        System.out.println(main.lengthOfLongestSubstring("au"));
        System.out.println(main.lengthOfLongestSubstring("dvdf"));
        System.out.println(main.lengthOfLongestSubstring("pwwkew"));
        System.out.println(main.lengthOfLongestSubstring("aaa"));


    }

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2)
            return len;
        char[] chars = s.toCharArray();
        int sta = 0;

        int max = 1;
        Map<Character, Integer> char2index = new HashMap<>();

        for (int end = 0; end < len; ++end) {
            if (char2index.containsKey(chars[end])&&sta<=char2index.get(chars[end])) {
                sta=char2index.get(chars[end])+1;
            }
            char2index.put(chars[end],end);
            max = Math.max(max, end - sta + 1);
//            System.out.println("sta:" + sta);
//            System.out.println("end:" + end);
//            System.out.println(char2index);
//            System.out.println("max:" + max);
        }
        return max;
    }


}

