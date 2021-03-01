import jdk.swing.interop.SwingInterOpUtils;

import java.util.HashMap;
import java.util.List;

public class main {

    public static void main(String[] args) {
        main main = new main();
        System.out.println(main.titleToNumber("ZY"));
    }

    public int titleToNumber(String s) {
        if(s.length()==0)
            return 0;
        int res=0;
        int cache=0;
        for(int i=0;i<s.length();++i){
            cache=(s.charAt(i)-'A')+1;
            //System.out.println(cache);
            res=26*res+cache;
        }
        return res;
    }


}
