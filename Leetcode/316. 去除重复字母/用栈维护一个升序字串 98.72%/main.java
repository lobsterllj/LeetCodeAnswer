import java.util.Deque;
import java.util.LinkedList;

public class main {

    public static void main(String[] args) {
        main main = new main();
        String s = "abacb";
        String s1 = "bcabc";
        String s2 = "cbacdcbc";
        String s3 = "bbcaac";
        String s4 = "cddacd";
        System.out.println(main.removeDuplicateLetters(s));
        System.out.println(main.removeDuplicateLetters(s1));
        System.out.println(main.removeDuplicateLetters(s2));
        System.out.println(main.removeDuplicateLetters(s3));
        System.out.println(main.removeDuplicateLetters(s4));
    }

    public String removeDuplicateLetters(String s) {
        if (s.length() == 1)
            return s;
        int[] after = new int[26];
        int[] before = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            after[chars[i] - 'a']++;
        }
        Deque<Character> stack = new LinkedList<>();
        //stack维护一个升序的字串

        char last;
        for (int i = 0; i < chars.length; ++i) {
            //chars[i] 前有chars[i] ，直接跳过此chars[i]
            if(before[chars[i]-'a']>0){
                after[chars[i] - 'a']--;
                continue;
            }
            for (int j = stack.size(); j > 0; --j) {
                last = stack.peekLast();
                if (chars[i] < last) {
                    //chars[i]<last
                    if (after[last - 'a'] > 0) {
                        //chars[i] 后有last：after[last-'a']>0
                        //弹出last
                        stack.pollLast();
                        before[last - 'a']--;
                    }
                }
            }
            stack.addLast(chars[i]);
            before[chars[i] - 'a']++;
            after[chars[i] - 'a']--;
            System.out.println(stack);
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pollFirst());
        }
        return res.toString();
    }


}

