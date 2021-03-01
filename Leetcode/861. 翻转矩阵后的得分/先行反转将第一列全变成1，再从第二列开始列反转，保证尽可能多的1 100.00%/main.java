public class main {

    public static void main(String[] args) {
        main main = new main();

        int[][] matrix = new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        System.out.println(main.matrixScore(matrix));
        main.prt(matrix);

    }

    public int matrixScore(int[][] A) {
        for (int row = 0; row < A.length; ++row) {
            if (A[row][0] == 0)
                rerverseRow(A, row);
        }
        if (A[0].length == 1)
            return allRowScore(A);
        for (int col = 1; col < A[0].length; ++col) {
            int cnt = 0;
            for (int row = 0; row < A.length; ++row) {
                if (A[row][col] == 0)
                    cnt++;
            }
            if (cnt > (A.length >> 1))
                rerverseCol(A, col);
        }
        return allRowScore(A);
    }

    public int allRowScore(int[][] A) {
        int res = 0;
        for (int i = 0; i < A.length; ++i)
            res += OneRowScore(A[i]);
        return res;
    }

    public int OneRowScore(int[] A) {
        int res = 0;
        for (int i = 0; i < A.length; ++i)
            res = (res << 1) + A[i];
        return res;
    }

    public void rerverseRow(int[][] A, int row) {
        for (int i = 0; i < A[row].length; ++i)
            A[row][i] ^= 1;
    }

    public void rerverseCol(int[][] A, int col) {
        for (int i = 0; i < A.length; ++i)
            A[i][col] ^= 1;
    }

    public void prt(int[][] A) {
        System.out.println("matrix:");
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < A[0].length; ++j) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}
