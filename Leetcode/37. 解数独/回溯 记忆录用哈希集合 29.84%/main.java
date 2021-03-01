import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class main {

    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();
        formMatrix formMatrix = new formMatrix();
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},  //1
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},  //2
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},  //3
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},  //4
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},  //5
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},  //6
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},  //7
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},  //8
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},  //9
        };

        main.solveSudoku(board);
        prtMatrix.prtMatrix(board);

//        System.out.println((char) (1 + (int) '0'));
//        System.out.println(main.get33(0, 5));
//        System.out.println(main.get33(1, 3));

    }


    public int get33(int row, int col) {
        int res = 0;
        if (row < 3) {
            if (col < 3) {
                res = 0;
            } else if (col >= 3 && col < 6) {
                res = 1;
            } else {
                res = 2;
            }
        } else if (row >= 3 && row < 6) {
            if (col < 3) {
                res = 3;
            } else if (col >= 3 && col < 6) {
                res = 4;
            } else {
                res = 5;
            }
        } else {
            if (col < 3) {
                res = 6;
            } else if (col >= 3 && col < 6) {
                res = 7;
            } else {
                res = 8;
            }
        }
        return res;
    }

    int len;
    boolean flag;

//    char[][] temp;

    public void solveSudoku(char[][] board) {
        List<Set<Integer>> rowset = new ArrayList<>();
        List<Set<Integer>> colset = new ArrayList<>();
        List<Set<Integer>> digset = new ArrayList<>();

        for (int i = 0; i < 9; ++i) {
            rowset.add(new HashSet<>(9));
            colset.add(new HashSet<>(9));
            digset.add(new HashSet<>(9));
        }

        List<int[]> uninsert = new ArrayList<>();
//        temp = new char[9][9];
        for (int row = 0; row < 9; ++row) {
            for (int col = 0; col < 9; ++col) {
//                temp[row][col] = board[row][col];
                if (board[row][col] == '.') {
                    uninsert.add(new int[]{row, col});
                } else {
                    int val = board[row][col] - '0';
                    rowset.get(row).add(val);
                    colset.get(col).add(val);
                    digset.get(get33(row, col)).add(val);
                }
            }
        }
        len = uninsert.size();
        flag = false;

//        System.out.println(rowset);
//        System.out.println(colset);
//        System.out.println(digset);

        backTracking(board, rowset, colset, digset, uninsert, 0);

    }

    public void backTracking(char[][] board, List<Set<Integer>> rowset, List<Set<Integer>> colset, List<Set<Integer>> digset, List<int[]> uninsert, int index) {
        if (flag)
            return;
        if (index >= len) {
//            for (int row = 0; row < 9; ++row) {
//                for (int col = 0; col < 9; ++col) {
//                    board[row][col] = temp[row][col];
//                }
//            }
            flag = true;
            return;
        }
//        prtMatrix prtMatrix = new prtMatrix();
//        prtMatrix.prtMatrix(temp);
        int[] xy = uninsert.get(index);
        int row = xy[0];
        int col = xy[1];
        int dig = get33(row, col);
//        System.out.println(row + "-" + col + "-" + get33(row, col));
        for (int i = 1; i <= 9; ++i) {
//            System.out.println(dig + "-" + i);
//            System.out.println(Digvisited[dig][i]);
            if (rowset.get(row).contains(i) || colset.get(col).contains(i) || digset.get(dig).contains(i)) {
//                System.out.println(i);
                continue;
            }
            rowset.get(row).add(i);
            colset.get(col).add(i);
            digset.get(dig).add(i);
            board[row][col] = (char) (i + (int) '0');

//            temp[row][col] = (char) (i + (int) '0');
            backTracking(board, rowset, colset, digset, uninsert, index + 1);
            if (flag)
                return;
            rowset.get(row).remove(i);
            colset.get(col).remove(i);
            digset.get(dig).remove(i);
            board[row][col] = '.';
//            temp[row][col] = '.';
        }

    }



}