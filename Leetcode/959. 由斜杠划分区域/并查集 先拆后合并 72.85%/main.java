import java.util.Locale;
import java.util.PriorityQueue;

public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();

//        String a = "dabadd";
//        String b = "cda";
//        System.out.println(main.minCharacters(a, b));

//        int[][] matrix = new int[][]{
//                {5, 2},
//                {1, 6}
//        };
//        System.out.println(main.kthLargestValue(matrix,1));

        String[] grid = new String[]{
                " /",
                "/ "
        };
        System.out.println(main.regionsBySlashes(grid));

    }

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;

        unionFind unionFind = new unionFind(4 * n * n);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                unionFind.union(4 * ((i - 1) * n + j) + 2, 4 * (i * n + j));
            }
        }
        for (int j = 1; j < n; ++j) {
            for (int i = 0; i < n; ++i) {
                unionFind.union(4 * (i * n + (j - 1)) + 1, 4 * (i * n + j) + 3);
            }
        }

        for (int i = 0; i < n; ++i) {
            char[] chars = grid[i].toCharArray();
            for (int j = 0; j < n; ++j) {
                if (chars[j] == ' ') {
                    unionFind.union(4 * (i * n + j), 4 * (i * n + j) + 1);
                    unionFind.union(4 * (i * n + j) + 1, 4 * (i * n + j) + 2);
                    unionFind.union(4 * (i * n + j) + 2, 4 * (i * n + j) + 3);
                } else if (chars[j] == '/') {
                    unionFind.union(4 * (i * n + j), 4 * (i * n + j) + 3);
                    unionFind.union(4 * (i * n + j) + 1, 4 * (i * n + j) + 2);
                } else {
                    unionFind.union(4 * (i * n + j), 4 * (i * n + j) + 1);
                    unionFind.union(4 * (i * n + j) + 2, 4 * (i * n + j) + 3);
                }
            }
        }

        return unionFind.groupNum;
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

    public int minCharacters(String a, String b) {
//        prtInts prtInts = new prtInts();
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int sumA = charsA.length;
        int sumB = charsB.length;
        int[] cntsA = new int[26];
        int[] cntsB = new int[26];
        int[] cntsAB = new int[26];
        for (int i = 0; i < charsA.length; ++i) {
            cntsA[charsA[i] - 'a']++;
            cntsAB[charsA[i] - 'a']++;
        }
//        prtInts.prt(cntsA);
        for (int i = 0; i < charsB.length; ++i) {
            cntsB[charsB[i] - 'a']++;
            cntsAB[charsB[i] - 'a']++;
        }
//        prtInts.prt(cntsB);
//        prtInts.prt(cntsAB);

        int mostcnt = 0;
        int mostindex = 0;
        for (int i = 0; i < 26; ++i) {
            if (cntsAB[i] > mostcnt) {
                mostindex = i;
                mostcnt = cntsAB[i];
            }
        }

        int res3 = 0;
        for (int i = 0; i < 26; ++i) {
            if (i != mostindex) {
                res3 += cntsAB[i];
            }
        }

//        System.out.println(res3);

        int[] Aleft2right = new int[26];
        Aleft2right[0] = cntsA[0];
        for (int i = 1; i < 26; ++i) {
            Aleft2right[i] = cntsA[i] + Aleft2right[i - 1];
        }

        int[] Bleft2right = new int[26];
        Bleft2right[0] = cntsB[0];
        for (int i = 1; i < 26; ++i) {
            Bleft2right[i] = cntsB[i] + Bleft2right[i - 1];
        }

//        prtInts.prt(Aleft2right);
//        prtInts.prt(Bleft2right);


        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 25; ++i) {
            int moveArigth2left = sumA - Aleft2right[i];
            int moveAleft2right = Aleft2right[i];
            int moveBrigth2left = sumB - Bleft2right[i];
            int moveBleft2right = Bleft2right[i];

            int res1 = moveAleft2right + moveBrigth2left;
            int res2 = moveBleft2right + moveArigth2left;

            int resc = Math.min(res1, res2);
            res = Math.min(res, resc);
//            System.out.println("i:" + i + " res:" + res);

        }
        return Math.min(res, res3);
    }


    public int kthLargestValue(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
//        prtMatrix prtMatrix=new prtMatrix();
//        System.out.println(rows);
        int[][] mat = new int[rows][cols];
        for (int row = 0; row < rows; ++row) {
            mat[row][0] = matrix[row][0];
        }
//        mat[1][0] = matrix[1][0];
//        for (int col = 0; col < cols; ++cols) {
//            mat[0][col] = matrix[0][col];
//        }
//        prtMatrix.prtMatrix(matrix);

//        prtMatrix.prtMatrix(mat);

        for (int row = 0; row < rows; ++row) {
            for (int col = 1; col < cols; ++col) {
                mat[row][col] = mat[row][col - 1] ^ matrix[row][col];
            }
        }
        for (int col = 0; col < cols; ++col) {
            for (int row = 1; row < rows; ++row) {
                mat[row][col] = mat[row - 1][col] ^ mat[row][col];
            }
        }
//        prtMatrix.prtMatrix(mat);
        PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                maxheap.add(mat[row][col]);
            }
        }
//        System.out.println(maxheap);

        int res = 0;
        while (k > 0) {
            res = maxheap.poll();
//            System.out.println(maxheap);
            k--;
        }
        return res;
    }

    public String maximumTime(String time) {
        String[] times = time.split(":");
        char[] chars = time.toCharArray();
        char[] reschar = new char[5];
        reschar[2] = ':';
        if (chars[0] == '2') {
            reschar[0] = chars[0];
            if (chars[1] == '?') {
                reschar[1] = '3';
            } else {
                reschar[1] = chars[1];
            }
            if (chars[3] == '?') {
                reschar[3] = '5';
            } else {
                reschar[3] = chars[3];
            }
            if (chars[4] == '?') {
                reschar[4] = '9';
            } else {
                reschar[4] = chars[4];
            }
        } else if (chars[0] == '?') {
            if (chars[1] == '?' || chars[1] <= '3') {
                reschar[0] = '2';
                if (chars[1] == '?') {
                    reschar[1] = '3';
                } else {
                    reschar[1] = chars[1];
                }
                if (chars[3] == '?') {
                    reschar[3] = '5';
                } else {
                    reschar[3] = chars[3];
                }
                if (chars[4] == '?') {
                    reschar[4] = '9';
                } else {
                    reschar[4] = chars[4];
                }
            } else {
                reschar[0] = '1';
                if (chars[1] == '?') {
                    reschar[1] = '9';
                } else {
                    reschar[1] = chars[1];
                }
                if (chars[3] == '?') {
                    reschar[3] = '5';
                } else {
                    reschar[3] = chars[3];
                }
                if (chars[4] == '?') {
                    reschar[4] = '9';
                } else {
                    reschar[4] = chars[4];
                }
            }
        } else {
            reschar[0] = chars[0];
            if (chars[1] == '?') {
                reschar[1] = '9';
            } else {
                reschar[1] = chars[1];
            }
            if (chars[3] == '?') {
                reschar[3] = '5';
            } else {
                reschar[3] = chars[3];
            }
            if (chars[4] == '?') {
                reschar[4] = '9';
            } else {
                reschar[4] = chars[4];
            }
        }
        StringBuilder res = new StringBuilder();
        for (char it : reschar) {
            res.append(it);
        }
        return res.toString();
    }
}
