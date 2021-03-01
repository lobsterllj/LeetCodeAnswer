import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] ints = new int[]{6, 7, 5, 2, 4, 5, 9, 3};
        int[] ints1 = new int[]{2, 1, 5, 6, 2, 3};
        int[] ints2 = new int[]{1, 1};
        char[][] ma = new char[][]{{'0', '1'}, {'1', '0'}};
        System.out.println(main.largestRectangleArea(ints));
//        System.out.println(main.maximalRectangle(ma));
    }

//    public int maximalRectangle(char[][] matrix) {
//        int rows = matrix.length;
//        if (rows == 0)
//            return 0;
//        int cols = matrix[0].length;
//        if (cols == 0)
//            return 0;
//        int[][] heights = new int[rows][cols];
//        for (int row = 0; row < rows; ++row) {
//            for (int col = 0; col < cols; ++col) {
//                if (row == 0) {
//                    heights[row][col] = matrix[row][col] - '0';
//                } else {
//                    if (heights[row - 1][col] != 0 && ((matrix[row][col] - '0') != 0))
//                        heights[row][col] = heights[row - 1][col] + (matrix[row][col] - '0');
//                    else {
//                        heights[row][col] = matrix[row][col] - '0';
//                    }
//                }
//            }
//        }
//
//        System.out.println("heights:");
//        for (int row = 0; row < rows; ++row) {
//            for (int col = 0; col < cols; ++col) {
//                System.out.print(heights[row][col] + " ");
//            }
//            System.out.println();
//        }
//
//        int res = 0;
//        for (int row = 0; row < rows; ++row) {
//            res = Math.max(res, largestRectangleArea(heights[row]));
//        }
//        return res;
//    }

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0)
            return 0;
        if (len == 1)
            return heights[0];

        Deque<Integer> stack = new ArrayDeque<>();
        //单调递增栈

        int[] left2right = new int[len];
        stack.addLast(0);
        left2right[0] = -1;
        for (int i = 1; i < len; ++i) {
            while (!stack.isEmpty() && heights[stack.peekLast()] >= heights[i]) {
                stack.pollLast();
            }
            if (stack.isEmpty())
                left2right[i] = -1;
            else {
                left2right[i] = stack.peekLast();
            }
            stack.addLast(i);
        }
        stack.clear();

        int[] right2left = new int[len];
        stack.addLast(len - 1);
        right2left[len - 1] = len;
        for (int i = len - 2; i > -1; --i) {
            while (!stack.isEmpty() && heights[stack.peekLast()] >= heights[i]) {
                stack.pollLast();
            }
            if (stack.isEmpty())
                right2left[i] = len;
            else {
                right2left[i] = stack.peekLast();
            }
            stack.addLast(i);
        }
        stack.clear();
        int res = 0;
        for (int i = 0; i < len; ++i) {
            res = Math.max(heights[i] * (right2left[i] - left2right[i] - 1), res);
        }
//        System.out.println("left2right:");
//        for (int m = 0; m < len; ++m) {
//            System.out.print(left2right[m] + " ");
//        }
//        System.out.println();
//        System.out.println("right2left:");
//        for (int m = 0; m < len; ++m) {
//            System.out.print(right2left[m] + " ");
//        }
//        System.out.println();
        return res;
    }
}

