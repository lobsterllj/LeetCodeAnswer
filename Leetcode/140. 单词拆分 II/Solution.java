import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution aa = new Solution();

        String in = "catsand";
        List<String> test = new LinkedList<String>();
        test.add("cats");
        test.add("cat");
        test.add("and");
        test.add("sand");

        //System.out.println(aa.compare(in, test));
        List<String> res = new LinkedList<>();
        List<String> cache = new LinkedList<>();
        int index_s = 0;
        int last_index_S = 0;
        if (aa.compare(in, test)) {
            aa.wordBrea(in, test, res, cache, index_s, last_index_S);
        }
        for (String a : res) {
            System.out.println(a);
        }
    }

    public static String listToString(List list, char separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }

    public void wordBrea(String s, List<String> wordDict, List<String> res, List<String> cache, int index_s, int last_index_S) {

        if (index_s == s.length()) {
            cache = new LinkedList<>(cache);
            String aa = listToString(cache, ' ');
            res.add(aa);
        } else {
            for (int i = 1; i < s.length() + 1; ++i) {
                for (int j = index_s; j < i; ++j) {
                    if (wordDict.contains(s.substring(j, i))) {
                        if (last_index_S == j) {
                            cache.add(s.substring(j, i));
                            wordBrea(s, wordDict, res, cache, i, i);
                            cache.remove(cache.size() - 1);
                        }
                    }
                }
            }
        }
    }


    public boolean compare(String s, List<String> wordDict) {
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;

        for (int i = 1; i < s.length() + 1; ++i) {
            for (int j = 0; j < i; ++j) {
                if (res[j] && wordDict.contains(s.substring(j, i))) {
                    res[i] = true;
                    //break;
                }
            }
        }
//        for (int i = 0; i < res.length; ++i) {
//            System.out.println("res[" + i + "]:" + res[i]);
//        }
        return res[s.length()];
    }


}
