import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();

        String s = "eccbbbbdec";
        System.out.println(main.partitionLabels(s));

    }

    public List<Integer> partitionLabels(String S) {
        char[] chars = S.toCharArray();
        List<Integer> res = new ArrayList<>();
        int len = chars.length;
        if (len < 2) {
            res.add(len);
            return res;
        }
        int[] first = new int[26];
        Arrays.fill(first, -1);
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0; i < len; ++i) {
            int cache = chars[i] - 'a';
            if (first[cache] == -1)
                first[cache] = i;
            last[cache] = i;
        }
        List<int[]> block = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            if (first[i] != -1)
                block.add(new int[]{first[i], last[i]});
        }
        block.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[0] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        });

        System.out.println(S);
        int sizeb = block.size();
        for (int i = 0; i < sizeb; ++i) {
            int[] cache = block.get(i);
            System.out.println(cache[0] + "," + cache[1]);
        }

        int[] pre = block.get(0);
        for (int i = 1; i < sizeb; ++i) {
            int[] cur = block.get(i);
            // pre 与 cur 不相交
            if (pre[1] < cur[0]) {
                res.add(pre[1] - pre[0] + 1);
                pre = cur;
            } else {
                int pre1 = Math.max(pre[1], cur[1]);
                int pre0 = pre[0];
                pre = new int[]{pre0, pre1};
            }
        }
        res.add(pre[1] - pre[0] + 1);

        return res;
    }


}
