public class Solution {
    public static void main(String[] args) {

        Solution aa=new Solution();
        int[][] in={{-5}};
        System.out.println(aa.searchMat2(in,-10));

    }

    public boolean searchMat2(int[][] matrix, int target) {
        boolean res_flag=false;
        if(matrix.length>0)
        {
            int height = matrix.length;
            int width = matrix[0].length;
            if(width>0) {
                int selected_i=0;
                int selected_j=width-1;
                while (true)
                {
                    if(selected_j<0||selected_i>height-1)
                    {
                        break;
                    }
                    else if(target==matrix[selected_i][selected_j])
                    {
                        res_flag=true;
                        break;
                    }
                    else if (target<matrix[selected_i][selected_j])
                    {
                        selected_j--;
                    }
                    else
                    {
                        selected_i++;
                    }
                }
            }
        }

        return res_flag;
    }


}
