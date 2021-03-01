import java.sql.SQLOutput;
import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();

        System.out.println(main.trailingZeroes(33));
    }

    public int trailingZeroes(int n) {
        int cnt=0;
        while (n>=5){
            cnt+=n/5;
            n/=5;
        }
        return cnt;
    }

}
