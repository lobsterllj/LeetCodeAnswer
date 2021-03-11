package ACM-I0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import Helper.*;
public class nowcoderIO {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        List<int[]> list_In = new ArrayList<>();
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            System.out.println(s.length);
            int[] ints = new int[s.length];
            for (int i = 0; i < s.length; ++i) {
                ints[i] = Integer.parseInt(s[i]);
            }
            list_In.add(ints);
            prtArray prtArray = new prtArray();
            for (int[] it : list_In) {
                prtArray.prt(it);
            }
        }

    }
}
