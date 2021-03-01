import javafx.css.Size;

import java.lang.invoke.VolatileCallSite;
import java.security.PublicKey;
import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int countNodes(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        dfs(root,res);
        return res.size();
    }

    public void dfs(TreeNode root,List<Integer> res) {
        if(root==null)
            return;
        dfs(root.left,res);
        dfs(root.right,res);
        res.add(0);
    }

    private volatile int cnt=0;
    public int countNodes1(TreeNode root) {
        dfs1(root);
        return cnt;
    }
    public void dfs1(TreeNode root) {
        if(root==null)
            return;
        dfs1(root.left);
        dfs1(root.right);
        cnt++;
    }

}
