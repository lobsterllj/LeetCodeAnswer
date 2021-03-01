import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        System.out.println(main.permute(new int[]{1,2,3}));

    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new LinkedList<>();
        List<Integer> cache=new LinkedList<>();
        boolean[] visited=new boolean[nums.length];
        dfs(result,nums,cache,visited);
        return result;

    }
    public void dfs(List<List<Integer>> res,int[] nums,List<Integer> oneOfres,boolean[] visited){
        if(oneOfres.size()==nums.length){
            List<Integer> add2res=new ArrayList<>(oneOfres);
            res.add(add2res);
            return;
        }
        for(int i=0;i<nums.length;++i){
            if(visited[i]){
                continue;
            }
            visited[i]=true;
            oneOfres.add(nums[i]);
            dfs(res,nums,oneOfres,visited);
            oneOfres.remove(oneOfres.size()-1);
            visited[i]=false;
        }
    }

}





