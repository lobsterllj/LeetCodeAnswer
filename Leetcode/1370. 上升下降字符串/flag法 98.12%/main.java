import org.w3c.dom.Node;

import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        String s = "aabbccddeez";
        System.out.println(main.sortString(s));
    }

    public String sortString(String s) {
        int[] fre = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            fre[s.charAt(i) - 'a']++;
        }
//        for (int i = 0; i < 26; ++i) {
//            System.out.println("fre["+i+"]: "+fre[i]);
//        }
        StringBuilder res = new StringBuilder();
        boolean loop = true;
        boolean changeatleastonce=false;
        boolean increase_Flag = true;
        int index = 0;
        while (loop) {
            changeatleastonce=false;
            while (increase_Flag) {
                if (fre[index] > 0) {
                    res.append((char) (index + 'a'));
                    fre[index]--;
                    changeatleastonce = true;
                }
                index++;
                //System.out.println(index);
                if (index >= 26) {
                    increase_Flag = false;
                    System.out.println(111);
                    index = 25;
                }
            } while (!increase_Flag){
                if (fre[index] > 0) {
                    res.append((char) (index + 'a'));
                    fre[index]--;
                    changeatleastonce = true;
                }
                index--;
                if (index <= -1) {
                    increase_Flag = true;
                    index = 0;
                }
            }
            if(changeatleastonce)
                loop=true;
            else {
                loop=false;
            }
        }

        return res.toString();
    }
}
