import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();

    }

    public int numIslands(char[][] grid) {
        int res=0;
        for(int i=0;i< grid.length;++i){
            for (int j=0;j<grid[0].length;++j){
                if(grid[i][j]=='1'){
                    res++;
                    infect(grid,i,j);
                }
            }
        }
        return res;
    }
    public void infect(char[][] grid,int i,int j){
        if(i<0||j<0||i> grid.length-1||j> grid[0].length-1||grid[i][j]!='1')
            return;
        grid[i][j]='2';
        infect(grid,i+1,j);
        infect(grid,i-1,j);
        infect(grid,i,j+1);
        infect(grid,i,j-1);

    }

}
