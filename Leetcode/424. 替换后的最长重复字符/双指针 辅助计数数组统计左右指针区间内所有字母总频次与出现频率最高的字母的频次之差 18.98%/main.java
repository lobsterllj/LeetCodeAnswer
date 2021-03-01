import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();

        String s = "AABABBA";
        int k = 1;
        System.out.println(main.characterReplacement(s, k));

    }

    public int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        if (len < 2)
            return len;
        int sta = 0;
        int end = 0;
        int res = 1;
        int[] cnts = new int[26];
        cnts[chars[end] - 'A']++;


        while (sta < len && end < len) {
            //sta右移
            if (getSumsubLarge(cnts) > k) {
                cnts[chars[sta] - 'A']--;
                sta++;
            }
            //end右移
            else {
                res = Math.max(res, end - sta + 1);
                end++;
                if (end == len)
                    return res;
                cnts[chars[end] - 'A']++;
            }
        }
        return res;
    }

    public int getSumsubLarge(int[] cnts) {
        int sum = 0;
        int large = 0;
        for (int i = 0; i < cnts.length; ++i) {
            large = Math.max(large, cnts[i]);
            sum += cnts[i];
        }
        return sum - large;
    }


    private class unionFind {
        int[] fathers;
        int[] size;
        int groupNum;

        public unionFind(int n) {
            fathers = new int[n];
            size = new int[n];
            groupNum = n;
            for (int i = 0; i < n; ++i) {
                fathers[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (x != fathers[x]) {
                fathers[x] = find(fathers[x]);
            }
            return fathers[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY)
                return;
            if (size[rootX] < size[rootY]) {
                fathers[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                fathers[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            groupNum--;
            return;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }


}
