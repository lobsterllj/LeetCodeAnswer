import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] ints = new int[]{5, 3, 1, 4, 2};

        System.out.println(main.wordPattern("abba", "dog dog dog dog"));
        System.out.println(main.wordPattern("abba", "dog cat cat fish"));

    }

    public boolean wordPattern(String pattern, String s) {
        char[] ps = pattern.toCharArray();
        String[] ss = s.split(" ");
        if (ps.length != ss.length)
            return false;
        Map<String,Integer> map = new HashMap<>();


        for (int i = 0; i < ss.length; ++i) {

            if (!map.containsKey(ss[i])) {
                map.put(ss[i],ps[i] - 'a' );
            }
            if (map.get(ss[i])!=ps[i]-'a')
                return false;

        }
        Set<Integer> cnt=new HashSet<>();
        for(String it:map.keySet()){
            cnt.add(map.get(it));
        }
        return cnt.size()==map.size();
    }

}
