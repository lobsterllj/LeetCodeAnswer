import jdk.swing.interop.SwingInterOpUtils;

import javax.lang.model.type.IntersectionType;
import java.net.http.WebSocketHandshakeException;
import java.sql.SQLOutput;
import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] ints = new int[]{1, -2, -5, -4, -3, 3, 3, 5};


//        List res = main.fourSum(ints, -11);
//        res.forEach(it -> System.out.println(it));

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        midtraver(root,res);
        return res;
    }
    public void midtraver(TreeNode root,List<Integer> res){
        if (root==null)
            return;
        midtraver(root.left,res);
        res.add(root.val);
        midtraver(root.right,res);
    }


}
