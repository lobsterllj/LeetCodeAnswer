public class Solution {
    public static void main(String[] args) {
        Solution aa = new Solution();
        int[][] in = {{1, 2, 3}, {4, 6, 7}, {8, 11, 13}};
        System.out.println(aa.searchMatr(4, in));

    }

    public int[] searchint(int target, int[] in) {
        int[] res = new int[2];
        int index = 0;
        int hi = in.length;
        int lo = 0;

        while (lo < hi) {
            index = (lo + hi) >> 1;
            if ((target < in[index])) {
                hi = index;
            } else {
                lo = index + 1;
            }
        }

        res[0] = (lo - 1 < 0) ? lo : (lo - 1);
        res[1] = in[res[0]];

        return res;
    }

    public boolean searchMatr(int target, int[][] matrix) {
        boolean flag = false;
        if(matrix.length>0)
        {
            int height = matrix.length;
            int width = matrix[0].length;
            if(width>0)
            {
                int res = 0;
                int res_index = 0;

                int[] math = new int[height];
                int[] matw = new int[width];
                for (int i = 0; i < height; ++i) {
                    math[i] = matrix[i][0];
                }
                int mid_res = searchint(target, math)[0];
                for (int i = 0; i < width; ++i) {
                    matw[i] = matrix[mid_res][i];
                }
                res_index = searchint(target, matw)[0];
                res = searchint(target, matw)[1];

                if (res == target) {
                    flag = true;
                }
            }
        }
        return flag;
    }
}
