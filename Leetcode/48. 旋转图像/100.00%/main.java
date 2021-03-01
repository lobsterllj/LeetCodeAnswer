import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        main.rotate(matrix);
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n < 2)
            return;
        int L = 0;
        int T = 0;
        int R = n - 1;
        int B = n - 1;
        while (L < R) {
            for (int i = 0; i < R - L; ++i) {
                int cache = matrix[T][L + i];
                matrix[T][L + i] = matrix[B - i][L];
                matrix[B - i][T] = matrix[B][R - i];
                matrix[B][R - i] = matrix[T + i][R];
                matrix[T + i][R] = cache;
            }
            L++;
            T++;
            R--;
            B--;
        }
    }

}

