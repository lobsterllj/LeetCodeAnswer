import javafx.css.Size;

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
        if(root==null)
            return 0;
        Deque<TreeNode> unvisited=new ArrayDeque<>();
        int res=1;
        unvisited.addLast(root);
        while (!unvisited.isEmpty()){
            for(int i=unvisited.size();i>0;--i){
                TreeNode cache=unvisited.pollFirst();
                if(cache.left!=null){
                    unvisited.addLast(cache.left);
                    res++;
                }
                if(cache.right!=null){
                    unvisited.addLast(cache.right);
                    res++;
                }
            }
        }
        return res;
    }


}
