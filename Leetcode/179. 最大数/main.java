import javax.sound.midi.Soundbank;
import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        int[] ints=new int[]{0,0,0,1};
        System.out.println(main.largestNumber(ints));

    }
    public String largestNumber(int[] nums) {
        String[] strings=new String[nums.length];
        boolean allZero=true;
        for (int i = 0; i < strings.length; i++) {
            if(nums[i]!=0)
                allZero=false;
            strings[i]=String.valueOf(nums[i]);
        }
        if(allZero)
            return "0";
        Comparator<String> stringComparator=new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return -(s+t1).compareTo(t1+s);
            }
        };
        Arrays.sort(strings,stringComparator);
        String res="";
        for(int i=0;i<strings.length;++i){
            res+=strings[i];
        }

        return res;
    }

}





