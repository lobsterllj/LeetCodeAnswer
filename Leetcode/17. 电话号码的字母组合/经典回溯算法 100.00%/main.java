import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();

        String digits = "23";
        System.out.println(main.letterCombinations(digits));

    }

    char[][] button = new char[][]{
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };
    int lenD;

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        lenD = digits.length();
        if (lenD == 0)
            return res;
        char[] digitsChar = digits.toCharArray();

        StringBuilder cache = new StringBuilder();
        recall(res, cache, digitsChar, 0);

        return res;
    }

    public void recall(List<String> res, StringBuilder cache, char[] digitsChar, int index) {
        if (cache.length() == lenD) {
            res.add(cache.toString());
            return;
        }
        int num = digitsChar[index] - '2';
        for (int i = 0; i < button[num].length; ++i) {
            cache.append(button[num][i]);
            recall(res, cache, digitsChar, index + 1);
            cache.deleteCharAt(cache.length() - 1);
        }

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
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
        }

    }


}
