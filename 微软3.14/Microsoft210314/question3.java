package Microsoft210314;

public class question3 {
    public static void main(String[] args) {
        question3 quetion3 = new question3();
//        int U = 3;
//        int L = 2;
//        int[] C = new int[]{2, 1, 1, 0, 1};

//        int U = 2;
//        int L = 3;
//        int[] C = new int[]{0, 0, 1, 1, 2};

        int U = 2;
        int L = 2;
        int[] C = new int[]{2, 0, 2, 0};
        System.out.println(quetion3.solution(U, L, C));
    }

    public String solution(int U, int L, int[] C) {
        // write your code in Java SE 8
        int Cols = C.length;
        int[][] matrix = new int[2][Cols];
        int SumOfC1 = 0;
        for (int i = 0; i < Cols; ++i) {
            if (C[i] == 2) {
                matrix[0][i] = 1;
                matrix[1][i] = 1;
                U--;
                L--;
                if (U < 0 || L < 0) {
                    return "IMPOSSIBLE";
                }
            } else if (C[i] == 1) {
                SumOfC1++;
            }
        }
        if (SumOfC1 != (U + L)) {
            return "IMPOSSIBLE";
        }
        for (int i = 0; i < Cols; ++i) {
            if (C[i] == 1) {
                if (L > 0) {
                    matrix[1][i] = 1;
                    L--;
                } else {
                    matrix[0][i] = 1;
                    U--;
                }
                if (L < 0 || U < 0) {
                    return "IMPOSSIBLE";
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < Cols; ++j) {
                res.append(matrix[i][j]);
            }
            if (i == 0)
                res.append(',');
        }
        return res.toString();
    }
}
