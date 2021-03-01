public class main {

    public static void main(String[] args) {
        main main = new main();

        int[][] matrix = new int[][]{{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};

        System.out.println(main.findNumberIn2DArray(matrix, 9));
        main.prt(matrix);

    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return find(matrix, 0, matrix[0].length - 1, target);
    }

    public boolean find(int[][] matrix, int row, int col, int target) {
        boolean flag1 = false;
        boolean flag2 = false;
        System.out.println("m[" + row + "][" + col + "]:" + matrix[row][col]);
        if (matrix[row][col] == target) {
            return true;
        } else if (matrix[row][col] > target) {
            if (col - 1 >= 0) {
                flag1 = find(matrix, row, col - 1, target);
            }
        } else {
            if (row + 1 < matrix.length) {
                flag2 = find(matrix, row + 1, col, target);
            }
        }
        return flag1 || flag2;
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
