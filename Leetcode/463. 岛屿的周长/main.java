import java.util.HashSet;
import java.util.Set;

public class main {
    public static void main(String[] args) {
        main aa = new main();

        int[][] ints=new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(aa.islandPerimeter(ints));

    }

    public int islandPerimeter(int[][] grid) {
        int y_len = grid.length;
        if (y_len != 0) {
            int x_len = grid[0].length;
            int cnts = 0;
            for (int i = 0; i < y_len; ++i) {
                for (int j = 0; j < x_len; ++j) {
                    if (grid[i][j]==1)
                    {
                        if(i-1<0||grid[i-1][j]==0)
                            cnts++;
                        if(j-1<0||grid[i][j-1]==0)
                            cnts++;
                        if(i>y_len-2||grid[i+1][j]==0)
                            cnts++;
                        if(j>x_len-2||grid[i][j+1]==0)
                            cnts++;
                    }
                }
            }
            return cnts;
        }
        return 0;
    }

}
