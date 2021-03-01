import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class main {
    public static void main(String[] args) {
        main main = new main();
        String string = "vvvlo";
        System.out.println(main.reorganizeString(string));


    }

    public String reorganizeString(String S) {
        if (S.length() == 0)
            return S;
        int[] cnts = new int[26];
        int N = S.length();
        for (int i = 0; i < N; ++i) {
            int index = S.charAt(i) - 'a';
            cnts[index]++;
            if (cnts[index] > ((N >> 1) + 1)) {
                return "";
            }
        }
        for(int i=0;i<26;++i){
            System.out.print(cnts[i]);
        }
        System.out.println();
        PriorityQueue<Character> maxheap = new PriorityQueue<>((c, d) -> cnts[d - 'a'] - cnts[c - 'a']);
        for (int i = 0; i < 26; ++i) {
            if (cnts[i] != 0) {
                char cache = (char) (i + 'a');
                maxheap.add(cache);
            }
        }
        System.out.println(maxheap);
        StringBuilder res = new StringBuilder();
        char lastChar = 'A';
        while (!maxheap.isEmpty()) {
            char temp = maxheap.peek();
            if (temp != lastChar) {
                maxheap.poll();
                cnts[temp - 'a']--;
                lastChar = temp;
                res.append(temp);
                if (cnts[temp - 'a'] != 0) {
                    maxheap.add(temp);
                }
            } else {
                //temp==lastChar
                maxheap.poll();
                if (maxheap.isEmpty()) {
                    return "";
                }
                char secondLarge = maxheap.poll();
                cnts[secondLarge - 'a']--;
                lastChar = secondLarge;
                res.append(secondLarge);
                if (cnts[secondLarge - 'a'] != 0) {
                    maxheap.add(secondLarge);
                }
                maxheap.add(temp);
            }
        }
        return res.toString();
    }


}
