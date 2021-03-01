import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class main {

    public static void main(String[] args) {
        main main = new main();
        System.out.println(main.predictPartyVictory("RDD"));

    }

    public String predictPartyVictory(String senate) {
        int len=senate.length();
        Queue<Integer> d = new ArrayDeque<>();
        Queue<Integer> s = new ArrayDeque<>();
        for (int i = 0; i < len; ++i) {
            if (senate.charAt(i) == 'R')
                d.offer(i);
            else
                s.offer(i);
        }
        while (d.size() != 0 && s.size() != 0) {
            int s_cache=s.poll();
            int d_cache=d.poll();
            if(s_cache<d_cache){
                s_cache+=len;
                s.offer(s_cache);
            }
            else {
                d_cache+=len;
                d.offer(d_cache);
            }
        }
        if(s.size()==0)
            return "Radiant";
        else
            return "Dire";
    }
}
