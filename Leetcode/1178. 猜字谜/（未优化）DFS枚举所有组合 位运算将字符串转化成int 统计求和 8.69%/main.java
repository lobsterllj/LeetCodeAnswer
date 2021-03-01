import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();
        formMatrix formMatrix = new formMatrix();

//        String[] words = {"aaaa", "asas", "able", "ability", "actt", "actor", "access"};
//        String[] puzzles = {"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"};
//        System.out.println(main.findNumOfValidWords(words, puzzles));


        String[] words = {"apple", "pleas", "please"};
        String[] puzzles = {"aelwxyz", "aelpxyz", "aelpsxy", "saelpxy", "xaelpsy"};
        System.out.println(main.findNumOfValidWords(words, puzzles));

//        System.out.println(main.str_int("zyxuvwt"));

    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> wordsMap = new HashMap<>();
        for (String strW : words) {
            int key = str_int(strW);
            int temp = wordsMap.getOrDefault(key, 0) + 1;
            wordsMap.put(key, temp);
        }
        for (String strP : puzzles) {
            Set<Integer> ret = new HashSet<>();
            char[] chars = strP.toCharArray();
            StringBuilder cache = new StringBuilder();
            cache.append(chars[0]);
            boolean[] visited = new boolean[7];
            backTracking(ret, cache, chars, visited, 1);
            int cnt = 0;
            for (int it : ret) {
                if (wordsMap.containsKey(it))
                    cnt += wordsMap.get(it);
            }
            res.add(cnt);
        }
        return res;
    }

    public void backTracking(Set<Integer> ret, StringBuilder cache, char[] chars, boolean[] visited, int index) {
        String temp = cache.toString();
        ret.add(str_int(temp));

        for (int i = index; i < 7; ++i) {
            if (visited[i])
                continue;
            visited[i] = true;
            cache.append(chars[i]);
            backTracking(ret, cache, chars, visited, index + 1);
            cache.deleteCharAt(cache.length() - 1);
            visited[i] = false;
        }

    }

    public int str_int(String str) {
        char[] chars = str.toCharArray();
        boolean[] hasChar = new boolean[26];
        for (int i = 0; i < chars.length; ++i) {
            hasChar[chars[i] - 'a'] = true;
        }
        int res = 0;
        for (int i = 25; i > -1; --i) {
            res <<= 1;
            if (hasChar[i]) {
                res += 1;
            }
        }
        return res;
    }


}